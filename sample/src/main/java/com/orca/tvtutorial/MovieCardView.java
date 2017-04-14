package com.orca.tvtutorial;

import android.content.Context;
import android.support.v17.leanback.widget.BaseCardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

/**
 * @author fengdianzhang
 * @version 1.0
 */

public class MovieCardView extends BaseCardView {
    public MovieCardView(Context context) {
        this(context, null);
    }

    public MovieCardView(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v17.leanback.R.attr.baseCardViewStyle);
    }

    public MovieCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(getContext()).inflate(R.layout.movie_item, this);
    }
}
