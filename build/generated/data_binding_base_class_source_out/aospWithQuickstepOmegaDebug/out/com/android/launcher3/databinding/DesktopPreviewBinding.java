// Generated by view binder compiler. Do not edit!
package com.android.launcher3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.launcher3.R;
import com.saggitt.omega.icons.PreviewFrameView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DesktopPreviewBinding implements ViewBinding {
  @NonNull
  private final PreviewFrameView rootView;

  @NonNull
  public final ImageView iconInstagram;

  @NonNull
  public final ImageView iconPhotos;

  @NonNull
  public final PreviewFrameView iconPreview;

  @NonNull
  public final ImageView iconWhatsapp;

  @NonNull
  public final ImageView iconYoutube;

  @NonNull
  public final TextView itemInstagram;

  @NonNull
  public final TextView itemName;

  @NonNull
  public final TextView itemWs;

  @NonNull
  public final TextView itemYoutube;

  private DesktopPreviewBinding(@NonNull PreviewFrameView rootView,
      @NonNull ImageView iconInstagram, @NonNull ImageView iconPhotos,
      @NonNull PreviewFrameView iconPreview, @NonNull ImageView iconWhatsapp,
      @NonNull ImageView iconYoutube, @NonNull TextView itemInstagram, @NonNull TextView itemName,
      @NonNull TextView itemWs, @NonNull TextView itemYoutube) {
    this.rootView = rootView;
    this.iconInstagram = iconInstagram;
    this.iconPhotos = iconPhotos;
    this.iconPreview = iconPreview;
    this.iconWhatsapp = iconWhatsapp;
    this.iconYoutube = iconYoutube;
    this.itemInstagram = itemInstagram;
    this.itemName = itemName;
    this.itemWs = itemWs;
    this.itemYoutube = itemYoutube;
  }

  @Override
  @NonNull
  public PreviewFrameView getRoot() {
    return rootView;
  }

  @NonNull
  public static DesktopPreviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DesktopPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.desktop_preview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DesktopPreviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.icon_instagram;
      ImageView iconInstagram = ViewBindings.findChildViewById(rootView, id);
      if (iconInstagram == null) {
        break missingId;
      }

      id = R.id.icon_photos;
      ImageView iconPhotos = ViewBindings.findChildViewById(rootView, id);
      if (iconPhotos == null) {
        break missingId;
      }

      PreviewFrameView iconPreview = (PreviewFrameView) rootView;

      id = R.id.icon_whatsapp;
      ImageView iconWhatsapp = ViewBindings.findChildViewById(rootView, id);
      if (iconWhatsapp == null) {
        break missingId;
      }

      id = R.id.icon_youtube;
      ImageView iconYoutube = ViewBindings.findChildViewById(rootView, id);
      if (iconYoutube == null) {
        break missingId;
      }

      id = R.id.item_instagram;
      TextView itemInstagram = ViewBindings.findChildViewById(rootView, id);
      if (itemInstagram == null) {
        break missingId;
      }

      id = R.id.item_name;
      TextView itemName = ViewBindings.findChildViewById(rootView, id);
      if (itemName == null) {
        break missingId;
      }

      id = R.id.item_ws;
      TextView itemWs = ViewBindings.findChildViewById(rootView, id);
      if (itemWs == null) {
        break missingId;
      }

      id = R.id.item_youtube;
      TextView itemYoutube = ViewBindings.findChildViewById(rootView, id);
      if (itemYoutube == null) {
        break missingId;
      }

      return new DesktopPreviewBinding((PreviewFrameView) rootView, iconInstagram, iconPhotos,
          iconPreview, iconWhatsapp, iconYoutube, itemInstagram, itemName, itemWs, itemYoutube);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}