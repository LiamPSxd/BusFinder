package com.gammasoft.busfinder.model.dbLocal;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\bJ\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\'\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\u00032\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0005\"\u00020\nH\'\u00a2\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0005\"\u00020\u000eH\'\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00032\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0005\"\u00020\u0012H\'\u00a2\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0005\"\u00020\u0016H\'\u00a2\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0005\"\u00020\u001aH\'\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u0005\"\u00020\u001eH\'\u00a2\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00032\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0\u0005\"\u00020\"H\'\u00a2\u0006\u0002\u0010#J!\u0010$\u001a\u00020\u00032\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0\u0005\"\u00020&H\'\u00a2\u0006\u0002\u0010\'J!\u0010(\u001a\u00020\u00032\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0\u0005\"\u00020*H\'\u00a2\u0006\u0002\u0010+J!\u0010,\u001a\u00020\u00032\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0\u0005\"\u00020.H\'\u00a2\u0006\u0002\u0010/J!\u00100\u001a\u00020\u00032\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002020\u0005\"\u000202H\'\u00a2\u0006\u0002\u00103J!\u00104\u001a\u00020\u00032\u0012\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u0002060\u0005\"\u000206H\'\u00a2\u0006\u0002\u00107J!\u00108\u001a\u00020\u00032\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020:0\u0005\"\u00020:H\'\u00a2\u0006\u0002\u0010;J!\u0010<\u001a\u00020\u00032\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0\u0005\"\u00020>H\'\u00a2\u0006\u0002\u0010?J!\u0010@\u001a\u00020\u00032\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0\u0005\"\u00020BH\'\u00a2\u0006\u0002\u0010CJ!\u0010D\u001a\u00020\u00032\u0012\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0\u0005\"\u00020FH\'\u00a2\u0006\u0002\u0010GJ!\u0010H\u001a\u00020\u00032\u0012\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020J0\u0005\"\u00020JH\'\u00a2\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0006H\'J\b\u0010N\u001a\u00020\u0003H\'J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020QH\'J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nH\'J\b\u0010T\u001a\u00020\u0003H\'J\u0010\u0010U\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u000eH\'J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020YH\'J\b\u0010Z\u001a\u00020\u0003H\'J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0012H\'J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0016H\'J\u0010\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u001aH\'J\u0010\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u001eH\'J\b\u0010c\u001a\u00020\u0003H\'J\b\u0010d\u001a\u00020\u0003H\'J\b\u0010e\u001a\u00020\u0003H\'J\b\u0010f\u001a\u00020\u0003H\'J\u0010\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020\"H\'J\u0010\u0010i\u001a\u00020\u00032\u0006\u0010j\u001a\u00020&H\'J\b\u0010k\u001a\u00020\u0003H\'J\b\u0010l\u001a\u00020\u0003H\'J\u0010\u0010m\u001a\u00020\u00032\u0006\u0010n\u001a\u00020*H\'J\b\u0010o\u001a\u00020\u0003H\'J\u0010\u0010p\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H\'J\b\u0010q\u001a\u00020\u0003H\'J\u0010\u0010r\u001a\u00020\u00032\u0006\u0010s\u001a\u00020:H\'J\u0010\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u000202H\'J\u0010\u0010v\u001a\u00020\u00032\u0006\u0010w\u001a\u000206H\'J\b\u0010x\u001a\u00020\u0003H\'J\b\u0010y\u001a\u00020\u0003H\'J\b\u0010z\u001a\u00020\u0003H\'J\u0010\u0010{\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H\'J\u0010\u0010{\u001a\u00020\u00032\u0006\u0010X\u001a\u00020YH\'J\b\u0010|\u001a\u00020\u0003H\'J\u0010\u0010}\u001a\u00020\u00032\u0006\u0010~\u001a\u00020BH\'J\b\u0010\u007f\u001a\u00020\u0003H\'J\u0012\u0010\u0080\u0001\u001a\u00020\u00032\u0007\u0010\u0081\u0001\u001a\u00020JH\'J\u0012\u0010\u0082\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020FH\'J\t\u0010\u0084\u0001\u001a\u00020\u0003H\'J\t\u0010\u0085\u0001\u001a\u00020\u0003H\'J\u0018\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0087\u00012\u0006\u0010P\u001a\u00020QH\'J\u0019\u0010\u0088\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020QH\'J\u0017\u0010\u008a\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00060\u008b\u00010\u0087\u0001H\'J\u0019\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u0087\u00012\u0007\u0010\u008d\u0001\u001a\u00020QH\'J\u0018\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u0087\u00012\u0006\u0010P\u001a\u00020QH\'J \u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u0087\u00012\u0006\u0010P\u001a\u00020Q2\u0006\u0010M\u001a\u00020QH\'J\u0019\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020QH\'J\u0017\u0010\u0091\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\n0\u008b\u00010\u0087\u0001H\'J\u001f\u0010\u0092\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\n0\u008b\u00010\u0087\u00012\u0006\u0010M\u001a\u00020QH\'J\u0018\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0087\u00012\u0006\u0010X\u001a\u00020YH\'J\u0017\u0010\u0094\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u000e0\u008b\u00010\u0087\u0001H\'J\u001f\u0010\u0095\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u000e0\u008b\u00010\u0087\u00012\u0006\u0010M\u001a\u00020QH\'J \u0010\u0096\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002020\u008b\u00010\u0087\u00012\u0007\u0010\u0097\u0001\u001a\u00020YH\'J\u0019\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u0087\u00012\u0007\u0010\u0099\u0001\u001a\u00020QH\'J\u0019\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020QH\'J\u0019\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0087\u00012\u0007\u0010\u009c\u0001\u001a\u00020QH\'J\u0019\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0087\u00012\u0007\u0010\u009c\u0001\u001a\u00020QH\'J\u0019\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0087\u00012\u0007\u0010\u0099\u0001\u001a\u00020QH\'J\u0019\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0087\u00012\u0007\u0010\u009c\u0001\u001a\u00020QH\'J\u0019\u0010\u00a0\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0087\u00012\u0007\u0010\u0099\u0001\u001a\u00020QH\'J\u0019\u0010\u00a1\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020QH\'J\u0019\u0010\u00a2\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u0087\u00012\u0007\u0010\u0099\u0001\u001a\u00020QH\'J\u0019\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020QH\'J\u0017\u0010\u00a4\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00120\u008b\u00010\u0087\u0001H\'J\u0017\u0010\u00a5\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00160\u008b\u00010\u0087\u0001H\'J\u0017\u0010\u00a6\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u001a0\u008b\u00010\u0087\u0001H\'J\u0017\u0010\u00a7\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u001e0\u008b\u00010\u0087\u0001H\'J\u0018\u0010\u00a8\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u0087\u00012\u0006\u0010X\u001a\u00020YH\'J\u0017\u0010\u00a9\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020&0\u008b\u00010\u0087\u0001H\'J\u0017\u0010\u00aa\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\"0\u008b\u00010\u0087\u0001H\'J\u0018\u0010\u00ab\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0087\u00012\u0006\u0010X\u001a\u00020YH\'J\u0019\u0010\u00ac\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0087\u00012\u0007\u0010\u008d\u0001\u001a\u00020QH\'J\u0017\u0010\u00ad\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020*0\u008b\u00010\u0087\u0001H\'J\u001f\u0010\u00ae\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020*0\u008b\u00010\u0087\u00012\u0006\u0010M\u001a\u00020QH\'J\u0019\u0010\u00af\u0001\u001a\t\u0012\u0004\u0012\u00020.0\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020QH\'J\u0017\u0010\u00b0\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020.0\u008b\u00010\u0087\u0001H\'J\u0018\u0010\u00b1\u0001\u001a\t\u0012\u0004\u0012\u00020:0\u0087\u00012\u0006\u0010X\u001a\u00020YH\'J\u0019\u0010\u00b2\u0001\u001a\t\u0012\u0004\u0012\u00020:0\u0087\u00012\u0007\u0010\u008d\u0001\u001a\u00020QH\'J\u0019\u0010\u00b3\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0087\u00012\u0007\u0010\u0097\u0001\u001a\u00020YH\'J\u0017\u0010\u00b4\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002020\u008b\u00010\u0087\u0001H\'J\u0019\u0010\u00b5\u0001\u001a\t\u0012\u0004\u0012\u0002060\u0087\u00012\u0007\u0010\u00b6\u0001\u001a\u00020YH\'J\u0017\u0010\u00b7\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002060\u008b\u00010\u0087\u0001H\'J\u0017\u0010\u00b8\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020:0\u008b\u00010\u0087\u0001H\'J\u001f\u0010\u00b9\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020:0\u008b\u00010\u0087\u00012\u0006\u0010M\u001a\u00020QH\'J\u0017\u0010\u00ba\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020>0\u008b\u00010\u0087\u0001H\'J\u0018\u0010\u00bb\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0087\u00012\u0006\u0010X\u001a\u00020YH\'J\u0019\u0010\u00bc\u0001\u001a\t\u0012\u0004\u0012\u00020B0\u0087\u00012\u0007\u0010\u008d\u0001\u001a\u00020QH\'J\u0017\u0010\u00bd\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020B0\u008b\u00010\u0087\u0001H\'J\u001f\u0010\u00be\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020B0\u008b\u00010\u0087\u00012\u0006\u0010M\u001a\u00020QH\'J\u0019\u0010\u00bf\u0001\u001a\t\u0012\u0004\u0012\u00020J0\u0087\u00012\u0007\u0010\u00c0\u0001\u001a\u00020QH\'J\u0017\u0010\u00c1\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020J0\u008b\u00010\u0087\u0001H\'J\u0017\u0010\u00c2\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020F0\u008b\u00010\u0087\u0001H\'J\"\u0010\u00c3\u0001\u001a\u00020\u00032\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\'\u00a2\u0006\u0002\u0010\u0007J\"\u0010\u00c4\u0001\u001a\u00020\u00032\u0012\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0005\"\u00020\nH\'\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\u00c5\u0001\u001a\u00020\u00032\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0005\"\u00020\u000eH\'\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u00c6\u0001\u001a\u00020\u00032\u0012\u0010\\\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0005\"\u00020\u0012H\'\u00a2\u0006\u0002\u0010\u0013J\"\u0010\u00c7\u0001\u001a\u00020\u00032\u0012\u0010^\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0005\"\u00020\u0016H\'\u00a2\u0006\u0002\u0010\u0017J\"\u0010\u00c8\u0001\u001a\u00020\u00032\u0012\u0010`\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0005\"\u00020\u001aH\'\u00a2\u0006\u0002\u0010\u001bJ\"\u0010\u00c9\u0001\u001a\u00020\u00032\u0012\u0010b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u0005\"\u00020\u001eH\'\u00a2\u0006\u0002\u0010\u001fJ\"\u0010\u00ca\u0001\u001a\u00020\u00032\u0012\u0010h\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0\u0005\"\u00020\"H\'\u00a2\u0006\u0002\u0010#J\"\u0010\u00cb\u0001\u001a\u00020\u00032\u0012\u0010j\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0\u0005\"\u00020&H\'\u00a2\u0006\u0002\u0010\'J\"\u0010\u00cc\u0001\u001a\u00020\u00032\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0\u0005\"\u00020*H\'\u00a2\u0006\u0002\u0010+J\"\u0010\u00cd\u0001\u001a\u00020\u00032\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0\u0005\"\u00020.H\'\u00a2\u0006\u0002\u0010/J\"\u0010\u00ce\u0001\u001a\u00020\u00032\u0012\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u00020:0\u0005\"\u00020:H\'\u00a2\u0006\u0002\u0010;J\"\u0010\u00cf\u0001\u001a\u00020\u00032\u0012\u0010u\u001a\n\u0012\u0006\b\u0001\u0012\u0002020\u0005\"\u000202H\'\u00a2\u0006\u0002\u00103J\"\u0010\u00d0\u0001\u001a\u00020\u00032\u0012\u0010w\u001a\n\u0012\u0006\b\u0001\u0012\u0002060\u0005\"\u000206H\'\u00a2\u0006\u0002\u00107J\"\u0010\u00d1\u0001\u001a\u00020\u00032\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0\u0005\"\u00020>H\'\u00a2\u0006\u0002\u0010?J\"\u0010\u00d2\u0001\u001a\u00020\u00032\u0012\u0010~\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0\u0005\"\u00020BH\'\u00a2\u0006\u0002\u0010CJ#\u0010\u00d3\u0001\u001a\u00020\u00032\u0013\u0010\u0081\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020J0\u0005\"\u00020JH\'\u00a2\u0006\u0002\u0010KJ#\u0010\u00d4\u0001\u001a\u00020\u00032\u0013\u0010\u0083\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0\u0005\"\u00020FH\'\u00a2\u0006\u0002\u0010G\u00a8\u0006\u00d5\u0001"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "", "addAdministradores", "", "administradores", "", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Administrador;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Administrador;)V", "addChoferes", "choferes", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Chofer;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Chofer;)V", "addCoordenadas", "coordenadas", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Coordenada;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Coordenada;)V", "addCuentas", "cuentas", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;)V", "addCuentasAdministrador", "cuentasAdministrador", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaAdministrador;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaAdministrador;)V", "addCuentasChofer", "cuentasChofer", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaChofer;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaChofer;)V", "addCuentasPublico", "cuentasPublico", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaPublico;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaPublico;)V", "addHorarios", "horarios", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Horario;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Horario;)V", "addHorariosCUR", "horarioCURs", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/HorarioCUR;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/HorarioCUR;)V", "addParadas", "paradas", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Parada;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Parada;)V", "addPublicoGeneral", "publicoGeneral", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/PublicoGeneral;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/PublicoGeneral;)V", "addRutaCoordenadas", "rutaCoordenadas", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaCoordenada;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaCoordenada;)V", "addRutaParadas", "rutaParadas", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaParada;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaParada;)V", "addRutas", "rutas", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Ruta;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Ruta;)V", "addSugerenciaQueja", "quejaSugerencia", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/QuejaSugerencia;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/QuejaSugerencia;)V", "addTarifas", "tarifas", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Tarifa;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Tarifa;)V", "addUnidadCoordenadas", "unidadesCoordenadas", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/UnidadCoordenada;", "([Lcom/gammasoft/busfinder/model/dbLocal/relaciones/UnidadCoordenada;)V", "addUnidades", "unidades", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Unidad;", "([Lcom/gammasoft/busfinder/model/dbLocal/entidades/Unidad;)V", "deleteAdministrador", "administrador", "deleteAdministradores", "deleteAdministradoresByRFC", "rfc", "", "deleteChofer", "chofer", "deleteChoferes", "deleteCoordenada", "coordenada", "deleteCoordenadaById", "id", "", "deleteCoordenadas", "deleteCuenta", "cuenta", "deleteCuentaAdministrador", "cuentaAdministrador", "deleteCuentaChofer", "cuentaChofer", "deleteCuentaPublico", "cuentaPublico", "deleteCuentas", "deleteCuentasAdministrador", "deleteCuentasChofer", "deleteCuentasPublico", "deleteHorario", "horario", "deleteHorarioCUR", "horarioCUR", "deleteHorarios", "deleteHorariosCUR", "deleteParada", "parada", "deleteParadas", "deletePublicoGeneral", "deletePublicosGenerales", "deleteRuta", "ruta", "deleteRutaCoordenada", "rutaCoordenada", "deleteRutaParada", "rutaParada", "deleteRutas", "deleteRutasCoordenadas", "deleteRutasParadas", "deleteSugerenciaQueja", "deleteSugerenciasQuejas", "deleteTarifa", "tarifa", "deleteTarifas", "deleteUnidad", "unidad", "deleteUnidadCoordenada", "unidadCoordenada", "deleteUnidades", "deleteUnidadesCoordenadas", "getAdministradorByRFC", "Landroidx/lifecycle/LiveData;", "getAdministradorByUsuario", "usuario", "getAdministradores", "", "getChoferByNombre", "nombre", "getChoferByRFC", "getChoferByRFCYAdministrador", "getChoferByUsuario", "getChoferes", "getChoferesByAdministrador", "getCoordenadaById", "getCoordenadas", "getCoordenadasByAdministrador", "getCoordenadasIDByRutaID", "rutaID", "getCuentaAdministradorByCorreo", "correo", "getCuentaAdministradorByUsuario", "getCuentaByAdministradorUsuarioOCuentaCorreo", "usuarioOCorreo", "getCuentaByChoferUsuarioOCuentaCorreo", "getCuentaByCorreo", "getCuentaByPublicoUsuarioOCuentaCorreo", "getCuentaChoferByCorreo", "getCuentaChoferByUsuario", "getCuentaPublicoByCorreo", "getCuentaPublicoByUsuario", "getCuentas", "getCuentasAdministrador", "getCuentasChofer", "getCuentasPublico", "getHorarioById", "getHorarioCURs", "getHorarios", "getParadaById", "getParadaByNombre", "getParadas", "getParadasByAdministrador", "getPublicoGeneralByUsuario", "getPublicosGenerales", "getRutaById", "getRutaByNombre", "getRutaCoordenadaByRutaID", "getRutaCoordenadas", "getRutaIDByParadaID", "paradaID", "getRutaParadas", "getRutas", "getRutasByAdministrador", "getSugerenciasQuejas", "getSugerenciasQuejasById", "getTarifaByNombre", "getTarifas", "getTarifasByAdministrador", "getUnidadByPlaca", "placa", "getUnidades", "getUnidadesCoordenadas", "updateAdministrador", "updateChofer", "updateCoordenada", "updateCuenta", "updateCuentaAdministrador", "updateCuentaChofer", "updateCuentaPublico", "updateHorario", "updateHorarioCUR", "updateParada", "updatePublicoGeneral", "updateRuta", "updateRutaCoordenada", "updateRutaParada", "updateSugerenciaQueja", "updateTarifa", "updateUnidad", "updateUnidadCoordenada", "app_debug"})
public abstract interface Crud {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Cuenta")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta>> getCuentas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Cuenta WHERE correo = :correo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta> getCuentaByCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String correo);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addCuentas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta... cuentas);
    
