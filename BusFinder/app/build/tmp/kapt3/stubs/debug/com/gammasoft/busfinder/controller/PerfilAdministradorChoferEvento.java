package com.gammasoft.busfinder.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/gammasoft/busfinder/controller/PerfilAdministradorChoferEvento;", "Landroid/view/View$OnClickListener;", "fragment", "Landroidx/fragment/app/Fragment;", "binding", "Lcom/gammasoft/busfinder/databinding/FragmentPerfilAdminChoferBinding;", "cuenta", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;", "pickmedia", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/PickVisualMediaRequest;", "(Landroidx/fragment/app/Fragment;Lcom/gammasoft/busfinder/databinding/FragmentPerfilAdminChoferBinding;Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;Landroidx/activity/result/ActivityResultLauncher;)V", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "cambiarFotoPerfil", "", "cerrarSesion", "onClick", "v", "Landroid/view/View;", "app_debug"})
public final class PerfilAdministradorChoferEvento implements android.view.View.OnClickListener {
    private final androidx.fragment.app.Fragment fragment = null;
    private final com.gammasoft.busfinder.databinding.FragmentPerfilAdminChoferBinding binding = null;
    private final com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta cuenta = null;
    private final androidx.activity.result.ActivityResultLauncher<androidx.activity.result.PickVisualMediaRequest> pickmedia = null;
    private com.gammasoft.busfinder.model.dbLocal.Crud localDB;
    
    public PerfilAdministradorChoferEvento(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentPerfilAdminChoferBinding binding, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta cuenta, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<androidx.activity.result.PickVisualMediaRequest> pickmedia) {
        super();
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void cambiarFotoPerfil() {
    }
    
    private final void cerrarSesion() {
    }
}