// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.android.launcher3.R;
import com.android.launcher3.allapps.AllAppsPagedView;
import java.lang.NullPointerException;
import java.lang.Override;

public final class AllAppsTabsBinding implements ViewBinding {
  @NonNull
  private final AllAppsPagedView rootView;

  @NonNull
  public final AllAppsPagedView allAppsTabsViewPager;

  private AllAppsTabsBinding(@NonNull AllAppsPagedView rootView,
      @NonNull AllAppsPagedView allAppsTabsViewPager) {
    this.rootView = rootView;
    this.allAppsTabsViewPager = allAppsTabsViewPager;
  }

  @Override
  @NonNull
  public AllAppsPagedView getRoot() {
    return rootView;
  }

  @NonNull
  public static AllAppsTabsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AllAppsTabsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.all_apps_tabs, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AllAppsTabsBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    AllAppsPagedView allAppsTabsViewPager = (AllAppsPagedView) rootView;

    return new AllAppsTabsBinding((AllAppsPagedView) rootView, allAppsTabsViewPager);
  }
}