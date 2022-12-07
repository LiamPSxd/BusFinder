package com.gammasoft.busfinder.view.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/gammasoft/busfinder/view/activity/PrincipalPublico;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "binding", "Lcom/gammasoft/busfinder/databinding/ActivityPublicoBinding;", "cloudDB", "Lcom/google/firebase/firestore/FirebaseFirestore;", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "navController", "Landroidx/navigation/NavController;", "prefs", "Landroid/content/SharedPreferences;", "publico", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;", "migrarDatos", "", "correo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class PrincipalPublico extends androidx.appcompat.app.AppCompatActivity {
    private com.gammasoft.busfinder.databinding.ActivityPublicoBinding binding;
    private androidx.navigation.NavController navController;
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    private final com.google.firebase.firestore.FirebaseFirestore cloudDB = null;
    private android.content.SharedPreferences prefs;
    private com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta publico;
    
    public PrincipalPublico() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void migrarDatos(java.lang.String correo) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}