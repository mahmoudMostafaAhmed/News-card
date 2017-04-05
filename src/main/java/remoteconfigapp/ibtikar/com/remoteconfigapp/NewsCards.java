package remoteconfigapp.ibtikar.com.remoteconfigapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mahmoud on 03-Apr-17.
 */

public class NewsCards extends LinearLayout {

    private PicassoImageView newsImageLarge;
    private TextView title, desciraption;

    public NewsCards(Context context) {
        super(context);
        init();
    }

    public NewsCards(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.news_card, this);
        newsImageLarge = (PicassoImageView) findViewById(R.id.news_image_large);
        title = (TextView) findViewById(R.id.title);
        desciraption = (TextView) findViewById(R.id.descirption);
    }

    public void bind(NewsModel newsModel) {
        newsImageLarge.Url(newsModel.getNewsUrl());
        title.setText(newsModel.getNewsTitle());
        desciraption.setText(newsModel.getNewsDes());
    }
}
