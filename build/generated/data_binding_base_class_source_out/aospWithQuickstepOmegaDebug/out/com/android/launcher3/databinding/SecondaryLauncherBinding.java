// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.android.launcher3.allapps.AllAppsContainerView;
import com.android.launcher3.allapps.search.AppsSearchContainerLayout;
import com.android.launcher3.secondarydisplay.SecondaryDragLayer;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SecondaryLauncherBinding implements ViewBinding {
  @NonNull
  private final SecondaryDragLayer rootView;

  @NonNull
  public final ImageButton allAppsButton;

  @NonNull
  public final AllAppsContainerView appsView;

  @NonNull
  public final SecondaryDragLayer dragLayer;

  @NonNull
  public final AppsSearchContainerLayout searchContainerAllApps;

  @NonNull
  public final GridView workspaceGrid;

  private SecondaryLauncherBinding(@NonNull SecondaryDragLayer rootView,
      @NonNull ImageButton allAppsButton, @NonNull AllAppsContainerView appsView,
      @NonNull SecondaryDragLayer dragLayer,
      @NonNull AppsSearchContainerLayout searchContainerAllApps, @NonNull GridView workspaceGrid) {
    this.rootView = rootView;
    this.allAppsButton = allAppsButton;
    this.appsView = appsView;
    this.dragLayer = dragLayer;
    this.searchContainerAllApps = searchContainerAllApps;
    this.workspaceGrid = workspaceGrid;
  }

  @Override
  @NonNull
  public SecondaryDragLayer getRoot() {
    return rootView;
  }

  @NonNull
  public static SecondaryLauncherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SecondaryLauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.secondary_launcher, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SecondaryLauncherBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.all_apps_button;
      ImageButton allAppsButton = ViewBindings.findChildViewById(rootView, id);
      if (allAppsButton == null) {
        break missingId;
      }

      id = R.id.apps_view;
      AllAppsContainerView appsView = ViewBindings.findChildViewById(rootView, id);
      if (appsView == null) {
        break missingId;
      }

      SecondaryDragLayer dragLayer = (SecondaryDragLayer) rootView;

      id = R.id.search_container_all_apps;
      AppsSearchContainerLayout searchContainerAllApps = ViewBindings.findChildViewById(rootView, id);
      if (searchContainerAllApps == null) {
        break missingId;
      }

      id = R.id.workspace_grid;
      GridView workspaceGrid = ViewBindings.findChildViewById(rootView, id);
      if (workspaceGrid == null) {
        break missingId;
      }

      return new SecondaryLauncherBinding((SecondaryDragLayer) rootView, allAppsButton, appsView,
          dragLayer, searchContainerAllApps, workspaceGrid);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}