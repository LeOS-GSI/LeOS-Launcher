// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.DeleteDropTarget;
import com.android.launcher3.DropTargetBar;
import com.android.launcher3.R;
import com.android.launcher3.SecondaryDropTarget;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DropTargetBarBinding implements ViewBinding {
  @NonNull
  private final DropTargetBar rootView;

  @NonNull
  public final DeleteDropTarget deleteTargetText;

  @NonNull
  public final SecondaryDropTarget uninstallTargetText;

  private DropTargetBarBinding(@NonNull DropTargetBar rootView,
      @NonNull DeleteDropTarget deleteTargetText,
      @NonNull SecondaryDropTarget uninstallTargetText) {
    this.rootView = rootView;
    this.deleteTargetText = deleteTargetText;
    this.uninstallTargetText = uninstallTargetText;
  }

  @Override
  @NonNull
  public DropTargetBar getRoot() {
    return rootView;
  }

  @NonNull
  public static DropTargetBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DropTargetBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.drop_target_bar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DropTargetBarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delete_target_text;
      DeleteDropTarget deleteTargetText = ViewBindings.findChildViewById(rootView, id);
      if (deleteTargetText == null) {
        break missingId;
      }

      id = R.id.uninstall_target_text;
      SecondaryDropTarget uninstallTargetText = ViewBindings.findChildViewById(rootView, id);
      if (uninstallTargetText == null) {
        break missingId;
      }

      return new DropTargetBarBinding((DropTargetBar) rootView, deleteTargetText,
          uninstallTargetText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}