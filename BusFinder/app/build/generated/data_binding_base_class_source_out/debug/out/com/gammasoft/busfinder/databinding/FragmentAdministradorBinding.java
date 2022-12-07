// Generated by view binder compiler. Do not edit!
package com.gammasoft.busfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.gammasoft.busfinder.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAdministradorBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionsMenu btnAgregar;

  @NonNull
  public final FloatingActionButton btnAgregarChofer;

  @NonNull
  public final FloatingActionButton btnAgregarParada;

  @NonNull
  public final FloatingActionButton btnAgregarReporte;

  @NonNull
  public final FloatingActionButton btnAgregarRuta;

  @NonNull
  public final FloatingActionButton btnAgregarTarifa;

  @NonNull
  public final FloatingActionButton btnAgregarUnidad;

  @NonNull
  public final FrameLayout contenedor;

  @NonNull
  public final RecyclerView recyclerView;

  private FragmentAdministradorBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionsMenu btnAgregar, @NonNull FloatingActionButton btnAgregarChofer,
      @NonNull FloatingActionButton btnAgregarParada,
      @NonNull FloatingActionButton btnAgregarReporte, @NonNull FloatingActionButton btnAgregarRuta,
      @NonNull FloatingActionButton btnAgregarTarifa,
      @NonNull FloatingActionButton btnAgregarUnidad, @NonNull FrameLayout contenedor,
      @NonNull RecyclerView recyclerView) {
    this.rootView = rootView;
    this.btnAgregar = btnAgregar;
    this.btnAgregarChofer = btnAgregarChofer;
    this.btnAgregarParada = btnAgregarParada;
    this.btnAgregarReporte = btnAgregarReporte;
    this.btnAgregarRuta = btnAgregarRuta;
    this.btnAgregarTarifa = btnAgregarTarifa;
    this.btnAgregarUnidad = btnAgregarUnidad;
    this.contenedor = contenedor;
    this.recyclerView = recyclerView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdministradorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdministradorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_administrador, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdministradorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAgregar;
      FloatingActionsMenu btnAgregar = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregar == null) {
        break missingId;
      }

      id = R.id.btnAgregarChofer;
      FloatingActionButton btnAgregarChofer = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregarChofer == null) {
        break missingId;
      }

      id = R.id.btnAgregarParada;
      FloatingActionButton btnAgregarParada = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregarParada == null) {
        break missingId;
      }

      id = R.id.btnAgregarReporte;
      FloatingActionButton btnAgregarReporte = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregarReporte == null) {
        break missingId;
      }

      id = R.id.btnAgregarRuta;
      FloatingActionButton btnAgregarRuta = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregarRuta == null) {
        break missingId;
      }

      id = R.id.btnAgregarTarifa;
      FloatingActionButton btnAgregarTarifa = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregarTarifa == null) {
        break missingId;
      }

      id = R.id.btnAgregarUnidad;
      FloatingActionButton btnAgregarUnidad = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregarUnidad == null) {
        break missingId;
      }

      id = R.id.contenedor;
      FrameLayout contenedor = ViewBindings.findChildViewById(rootView, id);
      if (contenedor == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      return new FragmentAdministradorBinding((RelativeLayout) rootView, btnAgregar,
          btnAgregarChofer, btnAgregarParada, btnAgregarReporte, btnAgregarRuta, btnAgregarTarifa,
          btnAgregarUnidad, contenedor, recyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
