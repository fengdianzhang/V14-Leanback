package android.support.v17.leanback;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fengdianzhang
 * @version 1.0
 */

public class MigrateHelper {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static boolean hasTransientState(View view) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
            return view.hasTransientState();
        } else {
            return ViewCompat.hasTransientState(view);
        }
    }

    public static void setMarginStart(MarginLayoutParams lp, int marginStart) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN_MR1) {
            lp.setMarginStart(marginStart);
        } else {
            MarginLayoutParamsCompat.setMarginStart(lp, marginStart);
        }
    }

    public static void setMarginEnd(MarginLayoutParams lp, int marginEnd) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN_MR1) {
            lp.setMarginEnd(marginEnd);
        } else {
            MarginLayoutParamsCompat.setMarginEnd(lp, marginEnd);
        }
    }

    public static int getMarginStart(MarginLayoutParams lp) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN_MR1) {
            return lp.getMarginStart();
        } else {
            return MarginLayoutParamsCompat.getMarginStart(lp);
        }
    }

    public static int getMarginEnd(MarginLayoutParams lp) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN_MR1) {
            return lp.getMarginEnd();
        } else {
            return MarginLayoutParamsCompat.getMarginEnd(lp);
        }
    }

    public static void postOnAnimation(View view, Runnable action) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
            view.postOnAnimation(action);
        } else {
            ViewCompat.postOnAnimation(view, action);
        }
    }

    public static void setLayoutMode(ViewGroup parent, int layoutMode) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN_MR2) {
            parent.setLayoutMode(layoutMode);
        } else {
            ViewGroupCompat.setLayoutMode(parent, layoutMode);
        }
    }
}
