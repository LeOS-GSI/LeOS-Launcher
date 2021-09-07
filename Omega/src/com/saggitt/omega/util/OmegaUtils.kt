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

package com.saggitt.omega.util

import android.content.Context
import android.content.DialogInterface
import android.content.pm.LauncherActivityInfo
import android.content.pm.LauncherApps
import android.content.pm.PackageInfo.REQUESTED_PERMISSION_GRANTED
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Handler
import android.os.Looper
import android.service.notification.StatusBarNotification
import android.text.TextUtils
import android.text.format.DateFormat
import android.util.Property
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.ColorInt
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.drawable.DrawableCompat
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.preference.Preference
import androidx.preference.PreferenceGroup
import com.android.launcher3.Launcher
import com.android.launcher3.LauncherAppState
import com.android.launcher3.R
import com.android.launcher3.Utilities
import com.android.launcher3.model.BgDataModel
import com.android.launcher3.pm.UserCache
import com.android.launcher3.shortcuts.DeepShortcutManager
import com.android.launcher3.util.ComponentKey
import com.android.launcher3.util.Executors.*
import com.android.launcher3.util.PackageUserKey
import com.android.launcher3.util.Themes
import com.android.launcher3.views.OptionsPopupView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONObject
import org.xmlpull.v1.XmlPullParser
import java.lang.reflect.Field
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

val Context.launcherAppState get() = LauncherAppState.getInstance(this)
val Context.omegaPrefs get() = Utilities.getOmegaPrefs(this)

@ColorInt
fun Context.getColorAccent(): Int {
    return getColorAttr(android.R.attr.colorAccent)
}

@ColorInt
fun Context.getColorAttr(attr: Int): Int {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    @ColorInt val colorAccent = ta.getColor(0, 0)
    ta.recycle()
    return colorAccent
}

fun Context.getThemeAttr(attr: Int): Int {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    val theme = ta.getResourceId(0, 0)
    ta.recycle()
    return theme
}

fun Context.getBooleanAttr(attr: Int): Boolean {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    val value = ta.getBoolean(0, false)
    ta.recycle()
    return value
}

fun Context.getDimenAttr(attr: Int): Int {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    val size = ta.getDimensionPixelSize(0, 0)
    ta.recycle()
    return size
}

fun ImageView.tintDrawable(color: Int) {
    val drawable = drawable.mutate()
    drawable.setTint(color)
    setImageDrawable(drawable)
}

fun <T, A> ensureOnMainThread(creator: (A) -> T): (A) -> T {
    return { it ->
        if (Looper.myLooper() == Looper.getMainLooper()) {
            creator(it)
        } else {
            try {
                MAIN_EXECUTOR.submit(Callable { creator(it) }).get()
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            } catch (e: ExecutionException) {
                throw RuntimeException(e)
            }

        }
    }
}

fun <T> useApplicationContext(creator: (Context) -> T): (Context) -> T {
    return { it -> creator(it.applicationContext) }
}

val mainHandler by lazy { makeBasicHandler() }
val uiWorkerHandler: Handler by lazy { UI_HELPER_EXECUTOR.handler }
val iconPackUiHandler: Handler by lazy { ICON_PACK_EXECUTOR.handler }

fun runOnUiWorkerThread(r: () -> Unit) {
    runOnThread(uiWorkerHandler, r)
}

fun runOnMainThread(r: () -> Unit) {
    runOnThread(mainHandler, r)
}

fun runOnThread(handler: Handler, r: () -> Unit) {
    if (handler.looper.thread.id == Looper.myLooper()?.thread?.id) {
        r()
    } else {
        handler.post(r)
    }
}

val Context.hasStoragePermission
    get() = PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(
        this, android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

inline fun <T> Iterable<T>.safeForEach(action: (T) -> Unit) {
    val tmp = ArrayList<T>()
    tmp.addAll(this)
    for (element in tmp) action(element)
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun Switch.applyColor(color: Int) {
    val colorForeground = Themes.getAttrColor(context, android.R.attr.colorForeground)
    val alphaDisabled = Themes.getAlpha(context, android.R.attr.disabledAlpha)
    val switchThumbNormal =
        context.resources.getColor(
            androidx.preference.R.color.switch_thumb_normal_material_light,
            null
        )
    val switchThumbDisabled =
        context.resources.getColor(
            androidx.preference.R.color.switch_thumb_disabled_material_light,
            null
        )
    val thstateList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf()
        ),
        intArrayOf(
            switchThumbDisabled,
            color,
            switchThumbNormal
        )
    )
    val trstateList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf()
        ),
        intArrayOf(
            ColorUtils.setAlphaComponent(colorForeground, alphaDisabled),
            color,
            colorForeground
        )
    )
    DrawableCompat.setTintList(thumbDrawable, thstateList)
    DrawableCompat.setTintList(trackDrawable, trstateList)
}

