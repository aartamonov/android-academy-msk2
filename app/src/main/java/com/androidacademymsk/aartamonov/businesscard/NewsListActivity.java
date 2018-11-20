package com.androidacademymsk.aartamonov.businesscard;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.androidacademymsk.aartamonov.businesscard.data.DataUtils;
import com.androidacademymsk.aartamonov.businesscard.data.NewsItem;

public class NewsListActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private final NewsAdapter.OnItemClickListener clickListener = new NewsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Activity activity, NewsItem newsItem) {
            String clickMess = newsItem.getTitle();
            Utils.showMessage(findViewById(android.R.id.content), clickMess);
<<<<<<< Updated upstream
=======
            NewsDetailsActivity.startActivity(activity, newsItem);
>>>>>>> Stashed changes
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        rv = (RecyclerView) findViewById(R.id.news_list);
        rv.setHasFixedSize(true);

        rvLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLayoutManager);

        rvAdapter = new NewsAdapter(this, DataUtils.generateNews(), clickListener);
        rv.setAdapter(rvAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_switch:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
