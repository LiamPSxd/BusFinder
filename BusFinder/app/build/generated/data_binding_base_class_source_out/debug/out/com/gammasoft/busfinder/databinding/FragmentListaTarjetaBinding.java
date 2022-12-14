// Generated by view binder compiler. Do not edit!
package com.gammasoft.busfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.gammasoft.busfinder.R;
import io.alterac.blurkit.BlurLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentListaTarjetaBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final BlurLayout blurLayout;

  @NonNull
  public final TextView cabecera;

  @NonNull
  public final View dragArea;

  @NonNull
  public final ImageView dragHandleImage;

  @NonNull
  public final CardView lista;

  @NonNull
  public final RecyclerView recyclerView;

  private FragmentListaTarjetaBinding(@NonNull RelativeLayout rootView,
      @NonNull BlurLayout blurLayout, @NonNull TextView cabecera, @NonNull View dragArea,
      @NonNull ImageView dragHandleImage, @NonNull CardView lista,
      @NonNull RecyclerView recyclerView) {
    this.rootView = rootView;
    this.blurLayout = blurLayout;
    this.cabecera = cabecera;
    this.dragArea = dragArea;
    this.dragHandleImage = dragHandleImage;
    this.lista = lista;
    this.recyclerView = recyclerView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentListaTarjetaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentListaTarjetaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_lista_tarjeta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentListaTarjetaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.blurLayout;
      BlurLayout blurLayout = ViewBindings.findChildViewById(rootView, id);
      if (blurLayout == null) {
        break missingId;
      }

      id = R.id.cabecera;
      TextView cabecera = ViewBindings.findChildViewById(rootView, id);
      if (cabecera == null) {
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

      id = R.id.lista;
      CardView lista = ViewBindings.findChildViewById(rootView, id);
      if (lista == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      return new FragmentListaTarjetaBinding((RelativeLayout) rootView, blurLayout, cabecera,
          dragArea, dragHandleImage, lista, recyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
