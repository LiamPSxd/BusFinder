package com.gammasoft.busfinder.model.mapa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/gammasoft/busfinder/model/mapa/ApiService;", "", "getRuta", "Lretrofit2/Response;", "Lcom/gammasoft/busfinder/model/mapa/RutaResponse;", "key", "", "start", "end", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTiempo", "Lcom/gammasoft/busfinder/model/mapa/RutaTiempo;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/v2/directions/driving-car")
    public abstract java.lang.Object getRuta(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "start", encoded = true)
    java.lang.String start, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "end", encoded = true)
    java.lang.String end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.gammasoft.busfinder.model.mapa.RutaResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/v2/directions/driving-car")
    public abstract java.lang.Object getTiempo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "start", encoded = true)
    java.lang.String start, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "end", encoded = true)
    java.lang.String end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.gammasoft.busfinder.model.mapa.RutaTiempo>> continuation);
}