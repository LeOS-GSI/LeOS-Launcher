/*
 *  This file is part of Omega Launcher
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

package com.saggitt.omega.feed

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.preference.DialogPreference
import com.android.launcher3.R
import com.saggitt.omega.OmegaPreferences
import com.saggitt.omega.settings.controllers.FeedProviderController
import com.saggitt.omega.smartspace.FeedBridge
import com.saggitt.omega.util.getIcon
import com.saggitt.omega.util.omegaPrefs

class FeedProviderPreference(context: Context, attrs: AttributeSet? = null) :
    DialogPreference(context, attrs), OmegaPreferences.OnPreferenceChangeListener {
    private val prefs = context.omegaPrefs
    private val current
        get() = providers(context).firstOrNull { it.packageName == prefs.feedProvider }
            ?: providers(context)[0]

    init {
        layoutResource = R.layout.preference_preview_icon
        dialogLayoutResource = R.layout.pref_dialog_icon_pack
    }

    override fun onAttached() {
        super.onAttached()

        prefs.addOnPreferenceChangeListener(this, KEY)
    }

    override fun onValueChanged(key: String, prefs: OmegaPreferences, force: Boolean) {
        isVisible = FeedProviderController(context).isVisible
        updateSummaryAndIcon()
    }

    private fun updateSummaryAndIcon() {
        icon = current.icon
        summary = current.name
    }

    override fun onDetached() {
        super.onDetached()

        prefs.removeOnPreferenceChangeListener(this, KEY)
    }

    companion object {
        const val KEY = "pref_feedProvider"

        fun providers(context: Context) = listOf(
            ProviderInfo(context.getString(R.string.title_default), "", context.getIcon())
        ) + FeedBridge.getAvailableProviders(context).map {
            ProviderInfo(
                it.loadLabel(context.packageManager).toString(),
                it.packageName,
                it.loadIcon(context.packageManager)
            )
        }
    }

    data class ProviderInfo(
        val name: String,
        val packageName: String,
        val icon: Drawable?
    )
}