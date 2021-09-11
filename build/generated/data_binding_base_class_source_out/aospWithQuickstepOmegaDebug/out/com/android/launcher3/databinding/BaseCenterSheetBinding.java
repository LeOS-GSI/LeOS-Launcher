// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.saggitt.omega.views.CenterFloatingView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BaseCenterSheetBinding implements ViewBinding {
  @NonNull
  private final CenterFloatingView rootView;

  @NonNull
  public final CenterFloatingView content;

  @NonNull
  public final FrameLayout sheetContents;

  private BaseCenterSheetBinding(@NonNull CenterFloatingView rootView,
      @NonNull CenterFloatingView content, @NonNull FrameLayout sheetContents) {
    this.rootView = rootView;
    this.content = content;
    this.sheetContents = sheetContents;
  }

  @Override
  @NonNull
  public CenterFloatingView getRoot() {
    return rootView;
  }

  @NonNull
  public static BaseCenterSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BaseCenterSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.base_center_sheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BaseCenterSheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CenterFloatingView content = (CenterFloatingView) rootView;

      id = R.id.sheet_contents;
      FrameLayout sheetContents = ViewBindings.findChildViewById(rootView, id);
      if (sheetContents == null) {
        break missingId;
      }

      return new BaseCenterSheetBinding((CenterFloatingView) rootView, content, sheetContents);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}