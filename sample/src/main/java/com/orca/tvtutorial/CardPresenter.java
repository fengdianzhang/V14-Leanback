package com.orca.tvtutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

import java.net.URI;

/**
 * @author fengdianzhang
 * @version 1.0
 */

public class CardPresenter extends Presenter {
    private static final String TAG = "CardPresenter";
    private static Context mContext;
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 176;

    static class ViewHolder extends Presenter.ViewHolder {
        private Movie mMovie;
        private ImageView mPoster;
        private CommonCardView mCardView;
        private Drawable mDefaultCardImage;

        public ViewHolder(View view) {
            super(view);
            mCardView = (CommonCardView) view;
            mPoster = (ImageView) view.findViewById(R.id.poster);
            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.movie);
        }

        public void setMovie(Movie m) {
            this.mMovie = m;
        }

        public Movie getMovie() {
            return mMovie;
        }

        public CommonCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }

        public void updateCardViewImage(URI uri) {
            Picasso.with(mContext)
                    .load(uri.toString())
                    .error(mDefaultCardImage)
                    .into(mPoster);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();
        CommonCardView cardView = (CommonCardView) LayoutInflater.from(mContext).inflate(R.layout.text_card, null);
//        CommonCardView cardView = new CommonCardView(mContext);
//        ImageCardView cardView = new ImageCardView(mContext, null, -1);
//        cardView.setMainImageScaleType(ScaleType.CENTER_CROP);
//        cardView.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.setMovie(movie);
//        holder.mCardView.setTitleText(movie.getTitle());
//        holder.mCardView.setContentText(movie.getStudio());
//        holder.mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        holder.updateCardViewImage(movie.getCardImageURI());
//        holder.mCardView.setMainImage(holder.getDefaultCardImage());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder holder) {
    }
}
