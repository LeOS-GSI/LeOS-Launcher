// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.android.launcher3.allapps.FloatingHeaderView;
import com.android.launcher3.allapps.PersonalWorkSlidingTabStrip;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AllAppsFloatingHeaderBinding implements ViewBinding {
  @NonNull
  private final FloatingHeaderView rootView;

  @NonNull
  public final FloatingHeaderView allAppsHeader;

  @NonNull
  public final PersonalWorkSlidingTabStrip tabs;

  @NonNull
  public final HorizontalScrollView tabsScroller;

  private AllAppsFloatingHeaderBinding(@NonNull FloatingHeaderView rootView,
      @NonNull FloatingHeaderView allAppsHeader, @NonNull PersonalWorkSlidingTabStrip tabs,
      @NonNull HorizontalScrollView tabsScroller) {
    this.rootView = rootView;
    this.allAppsHeader = allAppsHeader;
    this.tabs = tabs;
    this.tabsScroller = tabsScroller;
  }

  @Override
  @NonNull
  public FloatingHeaderView getRoot() {
    return rootView;
  }

  @NonNull
  public static AllAppsFloatingHeaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AllAppsFloatingHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.all_apps_floating_header, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AllAppsFloatingHeaderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FloatingHeaderView allAppsHeader = (FloatingHeaderView) rootView;

      id = R.id.tabs;
      PersonalWorkSlidingTabStrip tabs = ViewBindings.findChildViewById(rootView, id);
      if (tabs == null) {
        break missingId;
      }

      id = R.id.tabs_scroller;
      HorizontalScrollView tabsScroller = ViewBindings.findChildViewById(rootView, id);
      if (tabsScroller == null) {
        break missingId;
      }

      return new AllAppsFloatingHeaderBinding((FloatingHeaderView) rootView, allAppsHeader, tabs,
          tabsScroller);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}