package com.orca.tvtutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

import java.net.URI;

/**
 * @author fengdianzhang
 * @version 1.0
 */

public class ProgramPresenter extends Presenter {
    private static final String TAG = "ProgramPresenter";
    private static Context mContext;
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 500;

//    static class ViewHolder extends Presenter.ViewHolder {
//        private Movie mMovie;
//        private ImageCardView mCardView;
//        private Drawable mDefaultCardImage;
//        private PicassoImageCardViewTarget mImageCardViewTarget;
//
//        public ViewHolder(View view) {
//            super(view);
//            mCardView = (ImageCardView) view;
//            mImageCardViewTarget = new PicassoImageCardViewTarget(mCardView);
//            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.movie);
//        }
//
//        public void setMovie(Movie m) {
//            this.mMovie = m;
//        }
//
//        public Movie getMovie() {
//            return mMovie;
//        }
//
//        public ImageCardView getCardView() {
//            return mCardView;
//        }
//
//        public Drawable getDefaultCardImage() {
//            return mDefaultCardImage;
//        }
//
//        public void updateCardViewImage(URI uri) {
////            Picasso.with(mContext)
////                    .load(uri.toString())
////                    .resize(Utils.convertDpToPixel(mContext, CARD_WIDTH),
////                            Utils.convertDpToPixel(mContext, CARD_HEIGHT))
////                    .error(mDefaultCardImage)
////                    .into(mImageCardViewTarget);
//            mCardView.setMainImage(mContext.getResources().getDrawable(R.drawable.movie));
//        }
//    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();
        ImageView imageView = new ImageView(mContext);
        return new ImageViewHolder(imageView);
//        ImageCardView cardView = new ImageCardView(mContext);
//        cardView.setCardType(BaseCardView.CARD_TYPE_INFO_UNDER);
//        cardView.setInfoVisibility(BaseCardView.CARD_REGION_VISIBLE_ALWAYS);
//        cardView.setFocusable(true);
//        cardView.setFocusableInTouchMode(true);
//        cardView.setBackgroundColor(mContext.getResources().getColor(R.color.fastlane_background));
//        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Log.d(TAG, "onBindViewHolder");
        Movie movie = (Movie) item;
        ImageViewHolder holder = (ImageViewHolder) viewHolder;
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.movie));
//        ViewHolder holder = (ImageViewHolder) viewHolder;
//        holder.setMovie(movie);
//        holder.mCardView.setTitleText(movie.getTitle());
//        holder.mCardView.setContentText(movie.getStudio());
//        holder.mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
//        holder.updateCardViewImage(movie.getCardImageURI());
//        holder.mCardView.setMainImage(holder.getDefaultCardImage());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder holder) {
    }

    public static class PicassoImageCardViewTarget implements Target {
        private ImageCardView mImageCardView;

        public PicassoImageCardViewTarget(ImageCardView imageCardView) {
            this.mImageCardView = imageCardView;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from) {
            Log.d(TAG, "load success...");
            Drawable bitmapDrawable = new BitmapDrawable(mContext.getResources(), bitmap);
            mImageCardView.setMainImage(bitmapDrawable);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            Log.d(TAG, "load failed...");
            mImageCardView.setMainImage(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    }

    static class ImageViewHolder extends Presenter.ViewHolder {

        ImageView imageView;
        public ImageViewHolder(View view) {
            super(view);
            imageView = (ImageView) view;
        }
    }
}
