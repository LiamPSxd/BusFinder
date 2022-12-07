package com.gammasoft.busfinder.view.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/gammasoft/busfinder/view/adapter/QuejaSugerenciaAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gammasoft/busfinder/view/adapter/QuejaSugerenciaAdapter$ViewHolder;", "fragment", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "quSu", "", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/QuejaSugerencia;", "(Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;Ljava/util/List;)V", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "getItemCount", "", "onBindViewHolder", "", "holder", "i", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class QuejaSugerenciaAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.gammasoft.busfinder.view.adapter.QuejaSugerenciaAdapter.ViewHolder> {
    private final com.gammasoft.busfinder.view.fragment.TarjetaBase fragment = null;
    private final java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia> quSu = null;
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    
    public QuejaSugerenciaAdapter(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.fragment.TarjetaBase fragment, @org.jetbrains.annotations.NotNull()
    java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia> quSu) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.gammasoft.busfinder.view.adapter.QuejaSugerenciaAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.adapter.QuejaSugerenciaAdapter.ViewHolder holder, int i) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/gammasoft/busfinder/view/adapter/QuejaSugerenciaAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/gammasoft/busfinder/view/util/DebouncingClickListener;", "Lcom/gammasoft/busfinder/controller/longpress/PopupInflaterEvento;", "Lcom/gammasoft/busfinder/controller/longpress/PopupStateEvento;", "Lcom/gammasoft/busfinder/controller/longpress/PopupHoverEvento;", "binding", "Lcom/gammasoft/busfinder/databinding/TarjetaQuejaSugerenciaBinding;", "(Lcom/gammasoft/busfinder/view/adapter/QuejaSugerenciaAdapter;Lcom/gammasoft/busfinder/databinding/TarjetaQuejaSugerenciaBinding;)V", "bind", "", "usuario", "", "descripcion", "onDebouncingClick", "view", "Landroid/view/View;", "onHoverChanged", "isHovered", "", "onPopupDismiss", "popupTag", "onPopupShow", "onViewInflated", "tag", "rootView", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.gammasoft.busfinder.view.util.DebouncingClickListener, com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento, com.gammasoft.busfinder.controller.longpress.PopupStateEvento, com.gammasoft.busfinder.controller.longpress.PopupHoverEvento {
        private final com.gammasoft.busfinder.databinding.TarjetaQuejaSugerenciaBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.databinding.TarjetaQuejaSugerenciaBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        java.lang.String usuario, @org.jetbrains.annotations.NotNull()
        java.lang.String descripcion) {
        }
        
        @java.lang.Override()
        public void onDebouncingClick(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
        }
        
        @java.lang.Override()
        public void onViewInflated(@org.jetbrains.annotations.Nullable()
        java.lang.String tag, @org.jetbrains.annotations.Nullable()
        android.view.View rootView) {
        }
        
        @java.lang.Override()
        public void onPopupShow(@org.jetbrains.annotations.Nullable()
        java.lang.String popupTag) {
        }
        
        @java.lang.Override()
        public void onPopupDismiss(@org.jetbrains.annotations.Nullable()
        java.lang.String popupTag) {
        }
        
        @java.lang.Override()
        public void onHoverChanged(@org.jetbrains.annotations.NotNull()
        android.view.View view, boolean isHovered) {
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
    }
}