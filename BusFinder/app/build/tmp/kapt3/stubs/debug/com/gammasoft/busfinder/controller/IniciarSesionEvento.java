package com.gammasoft.busfinder.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\b\u0010\'\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/gammasoft/busfinder/controller/IniciarSesionEvento;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "binding", "Lcom/gammasoft/busfinder/databinding/ActivityIniciarSesionBinding;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/gammasoft/busfinder/databinding/ActivityIniciarSesionBinding;)V", "callbackManager", "Lcom/facebook/CallbackManager;", "cloudDB", "Lcom/gammasoft/busfinder/model/dbNube/CloudDataBase$Companion;", "googleActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "iniciar", "", "iniciarByGoogle", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "iniciarPantallaPrincipalByCorreo", "cuenta", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;", "contrasenia", "", "iniciarPantallaPrincipalByRS", "correo", "iniciarSesionCorreoFirebase", "obtenerCuentaCorreo", "obtenerCuentaCorreo2", "onClick", "v", "Landroid/view/View;", "verificarCorreoCloud", "verificarFacebook", "verificarGoogle", "verificarTwitter", "app_debug"})
public final class IniciarSesionEvento implements android.view.View.OnClickListener {
    private final androidx.appcompat.app.AppCompatActivity activity = null;
    private final com.gammasoft.busfinder.databinding.ActivityIniciarSesionBinding binding = null;
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    private final com.gammasoft.busfinder.model.dbNube.CloudDataBase.Companion cloudDB = null;
    private final com.facebook.CallbackManager callbackManager = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleActivity = null;
    
    public IniciarSesionEvento(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.ActivityIniciarSesionBinding binding) {
        super();
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void verificarGoogle() {
    }
    
    private final void iniciarPantallaPrincipalByRS(java.lang.String correo) {
    }
    
    private final void obtenerCuentaCorreo(java.lang.String correo) {
    }
    
    private final void iniciarByGoogle(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> task) {
    }
    
    private final void verificarFacebook() {
    }
    
    private final void verificarTwitter() {
    }
    
    private final void obtenerCuentaCorreo2(java.lang.String correo, java.lang.String contrasenia) {
    }
    
    private final void iniciarSesionCorreoFirebase(java.lang.String correo, java.lang.String contrasenia) {
    }
    
    private final void verificarCorreoCloud(java.lang.String correo, java.lang.String contrasenia) {
    }
    
    private final void iniciarPantallaPrincipalByCorreo(com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta cuenta, java.lang.String contrasenia) {
    }
    
    private final void iniciar() {
    }
}