// Generated by view binder compiler. Do not edit!
package com.gammasoft.busfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.gammasoft.busfinder.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPerfilPublicoBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton btnCambiarFotoPerfil;

  @NonNull
  public final FloatingActionButton btnCerrarSesion;

  @NonNull
  public final TextView etqCorreo;

  @NonNull
  public final TextView etqUsuario;

  @NonNull
  public final CardView fondo1;

  @NonNull
  public final CircleImageView fotoPerfil;

  @NonNull
  public final RelativeLayout subRelative1;

  @NonNull
  public final RelativeLayout subRelative2;

  @NonNull
  public final TextView txtCorreo;

  @NonNull
  public final TextView txtUsuario;

  private FragmentPerfilPublicoBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton btnCambiarFotoPerfil,
      @NonNull FloatingActionButton btnCerrarSesion, @NonNull TextView etqCorreo,
      @NonNull TextView etqUsuario, @NonNull CardView fondo1, @NonNull CircleImageView fotoPerfil,
      @NonNull RelativeLayout subRelative1, @NonNull RelativeLayout subRelative2,
      @NonNull TextView txtCorreo, @NonNull TextView txtUsuario) {
    this.rootView = rootView;
    this.btnCambiarFotoPerfil = btnCambiarFotoPerfil;
    this.btnCerrarSesion = btnCerrarSesion;
    this.etqCorreo = etqCorreo;
    this.etqUsuario = etqUsuario;
    this.fondo1 = fondo1;
    this.fotoPerfil = fotoPerfil;
    this.subRelative1 = subRelative1;
    this.subRelative2 = subRelative2;
    this.txtCorreo = txtCorreo;
    this.txtUsuario = txtUsuario;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPerfilPublicoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPerfilPublicoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_perfil_publico, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPerfilPublicoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCambiarFotoPerfil;
      FloatingActionButton btnCambiarFotoPerfil = ViewBindings.findChildViewById(rootView, id);
      if (btnCambiarFotoPerfil == null) {
        break missingId;
      }

      id = R.id.btnCerrarSesion;
      FloatingActionButton btnCerrarSesion = ViewBindings.findChildViewById(rootView, id);
      if (btnCerrarSesion == null) {
        break missingId;
      }

      id = R.id.etqCorreo;
      TextView etqCorreo = ViewBindings.findChildViewById(rootView, id);
      if (etqCorreo == null) {
        break missingId;
      }

      id = R.id.etqUsuario;
      TextView etqUsuario = ViewBindings.findChildViewById(rootView, id);
      if (etqUsuario == null) {
        break missingId;
      }

      id = R.id.fondo1;
      CardView fondo1 = ViewBindings.findChildViewById(rootView, id);
      if (fondo1 == null) {
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

      id = R.id.txtCorreo;
      TextView txtCorreo = ViewBindings.findChildViewById(rootView, id);
      if (txtCorreo == null) {
        break missingId;
      }

      id = R.id.txtUsuario;
      TextView txtUsuario = ViewBindings.findChildViewById(rootView, id);
      if (txtUsuario == null) {
        break missingId;
      }

      return new FragmentPerfilPublicoBinding((RelativeLayout) rootView, btnCambiarFotoPerfil,
          btnCerrarSesion, etqCorreo, etqUsuario, fondo1, fotoPerfil, subRelative1, subRelative2,
          txtCorreo, txtUsuario);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
