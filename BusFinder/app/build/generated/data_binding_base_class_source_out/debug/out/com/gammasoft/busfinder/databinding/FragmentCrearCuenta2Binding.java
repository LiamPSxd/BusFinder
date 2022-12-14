// Generated by view binder compiler. Do not edit!
package com.gammasoft.busfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.gammasoft.busfinder.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCrearCuenta2Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton btnCambiarFotoPerfil;

  @NonNull
  public final FloatingActionButton btnContinuar;

  @NonNull
  public final ImageButton btnFacebook;

  @NonNull
  public final ImageButton btnGoogle;

  @NonNull
  public final ImageButton btnTwitter;

  @NonNull
  public final TextInputLayout etqConfirmarContrasenia;

  @NonNull
  public final TextInputLayout etqContrasenia;

  @NonNull
  public final TextInputLayout etqCorreo;

  @NonNull
  public final TextView etqRedesSociales;

  @NonNull
  public final TextInputLayout etqUsuario;

  @NonNull
  public final CardView fondo1;

  @NonNull
  public final CardView fondo2;

  @NonNull
  public final CircleImageView fotoPerfil;

  @NonNull
  public final RelativeLayout subRelative1;

  @NonNull
  public final RelativeLayout subRelative2;

  @NonNull
  public final TextInputEditText txtConfirmarContrasenia;

  @NonNull
  public final TextInputEditText txtContrasenia;

  @NonNull
  public final TextInputEditText txtCorreo;

  @NonNull
  public final TextInputEditText txtUsuario;

  private FragmentCrearCuenta2Binding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton btnCambiarFotoPerfil,
      @NonNull FloatingActionButton btnContinuar, @NonNull ImageButton btnFacebook,
      @NonNull ImageButton btnGoogle, @NonNull ImageButton btnTwitter,
      @NonNull TextInputLayout etqConfirmarContrasenia, @NonNull TextInputLayout etqContrasenia,
      @NonNull TextInputLayout etqCorreo, @NonNull TextView etqRedesSociales,
      @NonNull TextInputLayout etqUsuario, @NonNull CardView fondo1, @NonNull CardView fondo2,
      @NonNull CircleImageView fotoPerfil, @NonNull RelativeLayout subRelative1,
      @NonNull RelativeLayout subRelative2, @NonNull TextInputEditText txtConfirmarContrasenia,
      @NonNull TextInputEditText txtContrasenia, @NonNull TextInputEditText txtCorreo,
      @NonNull TextInputEditText txtUsuario) {
    this.rootView = rootView;
    this.btnCambiarFotoPerfil = btnCambiarFotoPerfil;
    this.btnContinuar = btnContinuar;
    this.btnFacebook = btnFacebook;
    this.btnGoogle = btnGoogle;
    this.btnTwitter = btnTwitter;
    this.etqConfirmarContrasenia = etqConfirmarContrasenia;
    this.etqContrasenia = etqContrasenia;
    this.etqCorreo = etqCorreo;
    this.etqRedesSociales = etqRedesSociales;
    this.etqUsuario = etqUsuario;
    this.fondo1 = fondo1;
    this.fondo2 = fondo2;
    this.fotoPerfil = fotoPerfil;
    this.subRelative1 = subRelative1;
    this.subRelative2 = subRelative2;
    this.txtConfirmarContrasenia = txtConfirmarContrasenia;
    this.txtContrasenia = txtContrasenia;
    this.txtCorreo = txtCorreo;
    this.txtUsuario = txtUsuario;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCrearCuenta2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCrearCuenta2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_crear_cuenta_2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCrearCuenta2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCambiarFotoPerfil;
      FloatingActionButton btnCambiarFotoPerfil = ViewBindings.findChildViewById(rootView, id);
      if (btnCambiarFotoPerfil == null) {
        break missingId;
      }

      id = R.id.btnContinuar;
      FloatingActionButton btnContinuar = ViewBindings.findChildViewById(rootView, id);
      if (btnContinuar == null) {
        break missingId;
      }

      id = R.id.btnFacebook;
      ImageButton btnFacebook = ViewBindings.findChildViewById(rootView, id);
      if (btnFacebook == null) {
        break missingId;
      }

      id = R.id.btnGoogle;
      ImageButton btnGoogle = ViewBindings.findChildViewById(rootView, id);
      if (btnGoogle == null) {
        break missingId;
      }

      id = R.id.btnTwitter;
      ImageButton btnTwitter = ViewBindings.findChildViewById(rootView, id);
      if (btnTwitter == null) {
        break missingId;
      }

      id = R.id.etqConfirmarContrasenia;
      TextInputLayout etqConfirmarContrasenia = ViewBindings.findChildViewById(rootView, id);
      if (etqConfirmarContrasenia == null) {
        break missingId;
      }

      id = R.id.etqContrasenia;
      TextInputLayout etqContrasenia = ViewBindings.findChildViewById(rootView, id);
      if (etqContrasenia == null) {
        break missingId;
      }

      id = R.id.etqCorreo;
      TextInputLayout etqCorreo = ViewBindings.findChildViewById(rootView, id);
      if (etqCorreo == null) {
        break missingId;
      }

      id = R.id.etqRedesSociales;
      TextView etqRedesSociales = ViewBindings.findChildViewById(rootView, id);
      if (etqRedesSociales == null) {
        break missingId;
      }

      id = R.id.etqUsuario;
      TextInputLayout etqUsuario = ViewBindings.findChildViewById(rootView, id);
      if (etqUsuario == null) {
        break missingId;
      }

      id = R.id.fondo1;
      CardView fondo1 = ViewBindings.findChildViewById(rootView, id);
      if (fondo1 == null) {
        break missingId;
      }

      id = R.id.fondo2;
      CardView fondo2 = ViewBindings.findChildViewById(rootView, id);
      if (fondo2 == null) {
        break missingId;
      }

      id = R.id.fotoPerfil;
      CircleImageView fotoPerfil = ViewBindings.findChildViewById(rootView, id);
      if (fotoPerfil == null) {
        break missingId;
      }

      id = R.id.subRelative1;
      RelativeLayout subRelative1 = ViewBindings.findChildViewById(rootView, id);
      if (subRelative1 == null) {
        break missingId;
      }

      id = R.id.subRelative2;
      RelativeLayout subRelative2 = ViewBindings.findChildViewById(rootView, id);
      if (subRelative2 == null) {
        break missingId;
      }

      id = R.id.txtConfirmarContrasenia;
      TextInputEditText txtConfirmarContrasenia = ViewBindings.findChildViewById(rootView, id);
      if (txtConfirmarContrasenia == null) {
        break missingId;
      }

      id = R.id.txtContrasenia;
      TextInputEditText txtContrasenia = ViewBindings.findChildViewById(rootView, id);
      if (txtContrasenia == null) {
        break missingId;
      }

      id = R.id.txtCorreo;
      TextInputEditText txtCorreo = ViewBindings.findChildViewById(rootView, id);
      if (txtCorreo == null) {
        break missingId;
      }

      id = R.id.txtUsuario;
      TextInputEditText txtUsuario = ViewBindings.findChildViewById(rootView, id);
      if (txtUsuario == null) {
        break missingId;
      }

      return new FragmentCrearCuenta2Binding((RelativeLayout) rootView, btnCambiarFotoPerfil,
          btnContinuar, btnFacebook, btnGoogle, btnTwitter, etqConfirmarContrasenia, etqContrasenia,
          etqCorreo, etqRedesSociales, etqUsuario, fondo1, fondo2, fotoPerfil, subRelative1,
          subRelative2, txtConfirmarContrasenia, txtContrasenia, txtCorreo, txtUsuario);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
