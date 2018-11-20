package com.androidacademymsk.aartamonov.businesscard;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidacademymsk.aartamonov.businesscard.data.DataUtils;
import com.androidacademymsk.aartamonov.businesscard.data.NewsItem;
import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.util.List;
import java.util.stream.Stream;

public class NewsDetailsActivity extends AppCompatActivity {

    private static String LOG_TAG = "NewsDetailsActivity";

    private static String EXTRA_NEWS_ID = "newsId";
    private static String EXTRA_NEWS_TITLE = "newsTitle";

    public static void startActivity(Activity activity, int itemId) {
        Intent intent = new Intent(activity, NewsDetailsActivity.class);
        intent.putExtra(EXTRA_NEWS_ID, itemId);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity, NewsItem newsItem) {
        Intent intent = new Intent(activity, NewsDetailsActivity.class);
        intent.putExtra(EXTRA_NEWS_TITLE, newsItem.getTitle());
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

//        Intent intent = savedInstanceState.

//        int newsId = getIntent().getIntExtra(EXTRA_NEWS_ID, 1); //1;
        String newsTitle = getIntent().getStringExtra(EXTRA_NEWS_TITLE);
        NewsItem ni = getNewsByTitle(newsTitle); // getNewsById(newsId);
        setNewsOnView(ni);
    }

    private NewsItem getNewsById(int nid) {
        return DataUtils.generateNews().get(nid);
    }

    private NewsItem getNewsByTitle(String title) {
//        DataUtils.generateNews().stream().filter( newsItem -> newsItem.getTitle() == title);
        List<NewsItem> newsItems = DataUtils.generateNews();
        for (NewsItem ni : newsItems) {
            if (ni.getTitle().equals(title)) {
                return ni;
            }
        }
        return null;
    }

    private void setNewsOnView(NewsItem ni) {
        if (ni == null) {
            Log.d(LOG_TAG, "NewsItem is NULL!!!");
        } else {
            Log.d(LOG_TAG, "NewsItem: caption " + ni.getTitle() + ", image: " + ni.getImageUrl() + ", content: " + ni.getFullText() + ", date: " + ni.getPublishDate());
        }
        TextView caption = findViewById(R.id.news_caption_view); // new TextView(this);
        caption.setText(ni.getTitle());
        ImageView news_image = findViewById(R.id.news_image_view); // new ImageView(this);
        Glide.with(getApplicationContext()).load(ni.getImageUrl()).into(news_image);
        TextView content = findViewById(R.id.news_content_view); // new TextView(this);
        content.setText(ni.getFullText());
        TextView newsDateView = findViewById(R.id.news_date_view);

//        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
//        newsDateView.setText(dateFormat.format(ni.getPublishDate()));
        newsDateView.setText(Utils.dateFormat(ni.getPublishDate()));
    }
}
