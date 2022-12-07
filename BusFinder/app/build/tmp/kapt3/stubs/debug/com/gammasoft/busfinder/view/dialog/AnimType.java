package com.gammasoft.busfinder.view.dialog;

import java.lang.System;

@androidx.annotation.IntDef(value = {0, 1, 2, 3, 4})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/gammasoft/busfinder/view/dialog/AnimType;", "", "Companion", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention()
public abstract @interface AnimType {
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.view.dialog.AnimType.Companion Companion = null;
    public static final int ANIM_FROM_LEFT = 0;
    public static final int ANIM_FROM_RIGHT = 1;
    public static final int ANIM_FROM_TOP = 2;
    public static final int ANIM_FROM_BOTTOM = 3;
    public static final int ANIM_FROM_CENTER = 4;
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/gammasoft/busfinder/view/dialog/AnimType$Companion;", "", "()V", "ANIM_FROM_BOTTOM", "", "ANIM_FROM_CENTER", "ANIM_FROM_LEFT", "ANIM_FROM_RIGHT", "ANIM_FROM_TOP", "app_debug"})
    public static final class Companion {
        public static final int ANIM_FROM_LEFT = 0;
        public static final int ANIM_FROM_RIGHT = 1;
        public static final int ANIM_FROM_TOP = 2;
        public static final int ANIM_FROM_BOTTOM = 3;
        public static final int ANIM_FROM_CENTER = 4;
        
        private Companion() {
            super();
        }
    }
}