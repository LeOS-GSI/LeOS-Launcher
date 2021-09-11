// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.CellLayout;
import com.android.launcher3.R;
import com.android.launcher3.hybridhotseat.HotseatEduDialog;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PredictedHotseatEduBinding implements ViewBinding {
  @NonNull
  private final HotseatEduDialog rootView;

  @NonNull
  public final TextView hotseatEduContent;

  @NonNull
  public final TextView hotseatEduHeading;

  @NonNull
  public final LinearLayout hotseatWrapper;

  @NonNull
  public final Button noThanks;

  @NonNull
  public final CellLayout samplePrediction;

  @NonNull
  public final Button turnPredictionsOn;

  private PredictedHotseatEduBinding(@NonNull HotseatEduDialog rootView,
      @NonNull TextView hotseatEduContent, @NonNull TextView hotseatEduHeading,
      @NonNull LinearLayout hotseatWrapper, @NonNull Button noThanks,
      @NonNull CellLayout samplePrediction, @NonNull Button turnPredictionsOn) {
    this.rootView = rootView;
    this.hotseatEduContent = hotseatEduContent;
    this.hotseatEduHeading = hotseatEduHeading;
    this.hotseatWrapper = hotseatWrapper;
    this.noThanks = noThanks;
    this.samplePrediction = samplePrediction;
    this.turnPredictionsOn = turnPredictionsOn;
  }

  @Override
  @NonNull
  public HotseatEduDialog getRoot() {
    return rootView;
  }

  @NonNull
  public static PredictedHotseatEduBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PredictedHotseatEduBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.predicted_hotseat_edu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PredictedHotseatEduBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.hotseat_edu_content;
      TextView hotseatEduContent = ViewBindings.findChildViewById(rootView, id);
      if (hotseatEduContent == null) {
        break missingId;
      }

      id = R.id.hotseat_edu_heading;
      TextView hotseatEduHeading = ViewBindings.findChildViewById(rootView, id);
      if (hotseatEduHeading == null) {
        break missingId;
      }

      id = R.id.hotseat_wrapper;
      LinearLayout hotseatWrapper = ViewBindings.findChildViewById(rootView, id);
      if (hotseatWrapper == null) {
        break missingId;
      }

      id = R.id.no_thanks;
      Button noThanks = ViewBindings.findChildViewById(rootView, id);
      if (noThanks == null) {
        break missingId;
      }

      id = R.id.sample_prediction;
      CellLayout samplePrediction = ViewBindings.findChildViewById(rootView, id);
      if (samplePrediction == null) {
        break missingId;
      }

      id = R.id.turn_predictions_on;
      Button turnPredictionsOn = ViewBindings.findChildViewById(rootView, id);
      if (turnPredictionsOn == null) {
        break missingId;
      }

      return new PredictedHotseatEduBinding((HotseatEduDialog) rootView, hotseatEduContent,
          hotseatEduHeading, hotseatWrapper, noThanks, samplePrediction, turnPredictionsOn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}