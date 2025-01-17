/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RaceConditionReproducerTest {
    private final static String SOME_VALID_SEQUENCE_3_3 = "B1|A1|A2|B2|A3|B3";

    private static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; ++i) res *= i;
        return res;
    }

    RaceConditionReproducer eventProcessor;

    @BeforeEach
    public void setup() {
        eventProcessor = new RaceConditionReproducer();
    }

    @AfterEach
    public void tearDown() {
        TraceHelperForTest.cleanup();
    }

    private void run3_3_TestAction() throws InterruptedException {
        Thread tb = new Thread(() -> {
            eventProcessor.onEvent("B1");
            eventProcessor.onEvent("B2");
            eventProcessor.onEvent("B3");
        });
        tb.start();

        eventProcessor.onEvent("A1");
        eventProcessor.onEvent("A2");
        eventProcessor.onEvent("A3");

        tb.join();
    }

    @org.junit.jupiter.api.Test
    @Disabled // The test is too long for continuous testing.
    // 2 threads, 3 events each.
    public void test3_3() throws Exception {
        boolean sawTheValidSequence = false;

        for (; ; ) {
            eventProcessor.startIteration();
            run3_3_TestAction();
            final boolean needMoreIterations = eventProcessor.finishIteration();

            sawTheValidSequence = sawTheValidSequence ||
                    SOME_VALID_SEQUENCE_3_3.equals(eventProcessor.getCurrentSequenceString());

            if (!needMoreIterations) break;
        }

        assertEquals("Wrong number of leaf nodes",
                factorial(3 + 3) / (factorial(3) * factorial(3)),
                eventProcessor.numberOfLeafNodes());
        assertTrue(sawTheValidSequence);
    }

    @org.junit.jupiter.api.Test
    @Disabled // The test is too long for continuous testing.
    // 2 threads, 3 events, including enter-exit pairs each.
    public void test3_3_enter_exit() throws Exception {
        boolean sawTheValidSequence = false;

        for (; ; ) {
            eventProcessor.startIteration();
            Thread tb = new Thread(() -> {
                eventProcessor.onEvent("B1:enter");
                eventProcessor.onEvent("B1:exit");
                eventProcessor.onEvent("B2");
                eventProcessor.onEvent("B3:enter");
                eventProcessor.onEvent("B3:exit");
            });
            tb.start();

            eventProcessor.onEvent("A1");
            eventProcessor.onEvent("A2:enter");
            eventProcessor.onEvent("A2:exit");
            eventProcessor.onEvent("A3:enter");
            eventProcessor.onEvent("A3:exit");

            tb.join();
            final boolean needMoreIterations = eventProcessor.finishIteration();

            sawTheValidSequence = sawTheValidSequence ||
                    "B1:enter|B1:exit|A1|A2:enter|A2:exit|B2|A3:enter|A3:exit|B3:enter|B3:exit".
                            equals(eventProcessor.getCurrentSequenceString());

            if (!needMoreIterations) break;
        }

        assertEquals("Wrong number of leaf nodes",
                factorial(3 + 3) / (factorial(3) * factorial(3)),
                eventProcessor.numberOfLeafNodes());
        assertTrue(sawTheValidSequence);
    }

    @org.junit.jupiter.api.Test
    // 2 threads, 3 events each; reproducing a particular event sequence.
    public void test3_3_ReproMode() throws Exception {
        eventProcessor = new RaceConditionReproducer(SOME_VALID_SEQUENCE_3_3);
        eventProcessor.startIteration();
        run3_3_TestAction();
        assertTrue(!eventProcessor.finishIteration());
        assertEquals(SOME_VALID_SEQUENCE_3_3, eventProcessor.getCurrentSequenceString());

        assertEquals("Wrong number of leaf nodes", 1, eventProcessor.numberOfLeafNodes());
    }

    @Test
    @Disabled // The test is too long for continuous testing.
    // 2 threads with 2 events; 1 thread with 1 event.
    public void test2_1_2() throws Exception {
        for (; ; ) {
            eventProcessor.startIteration();
            Thread tb = new Thread(() -> {
                eventProcessor.onEvent("B1");
                eventProcessor.onEvent("B2");
            });
            tb.start();

            Thread tc = new Thread(() -> {
                eventProcessor.onEvent("C1");
            });
            tc.start();

            eventProcessor.onEvent("A1");
            eventProcessor.onEvent("A2");

            tb.join();
            tc.join();

            if (!eventProcessor.finishIteration()) break;
        }

        assertEquals("Wrong number of leaf nodes",
                factorial(2 + 2 + 1) / (factorial(2) * factorial(2) * factorial(1)),
                eventProcessor.numberOfLeafNodes());
    }

    @org.junit.jupiter.api.Test
    @Disabled // The test is too long for continuous testing.
    // 2 threads with 2 events; 1 thread with 1 event. Includes enter-exit pairs.
    public void test2_1_2_enter_exit() throws Exception {
        for (; ; ) {
            eventProcessor.startIteration();
            Thread tb = new Thread(() -> {
                eventProcessor.onEvent("B1:enter");
                eventProcessor.onEvent("B1:exit");
                eventProcessor.onEvent("B2:enter");
                eventProcessor.onEvent("B2:exit");
            });
            tb.start();

            Thread tc = new Thread(() -> {
                eventProcessor.onEvent("C1:enter");
                eventProcessor.onEvent("C1:exit");
            });
            tc.start();

            eventProcessor.onEvent("A1:enter");
            eventProcessor.onEvent("A1:exit");
            eventProcessor.onEvent("A2:enter");
            eventProcessor.onEvent("A2:exit");

            tb.join();
            tc.join();

            if (!eventProcessor.finishIteration()) break;
        }

        assertEquals("Wrong number of leaf nodes",
                factorial(2 + 2 + 1) / (factorial(2) * factorial(2) * factorial(1)),
                eventProcessor.numberOfLeafNodes());
    }
}
