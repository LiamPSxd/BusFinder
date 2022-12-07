package com.gammasoft.busfinder.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002JX\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001cH\u0002J\u0016\u0010&\u001a\u00020\u00162\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0012\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00140\u00140\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/gammasoft/busfinder/controller/CrearCuenta2Evento;", "Landroid/view/View$OnClickListener;", "fragment", "Landroidx/fragment/app/Fragment;", "binding", "Lcom/gammasoft/busfinder/databinding/FragmentCrearCuenta2Binding;", "(Landroidx/fragment/app/Fragment;Lcom/gammasoft/busfinder/databinding/FragmentCrearCuenta2Binding;)V", "callbackManager", "Lcom/facebook/CallbackManager;", "cloudDB", "Lcom/gammasoft/busfinder/model/dbNube/CloudDataBase$Companion;", "codigo", "", "googleActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "pickMedia", "Landroidx/activity/result/PickVisualMediaRequest;", "autenticarFacebook", "", "autenticarGoogle", "autenticarTwitter", "cambiarFotoPerfil", "finalizar", "tipo", "", "usuario", "rfc", "nombre", "celular", "linea", "correo", "contrasenia", "foto", "metodo", "iniciarByGoogle", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "onClick", "v", "Landroid/view/View;", "registrar", "verificarCorreo", "", "verificarUsuarioCorreoRegistrado", "app_debug"})
public final class CrearCuenta2Evento implements android.view.View.OnClickListener {
    private final androidx.fragment.app.Fragment fragment = null;
    private final com.gammasoft.busfinder.databinding.FragmentCrearCuenta2Binding binding = null;
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    private final com.gammasoft.busfinder.model.dbNube.CloudDataBase.Companion cloudDB = null;
    private final com.facebook.CallbackManager callbackManager = null;
    private long codigo = 0L;
    private final androidx.activity.result.ActivityResultLauncher<androidx.activity.result.PickVisualMediaRequest> pickMedia = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleActivity = null;
    
    public CrearCuenta2Evento(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentCrearCuenta2Binding binding) {
        super();
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void cambiarFotoPerfil() {
    }
    
    private final void autenticarGoogle() {
    }
    
    private final void iniciarByGoogle(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> task) {
    }
    
    private final void autenticarFacebook() {
    }
    
    private final void autenticarTwitter() {
    }
    
    private final boolean verificarUsuarioCorreoRegistrado(java.lang.String usuario) {
        return false;
    }
    
    private final boolean verificarCorreo(java.lang.String correo) {
        return false;
    }
    
    private final void finalizar(java.lang.String tipo, java.lang.String usuario, java.lang.String rfc, java.lang.String nombre, long celular, java.lang.String linea, java.lang.String correo, java.lang.String contrasenia, java.lang.String foto, java.lang.String metodo) {
    }
    
    private final void registrar() {
    }
}