/*
 *  This file is part of Omega Launcher.
 *  Copyright (c) 2021   Saul Henriquez
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.saggitt.omega.views

import android.animation.PropertyValuesHolder
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.android.launcher3.Insettable
import com.android.launcher3.Launcher
import com.android.launcher3.R
import com.android.launcher3.R.layout
import com.android.launcher3.anim.Interpolators
import com.android.launcher3.util.SystemUiController
import com.android.launcher3.util.Themes
import com.android.launcher3.views.AbstractSlideInView

class CenterFloatingView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : AbstractSlideInView(context, attrs, defStyleAttr), Insettable {
    private val mInsets: Rect
    private val mColorScrim: ColorScrim

    init {
        setWillNotDraw(false)
        mColorScrim = ColorScrim.createExtractedColorScrim(this)
        mInsets = Rect()
        mContent = this
    }

    fun show(view: View?, animate: Boolean) {
        (findViewById<View>(R.id.sheet_contents) as ViewGroup).addView(view)
        mLauncher.dragLayer.addView(this)
        mIsOpen = false
        animateOpen(animate)
    }

    override fun setInsets(insets: Rect) {
        // Extend behind left, right, and bottom insets.
        val leftInset = insets.left - mInsets.left
        val rightInset = insets.right - mInsets.right
        val bottomInset = insets.bottom - mInsets.bottom
        mInsets.set(insets)
        setPadding(
            paddingLeft + leftInset, paddingTop,
            paddingRight + rightInset, paddingBottom + bottomInset
        )
    }

    override fun isOfType(@FloatingViewType type: Int): Boolean {
        return type and TYPE_SETTINGS_SHEET != 0
    }

    private fun setupNavBarColor() {
        val isSheetDark = Themes.getAttrBoolean(mLauncher, R.attr.isMainColorDark)
        mLauncher.systemUiController.updateUiState(
            SystemUiController.UI_STATE_WIDGET_BOTTOM_SHEET,
            if (isSheetDark) SystemUiController.FLAG_DARK_NAV else SystemUiController.FLAG_LIGHT_NAV
        )
    }

    private fun animateOpen(animate: Boolean) {
        if (mIsOpen || mOpenCloseAnimator.isRunning) {
            return
        }
        mIsOpen = true
        setupNavBarColor()
        mOpenCloseAnimator.setValues(
            PropertyValuesHolder.ofFloat(TRANSLATION_SHIFT, TRANSLATION_SHIFT_OPENED)
        )
        mOpenCloseAnimator.interpolator = Interpolators.FAST_OUT_SLOW_IN
        if (!animate) {
            mOpenCloseAnimator.duration = 0
        }
        post {
            mOpenCloseAnimator.start()
            mContent.animate().alpha(1f).duration = 150
        }
    }

    override fun handleClose(animate: Boolean) {
        handleClose(animate, DEFAULT_CLOSE_DURATION.toLong())
    }

    override fun logActionCommand(command: Int) {}

    companion object {
        private const val DEFAULT_CLOSE_DURATION = 200
        fun inflate(launcher: Launcher): CenterFloatingView {
            return launcher.layoutInflater
                .inflate(
                    layout.base_center_sheet,
                    launcher.dragLayer,
                    false
                ) as CenterFloatingView
        }
    }
}