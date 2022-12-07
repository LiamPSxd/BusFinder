// Generated by view binder compiler. Do not edit!
package com.gammasoft.busfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.gammasoft.busfinder.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import io.alterac.blurkit.BlurLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TarjetaModificarRutaBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final BlurLayout blurLayout;

  @NonNull
  public final ImageButton btnAtras;

  @NonNull
  public final Button btnCancelar;

  @NonNull
  public final ImageButton btnLimpiar;

  @NonNull
  public final Button btnModificar;

  @NonNull
  public final View dragArea;

  @NonNull
  public final ImageView dragHandleImage;

  @NonNull
  public final TextInputLayout etqRuta;

  @NonNull
  public final TextView ins1;

  @NonNull
  public final TextView ins2;

  @NonNull
  public final CardView mapa;

  @NonNull
  public final RelativeLayout modificarRuta;

  @NonNull
  public final CardView tarjeta;

  @NonNull
  public final TextInputEditText txtRuta;

  private TarjetaModificarRutaBinding(@NonNull RelativeLayout rootView,
      @NonNull BlurLayout blurLayout, @NonNull ImageButton btnAtras, @NonNull Button btnCancelar,
      @NonNull ImageButton btnLimpiar, @NonNull Button btnModificar, @NonNull View dragArea,
      @NonNull ImageView dragHandleImage, @NonNull TextInputLayout etqRuta, @NonNull TextView ins1,
      @NonNull TextView ins2, @NonNull CardView mapa, @NonNull RelativeLayout modificarRuta,
      @NonNull CardView tarjeta, @NonNull TextInputEditText txtRuta) {
    this.rootView = rootView;
    this.blurLayout = blurLayout;
    this.btnAtras = btnAtras;
    this.btnCancelar = btnCancelar;
    this.btnLimpiar = btnLimpiar;
    this.btnModificar = btnModificar;
    this.dragArea = dragArea;
    this.dragHandleImage = dragHandleImage;
    this.etqRuta = etqRuta;
    this.ins1 = ins1;
    this.ins2 = ins2;
    this.mapa = mapa;
    this.modificarRuta = modificarRuta;
    this.tarjeta = tarjeta;
    this.txtRuta = txtRuta;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TarjetaModificarRutaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TarjetaModificarRutaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.tarjeta_modificar_ruta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TarjetaModificarRutaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.blurLayout;
      BlurLayout blurLayout = ViewBindings.findChildViewById(rootView, id);
      if (blurLayout == null) {
        break missingId;
      }

      id = R.id.btnAtras;
      ImageButton btnAtras = ViewBindings.findChildViewById(rootView, id);
      if (btnAtras == null) {
        break missingId;
      }

      id = R.id.btnCancelar;
      Button btnCancelar = ViewBindings.findChildViewById(rootView, id);
      if (btnCancelar == null) {
        break missingId;
      }

      id = R.id.btnLimpiar;
      ImageButton btnLimpiar = ViewBindings.findChildViewById(rootView, id);
      if (btnLimpiar == null) {
        break missingId;
      }

      id = R.id.btnModificar;
      Button btnModificar = ViewBindings.findChildViewById(rootView, id);
      if (btnModificar == null) {
        break missingId;
      }

      id = R.id.dragArea;
      View dragArea = ViewBindings.findChildViewById(rootView, id);
      if (dragArea == null) {
        break missingId;
      }

      id = R.id.dragHandleImage;
      ImageView dragHandleImage = ViewBindings.findChildViewById(rootView, id);
      if (dragHandleImage == null) {
        break missingId;
      }

      id = R.id.etqRuta;
      TextInputLayout etqRuta = ViewBindings.findChildViewById(rootView, id);
      if (etqRuta == null) {
        break missingId;
      }

      id = R.id.ins1;
      TextView ins1 = ViewBindings.findChildViewById(rootView, id);
      if (ins1 == null) {
        break missingId;
      }

      id = R.id.ins2;
      TextView ins2 = ViewBindings.findChildViewById(rootView, id);
      if (ins2 == null) {
        break missingId;
      }

      id = R.id.mapa;
      CardView mapa = ViewBindings.findChildViewById(rootView, id);
      if (mapa == null) {
        break missingId;
      }

      RelativeLayout modificarRuta = (RelativeLayout) rootView;

      id = R.id.tarjeta;
      CardView tarjeta = ViewBindings.findChildViewById(rootView, id);
      if (tarjeta == null) {
        break missingId;
      }

      id = R.id.txtRuta;
      TextInputEditText txtRuta = ViewBindings.findChildViewById(rootView, id);
      if (txtRuta == null) {
        break missingId;
      }

      return new TarjetaModificarRutaBinding((RelativeLayout) rootView, blurLayout, btnAtras,
          btnCancelar, btnLimpiar, btnModificar, dragArea, dragHandleImage, etqRuta, ins1, ins2,
          mapa, modificarRuta, tarjeta, txtRuta);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
