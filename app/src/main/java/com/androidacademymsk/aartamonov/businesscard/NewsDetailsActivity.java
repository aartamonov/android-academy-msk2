package com.androidacademymsk.aartamonov.businesscard;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidacademymsk.aartamonov.businesscard.data.DataUtils;
import com.androidacademymsk.aartamonov.businesscard.data.NewsItem;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.stream.Stream;

public class NewsDetailsActivity extends AppCompatActivity {

    private static String EXTRA_NEWS_ID = "newsId";

    public static void startActivity(Activity activity, int itemId) {
        Intent intent = new Intent(activity, NewsDetailsActivity.class);
        intent.putExtra(EXTRA_NEWS_ID, itemId);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity, NewsItem newsItem) {
        Intent intent = new Intent(activity, NewsDetailsActivity.class);
        intent.putExtra(EXTRA_NEWS_ID, newsItem.getTitle());
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        int newsId = 1;
        NewsItem ni = getNewsById(newsId);
        setNewsOnView(ni);
    }

    private NewsItem getNewsById(int nid) {
        return DataUtils.generateNews().get(nid);
    }

    private NewsItem getNewsByTitle(String title) {
//        DataUtils.generateNews().stream().filter( newsItem -> newsItem.getTitle() == title);
        List newsItems = DataUtils.generateNews();
        for (ni : newsItems) {

        }
    }

    private void setNewsOnView(NewsItem ni) {
        TextView caption = new TextView(this);
        caption.setText(ni.getTitle());
        ImageView news_image = new ImageView(this);
        Glide.with(getApplicationContext()).load(ni.getImageUrl()).into(news_image);
        TextView content = new TextView(this);
        content.setText(ni.getFullText());

    }
}
