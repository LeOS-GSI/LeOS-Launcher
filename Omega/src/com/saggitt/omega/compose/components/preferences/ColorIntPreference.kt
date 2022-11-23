/*
 * This file is part of Neo Launcher
 * Copyright (c) 2022   Neo Launcher Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.saggitt.omega.compose.components.preferences

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.jaredrummler.android.colorpicker.ColorPickerDialog
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener
import com.saggitt.omega.compose.PrefsActivityX
import com.saggitt.omega.preferences.BasePreferences

@Composable
fun ColorIntPreference(
    modifier: Modifier = Modifier,
    pref: BasePreferences.ColorIntPref,
    index: Int = 1,
    groupSize: Int = 1,
    isEnabled: Boolean = true,
    onValueChange: ((Int) -> Unit) = {},
) {
    val context = LocalContext.current
    var currentColor by remember(pref) { mutableStateOf(pref.onGetValue()) }
    if (!pref.withAlpha) currentColor = currentColor or (0xff000000).toInt()
    BasePreference(
        modifier = modifier,
        titleId = pref.titleId,
        summaryId = pref.summaryId,
        index = index,
        groupSize = groupSize,
        isEnabled = isEnabled,
        onClick = { // TODO replace with a custom ColorSelector Dialog
            val dialog = ColorPickerDialog.newBuilder()
                .setColor(currentColor)
                .setDialogType(ColorPickerDialog.TYPE_PRESETS)
                .setPresets(pref.entries)
                .setAllowCustom(pref.allowCustom)
                .setShowAlphaSlider(pref.withAlpha)
                .setShowColorShades(pref.withShades)
                .create()

            dialog.setColorPickerDialogListener(object : ColorPickerDialogListener {
                override fun onColorSelected(dialogId: Int, color: Int) {
                    currentColor = color
                    pref.onSetValue(color)
                    onValueChange(color)
                }

                override fun onDialogDismissed(dialogId: Int) {}
            })
            dialog.show(PrefsActivityX.getFragmentManager(context), "color-picker-dialog")
        },
        endWidget = {
            Canvas(
                modifier = Modifier
                    .size(40.dp),
                onDraw = {
                    drawCircle(color = Color.Black, style = Stroke(width = 2.dp.toPx()))
                    drawCircle(color = Color(currentColor))
                }
            )
        }
    )
}