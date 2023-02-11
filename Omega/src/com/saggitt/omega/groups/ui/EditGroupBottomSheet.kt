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

package com.saggitt.omega.groups.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.android.launcher3.R
import com.android.launcher3.Utilities
import com.android.launcher3.util.ComponentKey
import com.jaredrummler.android.colorpicker.ColorPickerDialog
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener
import com.saggitt.omega.compose.PrefsActivityX
import com.saggitt.omega.compose.components.BaseDialog
import com.saggitt.omega.compose.components.ComposeSwitchView
import com.saggitt.omega.compose.components.preferences.BasePreference
import com.saggitt.omega.compose.screens.preferences.CategorySelectionDialogUI
import com.saggitt.omega.flowerpot.Flowerpot
import com.saggitt.omega.groups.AppGroups
import com.saggitt.omega.groups.AppGroupsManager
import com.saggitt.omega.groups.DrawerFolders
import com.saggitt.omega.groups.DrawerTabs
import com.saggitt.omega.groups.FlowerpotTabs.Companion.TYPE_FLOWERPOT
import com.saggitt.omega.util.Config
import com.saggitt.omega.util.omegaPrefs

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun EditGroupBottomSheet(
    type: AppGroupsManager.CategorizationType,
    group: AppGroups.Group,
    onClose: (Int) -> Unit
) {
    val context = LocalContext.current
    val prefs = Utilities.getOmegaPrefs(context)
    val flowerpotManager = Flowerpot.Manager.getInstance(context)
    val config = group.customizations
    val keyboardController = LocalSoftwareKeyboardController.current
    val openDialog = remember { mutableStateOf(false) }

    var title by remember { mutableStateOf(group.title) }
    var isHidden by remember {
        mutableStateOf(
            (config[AppGroups.KEY_HIDE_FROM_ALL_APPS] as? AppGroups.Group.BooleanCustomization)?.value
                ?: true
        )
    }
    var selectedCategory by remember {
        mutableStateOf(
            (config[AppGroups.KEY_FLOWERPOT] as? AppGroups.Group.StringCustomization)?.value
                ?: AppGroups.KEY_FLOWERPOT_DEFAULT
        )
    }

    val allAppsTab = "profile{\"matchesAll\":true}}"
    val apps: Array<ComponentKey> = if (group.type == allAppsTab) {
        prefs.drawerHiddenAppSet.onGetValue().map { ComponentKey.fromString(it)!! }.toTypedArray()
    } else {
        (config[AppGroups.KEY_ITEMS] as? AppGroups.Group.ComponentsCustomization)?.value?.toTypedArray()
            ?: emptyArray()
    }

    val selectedApps = remember { mutableStateListOf(*apps) }
    var color by remember {
        mutableStateOf(
            Color(
                (config[AppGroups.KEY_COLOR] as? AppGroups.Group.ColorCustomization)?.value
                    ?: context.omegaPrefs.themeAccentColor.onGetValue()
            )
        )
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Divider(
            modifier = Modifier
                .width(48.dp)
                .height(2.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12F),
                textColor = MaterialTheme.colorScheme.onSurface
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            }),
            shape = MaterialTheme.shapes.large,
            label = {
                Text(
                    text = stringResource(id = R.string.name),
                    style = MaterialTheme.typography.titleMedium,
                )
            },
            isError = title.isEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        val summary = context.resources.getQuantityString(
            R.plurals.tab_apps_count,
            selectedApps.size,
            selectedApps.size
        )
        when (group.type) {
            allAppsTab -> {
                BasePreference(
                    titleId = R.string.title__drawer_hide_apps,
                    summary = summary,
                    startWidget = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_apps),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    },
                    endWidget = {
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_right),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                ) { openDialog.value = true }
                Spacer(modifier = Modifier.height(8.dp))

                if (openDialog.value) {
                    BaseDialog(openDialogCustom = openDialog) {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.padding(8.dp),
                            elevation = CardDefaults.elevatedCardElevation(8.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
                        ) {
                            GroupAppSelection(
                                selectedApps = selectedApps.map { it.toString() }.toSet(),
                            ) {
                                val componentsSet =
                                    it.mapNotNull { ck -> ComponentKey.fromString(ck) }
                                        .toMutableSet()
                                selectedApps.clear()
                                selectedApps.addAll(componentsSet)
                                prefs.drawerHiddenAppSet.onSetValue(selectedApps.map { key -> key.toString() }
                                    .toSet())
                                openDialog.value = false
                            }
                        }
                    }
                }
            }

            DrawerTabs.TYPE_CUSTOM, DrawerFolders.TYPE_CUSTOM, TYPE_FLOWERPOT -> {
                if (type != AppGroupsManager.CategorizationType.Flowerpot) {
                    BasePreference(
                        titleId = R.string.tab_manage_apps,
                        summary = summary,
                        startWidget = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_apps),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        },
                        endWidget = {
                            Icon(
                                painter = painterResource(id = R.drawable.chevron_right),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        },
                    ) { openDialog.value = true }
                    Spacer(modifier = Modifier.height(8.dp))
                    ComposeSwitchView(
                        title = stringResource(R.string.tab_hide_from_main),
                        iconId = R.drawable.tab_hide_from_main,
                        isChecked = isHidden,
                        onCheckedChange = { isHidden = it },
                        horizontalPadding = 4.dp
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    if (openDialog.value) {
                        BaseDialog(openDialogCustom = openDialog) {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.padding(8.dp),
                                elevation = CardDefaults.elevatedCardElevation(8.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
                            ) {
                                GroupAppSelection(
                                    selectedApps = selectedApps.map { it.toString() }.toSet(),
                                ) {
                                    val componentsSet =
                                        it.mapNotNull { ck -> ComponentKey.fromString(ck) }
                                            .toMutableSet()
                                    selectedApps.clear()
                                    selectedApps.addAll(componentsSet)
                                    (config[AppGroups.KEY_ITEMS] as? AppGroups.Group.ComponentsCustomization)?.value =
                                        componentsSet
                                }
                            }
                        }
                    }
                } else {
                    BasePreference(
                        titleId = R.string.pref_appcategorization_flowerpot_title,
                        summary = flowerpotManager.getAllPots()
                            .find { it.name == selectedCategory }!!.displayName,
                        startWidget = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_category),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        },
                        endWidget = {
                            Icon(
                                painter = painterResource(id = R.drawable.chevron_right),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        }
                    ) { openDialog.value = true }
                    Spacer(modifier = Modifier.height(8.dp))

                    if (openDialog.value) {
                        BaseDialog(openDialogCustom = openDialog) {
                            CategorySelectionDialogUI(selectedCategory = selectedCategory) {
                                selectedCategory = it
                                (config[AppGroups.KEY_FLOWERPOT] as? AppGroups.Group.StringCustomization)?.value =
                                    it
                                openDialog.value = false
                            }
                        }
                    }
                }
            }
        }

        if (group.type != DrawerFolders.TYPE_CUSTOM) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val dialog = ColorPickerDialog
                            .newBuilder()
                            .setDialogType(ColorPickerDialog.TYPE_CUSTOM)
                            .setAllowCustom(true)
                            .setShowAlphaSlider(false)
                            .setPresets(ColorPickerDialog.MATERIAL_COLORS)
                            .setShowColorShades(false)
                            .setColor(color.toArgb())
                            .create()

                        dialog.setColorPickerDialogListener(object :
                            ColorPickerDialogListener {
                            override fun onColorSelected(dialogId: Int, newColor: Int) {
                                color = Color(newColor)
                                (config[AppGroups.KEY_COLOR] as? AppGroups.Group.ColorCustomization)?.value =
                                    newColor
                            }

                            override fun onDialogDismissed(dialogId: Int) {}
                        })
                        dialog.show(
                            PrefsActivityX.getFragmentManager(context),
                            "color-picker-dialog"
                        )
                    }
            )
            {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_color_donut),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = color
                    )

                    Text(
                        text = stringResource(id = R.string.tab_color),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                            .weight(1f)
                    )
                }

            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            OutlinedButton(
                onClick = {
                    onClose(Config.BS_SELECT_TAB_TYPE)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            ) {
                Text(text = stringResource(id = android.R.string.cancel))
            }
            Spacer(modifier = Modifier.width(16.dp))

            OutlinedButton(
                onClick = {
                    (config[AppGroups.KEY_TITLE] as? AppGroups.Group.StringCustomization)?.value =
                        title
                    (config[AppGroups.KEY_HIDE_FROM_ALL_APPS] as? AppGroups.Group.BooleanCustomization)?.value =
                        isHidden
                    (config[AppGroups.KEY_ITEMS] as? AppGroups.Group.ComponentsCustomization)?.value =
                        selectedApps.toMutableSet()
                    if (type != AppGroupsManager.CategorizationType.Folders) {
                        (config[AppGroups.KEY_COLOR] as? AppGroups.Group.ColorCustomization)?.value =
                            color.toArgb()
                    }
                    group.customizations.applyFrom(config)

                    when (type) {
                        AppGroupsManager.CategorizationType.Folders -> {
                            prefs.drawerAppGroupsManager.drawerFolders.saveToJson()
                        }

                        AppGroupsManager.CategorizationType.Tabs,
                        AppGroupsManager.CategorizationType.Flowerpot -> {
                            prefs.drawerAppGroupsManager.drawerTabs.saveToJson()
                        }
                        else -> {}
                    }
                    onClose(Config.BS_SELECT_TAB_TYPE)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.35F),
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.65F)),
            ) {
                Text(text = stringResource(id = R.string.tab_bottom_sheet_save))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}