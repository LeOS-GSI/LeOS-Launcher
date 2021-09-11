// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.android.quickstep.views.IconView;
import com.android.quickstep.views.TaskThumbnailView;
import com.android.quickstep.views.TaskView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TaskBinding implements ViewBinding {
  @NonNull
  private final TaskView rootView;

  @NonNull
  public final IconView icon;

  @NonNull
  public final TaskThumbnailView snapshot;

  private TaskBinding(@NonNull TaskView rootView, @NonNull IconView icon,
      @NonNull TaskThumbnailView snapshot) {
    this.rootView = rootView;
    this.icon = icon;
    this.snapshot = snapshot;
  }

  @Override
  @NonNull
  public TaskView getRoot() {
    return rootView;
  }

  @NonNull
  public static TaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TaskBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.task, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TaskBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.icon;
      IconView icon = ViewBindings.findChildViewById(rootView, id);
      if (icon == null) {
        break missingId;
      }

      id = R.id.snapshot;
      TaskThumbnailView snapshot = ViewBindings.findChildViewById(rootView, id);
      if (snapshot == null) {
        break missingId;
      }

      return new TaskBinding((TaskView) rootView, icon, snapshot);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}