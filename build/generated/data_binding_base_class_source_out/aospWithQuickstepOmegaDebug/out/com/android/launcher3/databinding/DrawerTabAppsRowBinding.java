// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DrawerTabAppsRowBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final AppCompatTextView appsCount;

  @NonNull
  public final LinearLayoutCompat manageApps;

  @NonNull
  public final AppCompatImageView manageAppsIcon;

  @NonNull
  public final AppCompatTextView manageAppsTitle;

  private DrawerTabAppsRowBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull AppCompatTextView appsCount, @NonNull LinearLayoutCompat manageApps,
      @NonNull AppCompatImageView manageAppsIcon, @NonNull AppCompatTextView manageAppsTitle) {
    this.rootView = rootView;
    this.appsCount = appsCount;
    this.manageApps = manageApps;
    this.manageAppsIcon = manageAppsIcon;
    this.manageAppsTitle = manageAppsTitle;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static DrawerTabAppsRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DrawerTabAppsRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.drawer_tab_apps_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DrawerTabAppsRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.apps_count;
      AppCompatTextView appsCount = ViewBindings.findChildViewById(rootView, id);
      if (appsCount == null) {
        break missingId;
      }

      LinearLayoutCompat manageApps = (LinearLayoutCompat) rootView;

      id = R.id.manage_apps_icon;
      AppCompatImageView manageAppsIcon = ViewBindings.findChildViewById(rootView, id);
      if (manageAppsIcon == null) {
        break missingId;
      }

      id = R.id.manage_apps_title;
      AppCompatTextView manageAppsTitle = ViewBindings.findChildViewById(rootView, id);
      if (manageAppsTitle == null) {
        break missingId;
      }

      return new DrawerTabAppsRowBinding((LinearLayoutCompat) rootView, appsCount, manageApps,
          manageAppsIcon, manageAppsTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}