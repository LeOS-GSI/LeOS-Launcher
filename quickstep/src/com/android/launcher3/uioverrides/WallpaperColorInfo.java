package com.android.launcher3.uioverrides;

import android.content.Context;

import com.android.launcher3.Utilities;

public abstract class WallpaperColorInfo {
    private static final Object sInstanceLock = new Object();
    private static WallpaperColorInfo sInstance;

    // TODO think if it still does make sense to use it when Material-You/Monet engines are there
    public static WallpaperColorInfo getInstance(Context context) {
        synchronized (sInstanceLock) {
            if (sInstance == null) {
                if (Utilities.ATLEAST_Q) {
                    sInstance = new WallpaperColorInfoVL(context.getApplicationContext());
                } else if (Utilities.ATLEAST_P) {
                    sInstance = new WallpaperColorInfoVP(context.getApplicationContext());
                } else if (Utilities.ATLEAST_OREO_MR1) {
                    sInstance = new WallpaperColorInfoVOMR1(context.getApplicationContext());
                } else {
                    sInstance = new WallpaperColorInfoVL(context.getApplicationContext());
                }
            }
            return sInstance;
        }
    }

    public abstract int getMainColor();

    public abstract int getActualMainColor();

    public abstract int getSecondaryColor();

    public abstract int getActualSecondaryColor();

    public abstract int getTertiaryColor();

    public boolean isMainColorDark() {
        return isDark();
    }

    public abstract boolean isDark();

    public abstract boolean supportsDarkText();

    public abstract void addOnChangeListener(OnChangeListener listener);

    public abstract void removeOnChangeListener(OnChangeListener listener);

    public interface OnChangeListener {
        void onExtractedColorsChanged(WallpaperColorInfo wallpaperColorInfo);
    }
}
