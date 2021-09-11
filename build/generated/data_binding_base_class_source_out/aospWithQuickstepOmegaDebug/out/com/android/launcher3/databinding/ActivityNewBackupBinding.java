// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityNewBackupBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final ConstraintLayout config;

  @NonNull
  public final CoordinatorLayout content;

  @NonNull
  public final CheckBox contentHomescreen;

  @NonNull
  public final CheckBox contentSettings;

  @NonNull
  public final CheckBox contentWallpaper;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final RadioButton locationDevice;

  @NonNull
  public final RadioButton locationDocuments;

  @NonNull
  public final TextInputEditText name;

  @NonNull
  public final LinearLayout progress;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextInputLayout textInputLayout;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView7;

  private ActivityNewBackupBinding(@NonNull CoordinatorLayout rootView,
      @NonNull ConstraintLayout config, @NonNull CoordinatorLayout content,
      @NonNull CheckBox contentHomescreen, @NonNull CheckBox contentSettings,
      @NonNull CheckBox contentWallpaper, @NonNull FloatingActionButton fab,
      @NonNull RadioButton locationDevice, @NonNull RadioButton locationDocuments,
      @NonNull TextInputEditText name, @NonNull LinearLayout progress,
      @NonNull ProgressBar progressBar, @NonNull TextInputLayout textInputLayout,
      @NonNull TextView textView3, @NonNull TextView textView7) {
    this.rootView = rootView;
    this.config = config;
    this.content = content;
    this.contentHomescreen = contentHomescreen;
    this.contentSettings = contentSettings;
    this.contentWallpaper = contentWallpaper;
    this.fab = fab;
    this.locationDevice = locationDevice;
    this.locationDocuments = locationDocuments;
    this.name = name;
    this.progress = progress;
    this.progressBar = progressBar;
    this.textInputLayout = textInputLayout;
    this.textView3 = textView3;
    this.textView7 = textView7;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNewBackupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNewBackupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_new_backup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNewBackupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.config;
      ConstraintLayout config = ViewBindings.findChildViewById(rootView, id);
      if (config == null) {
        break missingId;
      }

      CoordinatorLayout content = (CoordinatorLayout) rootView;

      id = R.id.content_homescreen;
      CheckBox contentHomescreen = ViewBindings.findChildViewById(rootView, id);
      if (contentHomescreen == null) {
        break missingId;
      }

      id = R.id.content_settings;
      CheckBox contentSettings = ViewBindings.findChildViewById(rootView, id);
      if (contentSettings == null) {
        break missingId;
      }

      id = R.id.content_wallpaper;
      CheckBox contentWallpaper = ViewBindings.findChildViewById(rootView, id);
      if (contentWallpaper == null) {
        break missingId;
      }

      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);
      if (fab == null) {
        break missingId;
      }

      id = R.id.location_device;
      RadioButton locationDevice = ViewBindings.findChildViewById(rootView, id);
      if (locationDevice == null) {
        break missingId;
      }

      id = R.id.location_documents;
      RadioButton locationDocuments = ViewBindings.findChildViewById(rootView, id);
      if (locationDocuments == null) {
        break missingId;
      }

      id = R.id.name;
      TextInputEditText name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.progress;
      LinearLayout progress = ViewBindings.findChildViewById(rootView, id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.textInputLayout;
      TextInputLayout textInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      return new ActivityNewBackupBinding((CoordinatorLayout) rootView, config, content,
          contentHomescreen, contentSettings, contentWallpaper, fab, locationDevice,
          locationDocuments, name, progress, progressBar, textInputLayout, textView3, textView7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}