operator fun PreferenceGroup.get(index: Int): Preference = getPreference(index)
inline fun PreferenceGroup.forEachIndexed(action: (i: Int, pref: Preference) -> Unit) {
    for (i in 0 until preferenceCount) action(i, this[i])
}

class KFloatPropertyCompat(private val property: KMutableProperty0<Float>, name: String) :
    FloatPropertyCompat<Any>(name) {

    override fun getValue(`object`: Any) = property.get()

    override fun setValue(`object`: Any, value: Float) {
        property.set(value)
    }
}

class KFloatProperty(private val property: KMutableProperty0<Float>, name: String) :
    Property<Any, Float>(Float::class.java, name) {

    override fun get(`object`: Any) = property.get()

    override fun set(`object`: Any, value: Float) {
        property.set(value)
    }
}

val Configuration.usingNightMode get() = uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

fun Int.hasFlags(vararg flags: Int): Boolean {
    return flags.all { hasFlag(it) }
}

infix fun Int.hasFlag(flag: Int) = (this and flag) != 0

fun Int.removeFlag(flag: Int): Int {
    return this and flag.inv()
}

fun Int.addFlag(flag: Int): Int {
    return this or flag
}

fun Int.setFlag(flag: Int, value: Boolean): Int {
    return if (value) {
        addFlag(flag)
    } else {
        removeFlag(flag)
    }
}

fun Context.checkLocationAccess(): Boolean {
    return Utilities.hasPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ||
            Utilities.hasPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
}

operator fun XmlPullParser.get(index: Int): String? = getAttributeValue(index)
operator fun XmlPullParser.get(namespace: String?, key: String): String? =
    getAttributeValue(namespace, key)

operator fun XmlPullParser.get(key: String): String? = this[null, key]

inline fun ViewGroup.forEachChildIndexed(action: (View, Int) -> Unit) {
    val count = childCount
    for (i in (0 until count)) {
        action(getChildAt(i), i)
    }
}

inline fun ViewGroup.forEachChild(action: (View) -> Unit) {
    forEachChildIndexed { view, _ -> action(view) }
}

inline fun ViewGroup.forEachChildReversedIndexed(action: (View, Int) -> Unit) {
    val count = childCount
    for (i in (0 until count).reversed()) {
        action(getChildAt(i), i)
    }
}

inline fun ViewGroup.forEachChildReversed(action: (View) -> Unit) {
    forEachChildReversedIndexed { view, _ -> action(view) }
}

fun Drawable.toBitmap(forceCreate: Boolean = true, fallbackSize: Int = 0): Bitmap? {
    return Utilities.drawableToBitmap(this, forceCreate, fallbackSize)
}

fun AlertDialog.applyAccent() {
    val color = Utilities.getOmegaPrefs(context).accentColor
    val buttons = listOf(
        getButton(DialogInterface.BUTTON_NEGATIVE),
        getButton(DialogInterface.BUTTON_NEUTRAL),
        getButton(DialogInterface.BUTTON_POSITIVE)
    )
    buttons.forEach {
        it?.setTextColor(color)
    }
}

fun CheckedTextView.applyAccent() {
    val tintList = ColorStateList.valueOf(context.getColorAccent())
    compoundDrawableTintList = tintList
    backgroundTintList = tintList
}

fun FloatingActionButton.applyColor(color: Int) {
    val rippleColor = ColorStateList.valueOf(ColorUtils.setAlphaComponent(color, 31))
    background?.let {
        (it as RippleDrawable).setColor(rippleColor)
        DrawableCompat.setTint(background, color)
    }
}

fun Button.applyColor(color: Int) {
    val rippleColor = ColorStateList.valueOf(ColorUtils.setAlphaComponent(color, 31))
    background?.let {
        (it as RippleDrawable).setColor(rippleColor)
        DrawableCompat.setTint(background, color)
    }
    val tintList = ColorStateList.valueOf(color)
    if (this is RadioButton) {
        buttonTintList = tintList
    }
}

fun String.toTitleCase(): String = splitToSequence(" ").map {
    it.replaceFirstChar { ch ->
        if (ch.isLowerCase()) ch.titlecase(
            Locale.getDefault()
        ) else ch.toString()
    }
}.joinToString(" ")

inline fun <T> listWhileNotNull(generator: () -> T?): List<T> = mutableListOf<T>().apply {
    while (true) {
        add(generator() ?: break)
    }
}

fun BgDataModel.workspaceContains(packageName: String): Boolean {
    return this.workspaceItems.any { it.targetComponent?.packageName == packageName }
}

