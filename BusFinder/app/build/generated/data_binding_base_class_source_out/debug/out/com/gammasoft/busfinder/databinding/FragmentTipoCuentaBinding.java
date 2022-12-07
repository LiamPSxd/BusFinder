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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTipoCuentaBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView etqAdmin;

  @NonNull
  public final TextView etqChofer;

  @NonNull
  public final TextView etqCrearCuenta;

  @NonNull
  public final TextView etqPublico;

  @NonNull
  public final CardView trjAdmin;

  @NonNull
  public final CardView trjChofer;

  @NonNull
  public final CardView trjPublico;

  private FragmentTipoCuentaBinding(@NonNull RelativeLayout rootView, @NonNull TextView etqAdmin,
      @NonNull TextView etqChofer, @NonNull TextView etqCrearCuenta, @NonNull TextView etqPublico,
      @NonNull CardView trjAdmin, @NonNull CardView trjChofer, @NonNull CardView trjPublico) {
    this.rootView = rootView;
    this.etqAdmin = etqAdmin;
    this.etqChofer = etqChofer;
    this.etqCrearCuenta = etqCrearCuenta;
    this.etqPublico = etqPublico;
    this.trjAdmin = trjAdmin;
    this.trjChofer = trjChofer;
    this.trjPublico = trjPublico;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTipoCuentaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTipoCuentaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_tipo_cuenta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTipoCuentaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etqAdmin;
      TextView etqAdmin = ViewBindings.findChildViewById(rootView, id);
      if (etqAdmin == null) {
        break missingId;
      }

      id = R.id.etqChofer;
      TextView etqChofer = ViewBindings.findChildViewById(rootView, id);
      if (etqChofer == null) {
        break missingId;
      }

      id = R.id.etqCrearCuenta;
      TextView etqCrearCuenta = ViewBindings.findChildViewById(rootView, id);
      if (etqCrearCuenta == null) {
        break missingId;
      }

      id = R.id.etqPublico;
      TextView etqPublico = ViewBindings.findChildViewById(rootView, id);
      if (etqPublico == null) {
        break missingId;
      }

      id = R.id.trjAdmin;
      CardView trjAdmin = ViewBindings.findChildViewById(rootView, id);
      if (trjAdmin == null) {
        break missingId;
      }

      id = R.id.trjChofer;
      CardView trjChofer = ViewBindings.findChildViewById(rootView, id);
      if (trjChofer == null) {
        break missingId;
      }

      id = R.id.trjPublico;
      CardView trjPublico = ViewBindings.findChildViewById(rootView, id);
      if (trjPublico == null) {
        break missingId;
      }

      return new FragmentTipoCuentaBinding((RelativeLayout) rootView, etqAdmin, etqChofer,
          etqCrearCuenta, etqPublico, trjAdmin, trjChofer, trjPublico);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
