// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.google.android.apps.nexuslauncher.graphics.DoubleShadowTextView;
import com.google.android.apps.nexuslauncher.graphics.IcuDateTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SmartspaceSinglelineBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final IcuDateTextView clock;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final ConstraintLayout smartspaceContent;

  @NonNull
  public final AppCompatImageView subtitleIcon;

  @NonNull
  public final LinearLayout subtitleLine;

  @NonNull
  public final DoubleShadowTextView subtitleText;

  @NonNull
  public final IcuDateTextView timeAbove;

  @NonNull
  public final LinearLayout titleWeatherContent;

  @NonNull
  public final AppCompatImageView titleWeatherIcon;

  @NonNull
  public final DoubleShadowTextView titleWeatherText;

  private SmartspaceSinglelineBinding(@NonNull ConstraintLayout rootView,
      @NonNull IcuDateTextView clock, @NonNull LinearLayout linearLayout,
      @NonNull ConstraintLayout smartspaceContent, @NonNull AppCompatImageView subtitleIcon,
      @NonNull LinearLayout subtitleLine, @NonNull DoubleShadowTextView subtitleText,
      @NonNull IcuDateTextView timeAbove, @NonNull LinearLayout titleWeatherContent,
      @NonNull AppCompatImageView titleWeatherIcon,
      @NonNull DoubleShadowTextView titleWeatherText) {
    this.rootView = rootView;
    this.clock = clock;
    this.linearLayout = linearLayout;
    this.smartspaceContent = smartspaceContent;
    this.subtitleIcon = subtitleIcon;
    this.subtitleLine = subtitleLine;
    this.subtitleText = subtitleText;
    this.timeAbove = timeAbove;
    this.titleWeatherContent = titleWeatherContent;
    this.titleWeatherIcon = titleWeatherIcon;
    this.titleWeatherText = titleWeatherText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SmartspaceSinglelineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SmartspaceSinglelineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.smartspace_singleline, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SmartspaceSinglelineBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clock;
      IcuDateTextView clock = ViewBindings.findChildViewById(rootView, id);
      if (clock == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      ConstraintLayout smartspaceContent = (ConstraintLayout) rootView;

      id = R.id.subtitle_icon;
      AppCompatImageView subtitleIcon = ViewBindings.findChildViewById(rootView, id);
      if (subtitleIcon == null) {
        break missingId;
      }

      id = R.id.subtitle_line;
      LinearLayout subtitleLine = ViewBindings.findChildViewById(rootView, id);
      if (subtitleLine == null) {
        break missingId;
      }

      id = R.id.subtitle_text;
      DoubleShadowTextView subtitleText = ViewBindings.findChildViewById(rootView, id);
      if (subtitleText == null) {
        break missingId;
      }

      id = R.id.time_above;
      IcuDateTextView timeAbove = ViewBindings.findChildViewById(rootView, id);
      if (timeAbove == null) {
        break missingId;
      }

      id = R.id.title_weather_content;
      LinearLayout titleWeatherContent = ViewBindings.findChildViewById(rootView, id);
      if (titleWeatherContent == null) {
        break missingId;
      }

      id = R.id.title_weather_icon;
      AppCompatImageView titleWeatherIcon = ViewBindings.findChildViewById(rootView, id);
      if (titleWeatherIcon == null) {
        break missingId;
      }

      id = R.id.title_weather_text;
      DoubleShadowTextView titleWeatherText = ViewBindings.findChildViewById(rootView, id);
      if (titleWeatherText == null) {
        break missingId;
      }

      return new SmartspaceSinglelineBinding((ConstraintLayout) rootView, clock, linearLayout,
          smartspaceContent, subtitleIcon, subtitleLine, subtitleText, timeAbove,
          titleWeatherContent, titleWeatherIcon, titleWeatherText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}