fun formatTime(calendar: Calendar, context: Context? = null): String {
    return when (context) {
        null -> String.format(
            "%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.HOUR_OF_DAY)
        )
        else -> if (DateFormat.is24HourFormat(context)) String.format(
            "%02d:%02d", calendar.get(
                Calendar.HOUR_OF_DAY
            ), calendar.get(Calendar.MINUTE)
        ) else String.format(
            "%02d:%02d %s",
            if (calendar.get(
                    Calendar.HOUR_OF_DAY
                ) % 12 == 0
            ) 12 else calendar.get(
                Calendar.HOUR_OF_DAY
            ) % 12,
            calendar.get(
                Calendar.MINUTE
            ),
            if (calendar.get(
                    Calendar.HOUR_OF_DAY
                ) < 12
            ) "AM" else "PM"
        )
    }
}

inline val Calendar.hourOfDay get() = get(Calendar.HOUR_OF_DAY)
inline val Calendar.dayOfYear get() = get(Calendar.DAY_OF_YEAR)

fun ViewGroup.getAllChilds() = ArrayList<View>().also { getAllChilds(it) }

fun ViewGroup.getAllChilds(list: MutableList<View>) {
    for (i in (0 until childCount)) {
        val child = getChildAt(i)
        if (child is ViewGroup) {
            child.getAllChilds(list)
        } else {
            list.add(child)
        }
    }
}

fun StatusBarNotification.loadSmallIcon(context: Context): Drawable? {
    return notification.smallIcon?.loadDrawable(context)
}

@JvmOverloads
fun makeBasicHandler(preferMyLooper: Boolean = false, callback: Handler.Callback? = null): Handler =
    if (preferMyLooper)
        Handler(Looper.myLooper() ?: Looper.getMainLooper(), callback)
    else
        Handler(Looper.getMainLooper(), callback)

fun Context.checkPackagePermission(packageName: String, permissionName: String): Boolean {
    try {
        val info = packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
        info.requestedPermissions.forEachIndexed { index, s ->
            if (s == permissionName) {
                return info.requestedPermissionsFlags[index].hasFlag(REQUESTED_PERMISSION_GRANTED)
            }
        }
    } catch (e: PackageManager.NameNotFoundException) {
    }
    return false
}

fun openPopupMenu(view: View, rect: RectF?, vararg items: OptionsPopupView.OptionItem) {
    val launcher = Launcher.getLauncher(view.context)
    OptionsPopupView.show(launcher, rect ?: RectF(launcher.getViewBounds(view)), items.toList())
}

fun Context.getLauncherOrNull(): Launcher? {
    return try {
        Launcher.getLauncher(this)
    } catch (e: IllegalArgumentException) {
        null
    }
}

private const val MAX_UNICODE = '\uFFFF'

/**
 * Returns true if {@param target} is a search result for {@param query}
 */
fun java.text.Collator.matches(query: String, target: String): Boolean {
    return when (this.compare(query, target)) {
        0 -> true
        -1 ->
            // The target string can contain a modifier which would make it larger than
            // the query string (even though the length is same). If the query becomes
            // larger after appending a unicode character, it was originally a prefix of
            // the target string and hence should match.
            this.compare(query + MAX_UNICODE, target) > -1 || target.contains(
                query,
                ignoreCase = true
            )
        else -> false
    }
}

fun reloadIconsFromComponents(context: Context, components: Collection<ComponentKey>) {
    reloadIcons(context, components.map { PackageUserKey(it.componentName.packageName, it.user) })
}

fun reloadIcons(context: Context, packages: Collection<PackageUserKey>) {
    ICON_PACK_EXECUTOR.execute {
        val userManagerCompat = UserCache.INSTANCE.get(context)
        val las = LauncherAppState.getInstance(context)
        val model = las.model

        for (user in userManagerCompat.userProfiles) {
            model.onPackagesReload(user)
        }

        val shortcutManager = DeepShortcutManager.getInstance(context)
        packages.forEach {
            Config.reloadIcon(shortcutManager, model, it.mUser, it.mPackageName)
        }
    }
}

fun View.runOnAttached(runnable: Runnable) {
    if (isAttachedToWindow) {
        runnable.run()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {

            override fun onViewAttachedToWindow(v: View?) {
                runnable.run()
                removeOnAttachStateChangeListener(this)
            }

            override fun onViewDetachedFromWindow(v: View?) {
                removeOnAttachStateChangeListener(this)
            }
        })

    }
}

val Context.locale: Locale
    get() = this.resources.configuration.locales[0]

fun createRipplePill(context: Context, color: Int, radius: Float): Drawable {
    return RippleDrawable(
        ContextCompat.getColorStateList(context, R.color.focused_background)!!,
        createPill(color, radius), createPill(color, radius)
    )
}

fun createPill(color: Int, radius: Float): Drawable {
    return GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        setColor(color)
        cornerRadius = radius
    }
}

fun Context.getIcon(): Drawable = packageManager.getApplicationIcon(applicationInfo)

