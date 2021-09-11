// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.android.launcher3.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class AllAppsSearchMarketBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  @NonNull
  public final TextView searchMarketText;

  private AllAppsSearchMarketBinding(@NonNull TextView rootView,
      @NonNull TextView searchMarketText) {
    this.rootView = rootView;
    this.searchMarketText = searchMarketText;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static AllAppsSearchMarketBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AllAppsSearchMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.all_apps_search_market, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AllAppsSearchMarketBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    TextView searchMarketText = (TextView) rootView;

    return new AllAppsSearchMarketBinding((TextView) rootView, searchMarketText);
  }
}