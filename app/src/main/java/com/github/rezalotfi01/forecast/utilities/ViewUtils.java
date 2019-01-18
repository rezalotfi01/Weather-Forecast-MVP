package com.github.rezalotfi01.forecast.utilities;

import android.content.res.Resources;
import android.util.DisplayMetrics;


public class ViewUtils {

    public static int dp2px(int dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) (dp * metrics.density);
    }

    public static int px2dp(int px) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) (px / metrics.density);
    }
}
