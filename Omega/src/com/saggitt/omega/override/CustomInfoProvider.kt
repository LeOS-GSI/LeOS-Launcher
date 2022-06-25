/*
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.saggitt.omega.override

import android.content.Context
import com.android.launcher3.model.ModelWriter
import com.android.launcher3.model.data.AppInfo
import com.android.launcher3.model.data.FolderInfo
import com.android.launcher3.model.data.ItemInfo
import com.android.launcher3.model.data.WorkspaceItemInfo

abstract class CustomInfoProvider<in T : ItemInfo>(val context: Context) {

    abstract fun getTitle(info: T): String

    abstract fun getDefaultTitle(info: T): String

    abstract fun getCustomTitle(info: T): String?

    abstract fun setTitle(info: T, title: String?, modelWriter: ModelWriter)

    open fun supportsIcon() = true

    //abstract fun setIcon(info: T, entry: CustomIconEntry?)

    //abstract fun getIcon(info: T): CustomIconEntry?

    open fun supportsSwipeUp(info: T) = false

    open fun setSwipeUpAction(info: T, action: String?) {}

    open fun getSwipeUpAction(info: T): String? {
        TODO("not implemented")
    }

    open fun supportsBadgeVisible(info: T) = false

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun <T : ItemInfo> forItem(context: Context, info: ItemInfo?): CustomInfoProvider<T>? {
            return when (info) {
                is AppInfo -> AppInfoProvider.getInstance(context)
                is WorkspaceItemInfo -> ShortcutInfoProvider.getInstance(context)
                is FolderInfo -> FolderInfoProvider.getInstance(context)
                else -> null
            } as CustomInfoProvider<T>?
        }

        fun isEditable(info: ItemInfo): Boolean {
            return info is AppInfo || (info is WorkspaceItemInfo && !info.hasPromiseIconUi())
                    || info is FolderInfo
        }
    }
}