    @androidx.room.Update()
    public abstract void updateCuenta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta... cuenta);
    
    @androidx.room.Delete()
    public abstract void deleteCuenta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta cuenta);
    
    @androidx.room.Query(value = "DELETE FROM Cuenta")
    public abstract void deleteCuentas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Administrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Administrador>> getAdministradores();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Administrador WHERE usuario = :usuario")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Administrador> getAdministradorByUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Administrador WHERE rfc = :rfc")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Administrador> getAdministradorByRFC(@org.jetbrains.annotations.NotNull()
    java.lang.String rfc);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addAdministradores(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Administrador... administradores);
    
    @androidx.room.Update()
    public abstract void updateAdministrador(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Administrador... administrador);
    
    @androidx.room.Delete()
    public abstract void deleteAdministrador(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Administrador administrador);
    
    @androidx.room.Query(value = "DELETE FROM Administrador WHERE rfc = :rfc")
    public abstract void deleteAdministradoresByRFC(@org.jetbrains.annotations.NotNull()
    java.lang.String rfc);
    
    @androidx.room.Query(value = "DELETE FROM Administrador")
    public abstract void deleteAdministradores();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Chofer")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Chofer>> getChoferes();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Chofer WHERE usuario = :usuario")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Chofer> getChoferByUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Chofer WHERE rfc = :rfc")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Chofer> getChoferByRFC(@org.jetbrains.annotations.NotNull()
    java.lang.String rfc);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Chofer WHERE nombre = :nombre")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Chofer> getChoferByNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Chofer WHERE administrador = :administrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Chofer>> getChoferesByAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String administrador);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Chofer WHERE rfc = :rfc AND administrador = :administrador")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Chofer> getChoferByRFCYAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String rfc, @org.jetbrains.annotations.NotNull()
    java.lang.String administrador);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addChoferes(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Chofer... choferes);
    
    @androidx.room.Update()
    public abstract void updateChofer(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Chofer... chofer);
    
    @androidx.room.Delete()
    public abstract void deleteChofer(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Chofer chofer);
    
    @androidx.room.Query(value = "DELETE FROM Chofer")
    public abstract void deleteChoferes();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM PublicoGeneral")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral>> getPublicosGenerales();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM PublicoGeneral WHERE usuario = :usuario")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral> getPublicoGeneralByUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addPublicoGeneral(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral... publicoGeneral);
    
    @androidx.room.Update()
    public abstract void updatePublicoGeneral(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral... publicoGeneral);
    
    @androidx.room.Delete()
    public abstract void deletePublicoGeneral(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral publicoGeneral);
    
    @androidx.room.Query(value = "DELETE FROM PublicoGeneral")
    public abstract void deletePublicosGenerales();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Ruta")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Ruta>> getRutas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Ruta WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Ruta> getRutaById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Ruta WHERE nombre = :nombre")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Ruta> getRutaByNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Ruta WHERE administrador = :administrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Ruta>> getRutasByAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String administrador);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addRutas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Ruta... rutas);
    
    @androidx.room.Update()
    public abstract void updateRuta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Ruta... ruta);
    
    @androidx.room.Delete()
    public abstract void deleteRuta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Ruta ruta);
    
    @androidx.room.Query(value = "DELETE FROM Ruta")
    public abstract void deleteRutas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Parada")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Parada>> getParadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Parada WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Parada> getParadaById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Parada WHERE nombre = :nombre")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Parada> getParadaByNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Parada WHERE administrador = :administrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Parada>> getParadasByAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String administrador);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addParadas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Parada... paradas);
    
    @androidx.room.Update()
    public abstract void updateParada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Parada... parada);
    
    @androidx.room.Delete()
    public abstract void deleteParada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Parada parada);
    
    @androidx.room.Query(value = "DELETE FROM Parada")
    public abstract void deleteParadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Unidad")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Unidad>> getUnidades();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Unidad WHERE placa = :placa")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Unidad> getUnidadByPlaca(@org.jetbrains.annotations.NotNull()
    java.lang.String placa);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addUnidades(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Unidad... unidades);
    
    @androidx.room.Update()
    public abstract void updateUnidad(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Unidad... unidad);
    
    @androidx.room.Delete()
    public abstract void deleteUnidad(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Unidad unidad);
    
    @androidx.room.Query(value = "DELETE FROM Unidad")
    public abstract void deleteUnidades();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Tarifa")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa>> getTarifas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Tarifa WHERE nombre = :nombre")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa> getTarifaByNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Tarifa WHERE administrador = :administrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa>> getTarifasByAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String administrador);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addTarifas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa... tarifas);
    
    @androidx.room.Update()
    public abstract void updateTarifa(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa... tarifa);
    
    @androidx.room.Delete()
    public abstract void deleteTarifa(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa tarifa);
    
    @androidx.room.Query(value = "DELETE FROM Tarifa")
    public abstract void deleteTarifas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Horario")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Horario>> getHorarios();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Horario WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Horario> getHorarioById(int id);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addHorarios(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Horario... horarios);
    
    @androidx.room.Update()
    public abstract void updateHorario(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Horario... horario);
    
    @androidx.room.Delete()
    public abstract void deleteHorario(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Horario horario);
    
    @androidx.room.Query(value = "DELETE FROM Horario")
    public abstract void deleteHorarios();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Coordenada")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada>> getCoordenadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Coordenada WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada> getCoordenadaById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Coordenada WHERE administrador = :administrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada>> getCoordenadasByAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String administrador);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addCoordenadas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada... coordenadas);
    
    @androidx.room.Update()
    public abstract void updateCoordenada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada... coordenada);
    
    @androidx.room.Delete()
    public abstract void deleteCoordenada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada coordenada);
    
    @androidx.room.Query(value = "DELETE FROM Coordenada WHERE id = :id")
    public abstract void deleteCoordenadaById(int id);
    
    @androidx.room.Query(value = "DELETE FROM Coordenada")
    public abstract void deleteCoordenadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM SugerenciaQueja")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia>> getSugerenciasQuejas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM SugerenciaQueja WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia> getSugerenciasQuejasById(int id);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addSugerenciaQueja(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia... quejaSugerencia);
    
    @androidx.room.Update()
    public abstract void updateSugerenciaQueja(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia... quejaSugerencia);
    
    @androidx.room.Delete()
    public abstract void deleteSugerenciaQueja(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia quejaSugerencia);
    
    @androidx.room.Query(value = "DELETE FROM SugerenciaQueja WHERE id = :id")
    public abstract void deleteSugerenciaQueja(int id);
    
    @androidx.room.Query(value = "DELETE FROM SugerenciaQueja")
    public abstract void deleteSugerenciasQuejas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaAdministrador")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador>> getCuentasAdministrador();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaAdministrador WHERE administrador_Usuario = :usuario")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador> getCuentaAdministradorByUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaAdministrador WHERE cuenta_Correo = :correo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador> getCuentaAdministradorByCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String correo);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaAdministrador WHERE administrador_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta> getCuentaByAdministradorUsuarioOCuentaCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String usuarioOCorreo);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addCuentasAdministrador(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador... cuentasAdministrador);
    
    @androidx.room.Update()
    public abstract void updateCuentaAdministrador(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador... cuentaAdministrador);
    
    @androidx.room.Delete()
    public abstract void deleteCuentaAdministrador(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador cuentaAdministrador);
    
    @androidx.room.Query(value = "DELETE FROM CuentaAdministrador")
    public abstract void deleteCuentasAdministrador();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaChofer")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer>> getCuentasChofer();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaChofer WHERE chofer_Usuario = :usuario")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer> getCuentaChoferByUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaChofer WHERE cuenta_Correo = :correo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer> getCuentaChoferByCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String correo);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaChofer WHERE chofer_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta> getCuentaByChoferUsuarioOCuentaCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String usuarioOCorreo);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addCuentasChofer(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer... cuentasChofer);
    
    @androidx.room.Update()
    public abstract void updateCuentaChofer(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer... cuentaChofer);
    
    @androidx.room.Delete()
    public abstract void deleteCuentaChofer(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer cuentaChofer);
    
    @androidx.room.Query(value = "DELETE FROM CuentaChofer")
    public abstract void deleteCuentasChofer();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaPublico")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico>> getCuentasPublico();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaPublico WHERE publico_General_Usuario = :usuario")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico> getCuentaPublicoByUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CuentaPublico WHERE cuenta_Correo = :correo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico> getCuentaPublicoByCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String correo);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaPublico WHERE publico_General_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta> getCuentaByPublicoUsuarioOCuentaCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String usuarioOCorreo);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addCuentasPublico(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico... cuentasPublico);
    
    @androidx.room.Update()
    public abstract void updateCuentaPublico(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico... cuentaPublico);
    
    @androidx.room.Delete()
    public abstract void deleteCuentaPublico(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico cuentaPublico);
    
    @androidx.room.Query(value = "DELETE FROM CuentaPublico")
    public abstract void deleteCuentasPublico();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM RutaCoordenada")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada>> getRutaCoordenadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM RutaCoordenada WHERE ruta_ID = :rutaID")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada>> getCoordenadasIDByRutaID(int rutaID);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM RutaCoordenada WHERE ruta_ID = :rutaID")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada> getRutaCoordenadaByRutaID(int rutaID);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addRutaCoordenadas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada... rutaCoordenadas);
    
    @androidx.room.Update()
    public abstract void updateRutaCoordenada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada... rutaCoordenada);
    
    @androidx.room.Delete()
    public abstract void deleteRutaCoordenada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada rutaCoordenada);
    
    @androidx.room.Query(value = "DELETE FROM RutaCoordenada")
    public abstract void deleteRutasCoordenadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM RutaParada")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada>> getRutaParadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM RutaParada WHERE parada_ID = :paradaID")
    public abstract androidx.lifecycle.LiveData<com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada> getRutaIDByParadaID(int paradaID);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addRutaParadas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada... rutaParadas);
    
    @androidx.room.Update()
    public abstract void updateRutaParada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada... rutaParada);
    
    @androidx.room.Delete()
    public abstract void deleteRutaParada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada rutaParada);
    
    @androidx.room.Query(value = "DELETE FROM RutaParada")
    public abstract void deleteRutasParadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM UnidadCoordenada")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada>> getUnidadesCoordenadas();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addUnidadCoordenadas(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada... unidadesCoordenadas);
    
    @androidx.room.Update()
    public abstract void updateUnidadCoordenada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada... unidadCoordenada);
    
    @androidx.room.Delete()
    public abstract void deleteUnidadCoordenada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada unidadCoordenada);
    
    @androidx.room.Query(value = "DELETE FROM UnidadCoordenada")
    public abstract void deleteUnidadesCoordenadas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM HorarioChoferUnidadRuta")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR>> getHorarioCURs();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addHorariosCUR(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR... horarioCURs);
    
    @androidx.room.Update()
    public abstract void updateHorarioCUR(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR... horarioCUR);
    
    @androidx.room.Delete()
    public abstract void deleteHorarioCUR(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR horarioCUR);
    
    @androidx.room.Query(value = "DELETE FROM HorarioChoferUnidadRuta")
    public abstract void deleteHorariosCUR();
}