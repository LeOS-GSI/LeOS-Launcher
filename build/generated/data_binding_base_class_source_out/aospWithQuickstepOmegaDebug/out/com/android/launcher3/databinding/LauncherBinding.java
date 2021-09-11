// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.LauncherRootView;
import com.android.launcher3.R;
import com.android.launcher3.Workspace;
import com.android.launcher3.dragndrop.DragLayer;
import com.android.launcher3.pageindicators.WorkspacePageIndicator;
import com.saggitt.omega.views.OmegaBackgroundView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LauncherBinding implements ViewBinding {
  @NonNull
  private final LauncherRootView rootView;

  @NonNull
  public final AllAppsBinding appsView;

  @NonNull
  public final DragLayer dragLayer;

  @NonNull
  public final DropTargetBarBinding dropTargetBar;

  @NonNull
  public final View dummyView;

  @NonNull
  public final HotseatBinding hotseat;

  @NonNull
  public final LauncherRootView launcher;

  @NonNull
  public final OmegaBackgroundView omegaBackground;

  @NonNull
  public final OptionsViewBinding optionsView;

  @NonNull
  public final OverviewPanelBinding overviewPanel;

  @NonNull
  public final WorkspacePageIndicator pageIndicator;

  @NonNull
  public final ScrimViewBinding scrimView;

  @NonNull
  public final Workspace workspace;

  private LauncherBinding(@NonNull LauncherRootView rootView, @NonNull AllAppsBinding appsView,
      @NonNull DragLayer dragLayer, @NonNull DropTargetBarBinding dropTargetBar,
      @NonNull View dummyView, @NonNull HotseatBinding hotseat, @NonNull LauncherRootView launcher,
      @NonNull OmegaBackgroundView omegaBackground, @NonNull OptionsViewBinding optionsView,
      @NonNull OverviewPanelBinding overviewPanel, @NonNull WorkspacePageIndicator pageIndicator,
      @NonNull ScrimViewBinding scrimView, @NonNull Workspace workspace) {
    this.rootView = rootView;
    this.appsView = appsView;
    this.dragLayer = dragLayer;
    this.dropTargetBar = dropTargetBar;
    this.dummyView = dummyView;
    this.hotseat = hotseat;
    this.launcher = launcher;
    this.omegaBackground = omegaBackground;
    this.optionsView = optionsView;
    this.overviewPanel = overviewPanel;
    this.pageIndicator = pageIndicator;
    this.scrimView = scrimView;
    this.workspace = workspace;
  }

  @Override
  @NonNull
  public LauncherRootView getRoot() {
    return rootView;
  }

  @NonNull
  public static LauncherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.launcher, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LauncherBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.apps_view;
      View appsView = ViewBindings.findChildViewById(rootView, id);
      if (appsView == null) {
        break missingId;
      }
      AllAppsBinding binding_appsView = AllAppsBinding.bind(appsView);

      id = R.id.drag_layer;
      DragLayer dragLayer = ViewBindings.findChildViewById(rootView, id);
      if (dragLayer == null) {
        break missingId;
      }

      id = R.id.drop_target_bar;
      View dropTargetBar = ViewBindings.findChildViewById(rootView, id);
      if (dropTargetBar == null) {
        break missingId;
      }
      DropTargetBarBinding binding_dropTargetBar = DropTargetBarBinding.bind(dropTargetBar);

      id = R.id.dummy_view;
      View dummyView = ViewBindings.findChildViewById(rootView, id);
      if (dummyView == null) {
        break missingId;
      }

      id = R.id.hotseat;
      View hotseat = ViewBindings.findChildViewById(rootView, id);
      if (hotseat == null) {
        break missingId;
      }
      HotseatBinding binding_hotseat = HotseatBinding.bind(hotseat);

      LauncherRootView launcher = (LauncherRootView) rootView;

      id = R.id.omega_background;
      OmegaBackgroundView omegaBackground = ViewBindings.findChildViewById(rootView, id);
      if (omegaBackground == null) {
        break missingId;
      }

      id = R.id.options_view;
      View optionsView = ViewBindings.findChildViewById(rootView, id);
      if (optionsView == null) {
        break missingId;
      }
      OptionsViewBinding binding_optionsView = OptionsViewBinding.bind(optionsView);

      id = R.id.overview_panel;
      View overviewPanel = ViewBindings.findChildViewById(rootView, id);
      if (overviewPanel == null) {
        break missingId;
      }
      OverviewPanelBinding binding_overviewPanel = OverviewPanelBinding.bind(overviewPanel);

      id = R.id.page_indicator;
      WorkspacePageIndicator pageIndicator = ViewBindings.findChildViewById(rootView, id);
      if (pageIndicator == null) {
        break missingId;
      }

      id = R.id.scrim_view;
      View scrimView = ViewBindings.findChildViewById(rootView, id);
      if (scrimView == null) {
        break missingId;
      }
      ScrimViewBinding binding_scrimView = ScrimViewBinding.bind(scrimView);

      id = R.id.workspace;
      Workspace workspace = ViewBindings.findChildViewById(rootView, id);
      if (workspace == null) {
        break missingId;
      }

      return new LauncherBinding((LauncherRootView) rootView, binding_appsView, dragLayer,
          binding_dropTargetBar, dummyView, binding_hotseat, launcher, omegaBackground,
          binding_optionsView, binding_overviewPanel, pageIndicator, binding_scrimView, workspace);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}