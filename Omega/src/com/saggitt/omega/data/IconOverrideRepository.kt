package com.saggitt.omega.data

import android.content.Context
import com.android.launcher3.LauncherAppState
import com.android.launcher3.util.ComponentKey
import com.android.launcher3.util.MainThreadInitializedObject
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class IconOverrideRepository(private val context: Context) {

    private val scope = MainScope() + CoroutineName("IconOverrideRepository")
    private val dao = NeoLauncherDb.INSTANCE.get(context).iconOverrideDao()
    private var _overridesMap = mapOf<ComponentKey, IconPickerItem>()
    val overridesMap get() = _overridesMap

    init {
        scope.launch {
            dao.observeAll()
                .flowOn(Dispatchers.Main)
                .collect { overrides ->
                    _overridesMap = overrides.associateBy(
                        keySelector = { it.target },
                        valueTransform = { it.iconPickerItem }
                    )
                }
        }
    }

    suspend fun setOverride(target: ComponentKey, item: IconPickerItem) {
        dao.insert(IconOverride(target, item))
        reloadIcons()
    }

    suspend fun deleteOverride(target: ComponentKey) {
        dao.delete(target)
        reloadIcons()
    }

    fun observeTarget(target: ComponentKey) = dao.observeTarget(target)
    fun observeCount() = dao.observeCount()

    suspend fun deleteAll() {
        dao.deleteAll()
        reloadIcons()
    }

    private fun reloadIcons() {
        val las = LauncherAppState.getInstance(context)
        val idp = las.invariantDeviceProfile
        idp.onPreferencesChanged(context.applicationContext)
    }

    companion object {
        @JvmField
        val INSTANCE = MainThreadInitializedObject(::IconOverrideRepository)
    }
}
