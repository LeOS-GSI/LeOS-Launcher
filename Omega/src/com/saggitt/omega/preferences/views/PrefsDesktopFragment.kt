/*
 *  This file is part of Omega Launcher
 *  Copyright (c) 2021   Omega Launcher Team
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

package com.saggitt.omega.preferences.views

import android.os.Bundle
import android.view.View
import androidx.preference.SwitchPreference
import com.android.launcher3.R
import com.saggitt.omega.util.Config
import com.saggitt.omega.util.isAppEnabled

class PrefsDesktopFragment :
    BasePreferenceFragment(R.xml.preferences_desktop, R.string.title__general_desktop) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findPreference<SwitchPreference>("pref_enable_minus_one")?.apply {
            isVisible = context.packageManager.isAppEnabled(Config.GOOGLE_QSB, 0)
        }
    }
}