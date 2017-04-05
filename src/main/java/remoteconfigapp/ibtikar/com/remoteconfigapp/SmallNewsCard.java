package remoteconfigapp.ibtikar.com.remoteconfigapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by mahmoud on 04-Apr-17.
 */

public class SmallNewsCard extends LinearLayout{

    private PicassoImageView newsImageLarge;
    private TextView title;

    public SmallNewsCard(Context context) {
        super(context);
        init();
    }

    public SmallNewsCard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.small_news_card, this);
        newsImageLarge = (PicassoImageView) findViewById(R.id.news_image);
        title = (TextView) findViewById(R.id.title);
    }

    public void bind(NewsModel newsModel) {
        newsImageLarge.Url(newsModel.getNewsUrl());
        title.setText(newsModel.getNewsTitle());
    }
}