@Suppress("UNCHECKED_CAST")
fun <T> JSONArray.toArrayList(): ArrayList<T> {
    val arrayList = ArrayList<T>()
    for (i in (0 until length())) {
        arrayList.add(get(i) as T)
    }
    return arrayList
}

fun Float.round() = roundToInt().toFloat()

fun Float.ceilToInt() = ceil(this).toInt()


fun dpToPx(size: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        size,
        Resources.getSystem().displayMetrics
    )
}

fun pxToDp(size: Float): Float {
    return size / dpToPx(1f)
}

val ViewGroup.childs get() = ViewGroupChildList(this)

class ViewGroupChildList(private val viewGroup: ViewGroup) : List<View> {

    override val size get() = viewGroup.childCount

    override fun isEmpty() = size == 0

    override fun contains(element: View): Boolean {
        return any { it === element }
    }

    override fun containsAll(elements: Collection<View>): Boolean {
        return elements.all { contains(it) }
    }

    override fun get(index: Int) = viewGroup.getChildAt(index)!!

    override fun indexOf(element: View) = indexOfFirst { it === element }

    override fun lastIndexOf(element: View) = indexOfLast { it === element }

    override fun iterator() = listIterator()

    override fun listIterator() = listIterator(0)

    override fun listIterator(index: Int) = ViewGroupChildIterator(viewGroup, index)

    override fun subList(fromIndex: Int, toIndex: Int) = ArrayList(this).subList(fromIndex, toIndex)
}

class ViewGroupChildIterator(private val viewGroup: ViewGroup, private var current: Int) :
    ListIterator<View> {

    override fun hasNext() = current < viewGroup.childCount

    override fun next() = viewGroup.getChildAt(current++)!!

    override fun nextIndex() = current

    override fun hasPrevious() = current > 0

    override fun previous() = viewGroup.getChildAt(current--)!!

    override fun previousIndex() = current - 1
}

@Suppress("UNCHECKED_CAST")
class JavaField<T>(
    private val targetObject: Any,
    fieldName: String,
    targetClass: Class<*> = targetObject::class.java
) {

    private val field: Field = targetClass.getDeclaredField(fieldName).apply { isAccessible = true }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return field.get(targetObject) as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        field.set(targetObject, value)
    }
}

fun ComponentKey.getLauncherActivityInfo(context: Context): LauncherActivityInfo? {
    return context.getSystemService(LauncherApps::class.java)
        .getActivityList(componentName.packageName, user)
        .firstOrNull { it.componentName == componentName }
}


fun Context.createDisabledColor(color: Int): ColorStateList {
    return ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf()
        ),
        intArrayOf(
            getDisabled(getColorAttr(android.R.attr.colorForeground)),
            color
        )
    )
}

@ColorInt
fun Context.getDisabled(inputColor: Int): Int {
    return applyAlphaAttr(android.R.attr.disabledAlpha, inputColor)
}

@ColorInt
fun Context.applyAlphaAttr(attr: Int, inputColor: Int): Int {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    val alpha = ta.getFloat(0, 0f)
    ta.recycle()
    return applyAlpha(alpha, inputColor)
}

@ColorInt
fun applyAlpha(a: Float, inputColor: Int): Int {
    var alpha = a
    alpha *= Color.alpha(inputColor)
    return Color.argb(
        alpha.toInt(), Color.red(inputColor), Color.green(inputColor),
        Color.blue(inputColor)
    )
}

fun JSONObject.asMap() = JSONMap(this)
fun JSONObject.getNullable(key: String): Any? {
    return opt(key)
}

fun String.asNonEmpty(): String? {
    if (TextUtils.isEmpty(this)) return null
    return this
}

fun <E> MutableSet<E>.addOrRemove(obj: E, exists: Boolean): Boolean {
    if (contains(obj) != exists) {
        if (exists) add(obj)
        else remove(obj)
        return true
    }
    return false
}

fun getTabRipple(context: Context, accent: Int): ColorStateList {
    return ColorStateList(
        arrayOf(
            intArrayOf(android.R.attr.state_selected),
            intArrayOf()
        ),
        intArrayOf(
            ColorUtils.setAlphaComponent(accent, 31),
            context.getColorAttr(android.R.attr.colorControlHighlight)
        )
    )
}

val Long.Companion.random get() = Random.nextLong()

fun <T, U : Comparable<U>> comparing(extractKey: (T) -> U): Comparator<T> {
    return Comparator { o1, o2 -> extractKey(o1).compareTo(extractKey(o2)) }
}

fun <T, U : Comparable<U>> Comparator<T>.then(extractKey: (T) -> U): Comparator<T> {
    return kotlin.Comparator { o1, o2 ->
        val res = compare(o1, o2)
        if (res != 0) res else extractKey(o1).compareTo(extractKey(o2))
    }
}

