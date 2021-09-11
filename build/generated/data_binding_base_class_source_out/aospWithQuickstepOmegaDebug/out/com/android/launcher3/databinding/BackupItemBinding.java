// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.saggitt.omega.views.ScreenshotPreview;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BackupItemBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final CardView backupItem;

  @NonNull
  public final ImageView preview;

  @NonNull
  public final ScreenshotPreview previewContainer;

  @NonNull
  public final TextView summary;

  @NonNull
  public final TextView title;

  @NonNull
  public final ImageView wallpaper;

  private BackupItemBinding(@NonNull FrameLayout rootView, @NonNull CardView backupItem,
      @NonNull ImageView preview, @NonNull ScreenshotPreview previewContainer,
      @NonNull TextView summary, @NonNull TextView title, @NonNull ImageView wallpaper) {
    this.rootView = rootView;
    this.backupItem = backupItem;
    this.preview = preview;
    this.previewContainer = previewContainer;
    this.summary = summary;
    this.title = title;
    this.wallpaper = wallpaper;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BackupItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BackupItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.backup_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BackupItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backup_item;
      CardView backupItem = ViewBindings.findChildViewById(rootView, id);
      if (backupItem == null) {
        break missingId;
      }

      id = R.id.preview;
      ImageView preview = ViewBindings.findChildViewById(rootView, id);
      if (preview == null) {
        break missingId;
      }

      id = R.id.preview_container;
      ScreenshotPreview previewContainer = ViewBindings.findChildViewById(rootView, id);
      if (previewContainer == null) {
        break missingId;
      }

      id = android.R.id.summary;
      TextView summary = ViewBindings.findChildViewById(rootView, id);
      if (summary == null) {
        break missingId;
      }

      id = android.R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.wallpaper;
      ImageView wallpaper = ViewBindings.findChildViewById(rootView, id);
      if (wallpaper == null) {
        break missingId;
      }

      return new BackupItemBinding((FrameLayout) rootView, backupItem, preview, previewContainer,
          summary, title, wallpaper);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}