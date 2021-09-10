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

package com.saggitt.omega.settings

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.ui.platform.ComposeView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.android.launcher3.BuildConfig
import com.android.launcher3.R
import com.android.launcher3.Utilities
import com.google.android.material.tabs.TabLayout
import com.saggitt.omega.theme.OmegaAppTheme
import com.saggitt.omega.theme.ThemeManager
import com.saggitt.omega.theme.ThemeOverride
import com.saggitt.omega.theme.ThemedContextProvider
import com.saggitt.omega.util.Config
import com.saggitt.omega.util.CustomPagerAdapter
import com.saggitt.omega.util.applyColor
import com.saggitt.omega.views.LoadTranslators
import kotlinx.coroutines.launch
import java.util.*

class AboutFragment : Fragment() {

    private val modeTotal = 3

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.about, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val license = view.findViewById<WebView>(R.id.webview_license)
        val changelog = view.findViewById<WebView>(R.id.webview_changelog)

        val lists = arrayOf(license, changelog)
        val titles = arrayOf(
            getString(R.string.title__general_about)
        )

        val viewPager = view.findViewById<ViewPager>(R.id.pager).apply {
            offscreenPageLimit = modeTotal - 1
            adapter = CustomPagerAdapter(lists as Array<View>, titles)
        }

        requireActivity().findViewById<TabLayout>(R.id.sliding_tabs).apply {
            setupWithViewPager(viewPager)
        }

        val config = Config(requireContext())
        val themedContext =
            ThemedContextProvider(requireContext(), null, ThemeOverride.Settings()).get()
        val isDark = ThemeManager.getInstance(themedContext).isDark

        lifecycleScope.launch {
            //Load view Items
                       }
            val cssFile = if (isDark) {
                "about_dark.css"
            } else {
                "about_light.css"
            }

            license.loadUrl("file:///android_asset/license.htm")
            license.webViewClient = object : WebViewClient() {

                override fun onPageFinished(view: WebView, url: String) {

                    if (url.startsWith("file:///android_asset")) {
                        // Inject CSS when page is done loading
                        injectCSS(license, cssFile)
                    }
                    super.onPageFinished(view, url)
                }

                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    if (url.contains("file://")) {
                        view.loadUrl(url)
                    } else {
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        try {
                            startActivity(intent)
                        } catch (e: ActivityNotFoundException) {
                            view.loadUrl(url)
                        }
                    }
                    return true
                }
            }

            changelog.loadUrl("file:///android_asset/changelog.htm")
            changelog.webViewClient = object : WebViewClient() {

                override fun onPageFinished(view: WebView, url: String) {
                    if (url.startsWith("file:///android_asset")) {
                        // Inject CSS when page is done loading
                        injectCSS(changelog, cssFile)
                    }
                    super.onPageFinished(view, url)
                }

                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    if (url.contains("file://")) {
                        view.loadUrl(url)
                    } else {
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        try {
                            startActivity(intent)
                        } catch (e: ActivityNotFoundException) {
                            view.loadUrl(url)
                        }
                    }
                    return true
                }
            }
        }
    }

    private fun loadBuildInfo(config: Config, buildInfo: TextView) {
        var buildInfoText: String?
        var tmp: String?
        val locale = Locale.getDefault()

        buildInfoText = String.format(
            locale, "<b>Package:</b> %s <br><b>Version:</b> v%s (build %s)",
            BuildConfig.APPLICATION_ID, config.appVersionName, config.appVersionCode
        )
        buildInfoText += if (config.getBuildConfigValue("FLAVOR", "").also { tmp = it }
                .isEmpty()) ""
        else {
            "<br><b>Flavor:</b> " + tmp!!.replace("flavor", "")
        }
    }

    private fun injectCSS(webView: WebView, cssAsset: String) {
        try {
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(
                "javascript:(function() {" +
                        "var parent = document.getElementsByTagName('head').item(0);" +
                        "var style = document.createElement('style');" +
                        "style.type = 'text/css';" +
                        // Tell the browser to BASE64-decode the string into your script !!!
                        "style.innerHTML = window.atob('" + "');" +
                        "parent.appendChild(style);" +
                        "})()"
            )

            webView.settings.javaScriptEnabled = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
