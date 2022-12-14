// Generated by view binder compiler. Do not edit!
package com.gammasoft.busfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.gammasoft.busfinder.R;
import io.alterac.blurkit.BlurLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TarjetaBlurBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final BlurLayout blurLayout;

  @NonNull
  public final Button btnAceptar;

  @NonNull
  public final View dragArea;

  @NonNull
  public final ImageView dragHandleImage;

  @NonNull
  public final TextView etqTitulo;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final CardView tarjeta;

  @NonNull
  public final TextView txtMensaje;

  private TarjetaBlurBinding(@NonNull FrameLayout rootView, @NonNull BlurLayout blurLayout,
      @NonNull Button btnAceptar, @NonNull View dragArea, @NonNull ImageView dragHandleImage,
      @NonNull TextView etqTitulo, @NonNull ScrollView scrollView, @NonNull CardView tarjeta,
      @NonNull TextView txtMensaje) {
    this.rootView = rootView;
    this.blurLayout = blurLayout;
    this.btnAceptar = btnAceptar;
    this.dragArea = dragArea;
    this.dragHandleImage = dragHandleImage;
    this.etqTitulo = etqTitulo;
    this.scrollView = scrollView;
    this.tarjeta = tarjeta;
    this.txtMensaje = txtMensaje;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TarjetaBlurBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TarjetaBlurBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.tarjeta_blur, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TarjetaBlurBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.blurLayout;
      BlurLayout blurLayout = ViewBindings.findChildViewById(rootView, id);
      if (blurLayout == null) {
        break missingId;
      }

      id = R.id.btnAceptar;
      Button btnAceptar = ViewBindings.findChildViewById(rootView, id);
      if (btnAceptar == null) {
        break missingId;
      }

      id = R.id.dragArea;
      View dragArea = ViewBindings.findChildViewById(rootView, id);
      if (dragArea == null) {
        break missingId;
      }

      id = R.id.drag_handle_image;
      ImageView dragHandleImage = ViewBindings.findChildViewById(rootView, id);
      if (dragHandleImage == null) {
        break missingId;
      }

      id = R.id.etqTitulo;
      TextView etqTitulo = ViewBindings.findChildViewById(rootView, id);
      if (etqTitulo == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.tarjeta;
      CardView tarjeta = ViewBindings.findChildViewById(rootView, id);
      if (tarjeta == null) {
        break missingId;
      }

      id = R.id.txtMensaje;
      TextView txtMensaje = ViewBindings.findChildViewById(rootView, id);
      if (txtMensaje == null) {
        break missingId;
      }

      return new TarjetaBlurBinding((FrameLayout) rootView, blurLayout, btnAceptar, dragArea,
          dragHandleImage, etqTitulo, scrollView, tarjeta, txtMensaje);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
