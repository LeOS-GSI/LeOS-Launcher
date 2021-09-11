// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BackupMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView actionNewBackup;

  @NonNull
  public final CardView actionRestoreBackup;

  @NonNull
  public final TextView localBackupTitle;

  private BackupMenuBinding(@NonNull ConstraintLayout rootView, @NonNull CardView actionNewBackup,
      @NonNull CardView actionRestoreBackup, @NonNull TextView localBackupTitle) {
    this.rootView = rootView;
    this.actionNewBackup = actionNewBackup;
    this.actionRestoreBackup = actionRestoreBackup;
    this.localBackupTitle = localBackupTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BackupMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BackupMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.backup_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BackupMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.action_new_backup;
      CardView actionNewBackup = ViewBindings.findChildViewById(rootView, id);
      if (actionNewBackup == null) {
        break missingId;
      }

      id = R.id.action_restore_backup;
      CardView actionRestoreBackup = ViewBindings.findChildViewById(rootView, id);
      if (actionRestoreBackup == null) {
        break missingId;
      }

      id = R.id.local_backup_title;
      TextView localBackupTitle = ViewBindings.findChildViewById(rootView, id);
      if (localBackupTitle == null) {
        break missingId;
      }

      return new BackupMenuBinding((ConstraintLayout) rootView, actionNewBackup,
          actionRestoreBackup, localBackupTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}