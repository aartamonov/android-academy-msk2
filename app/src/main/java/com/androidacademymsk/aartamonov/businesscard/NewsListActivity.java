package com.androidacademymsk.aartamonov.businesscard;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.androidacademymsk.aartamonov.businesscard.background.BgRunnable;
import com.androidacademymsk.aartamonov.businesscard.data.DataUtils;
import com.androidacademymsk.aartamonov.businesscard.data.NewsItem;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NewsListActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    @Nullable private Executor executor;
    @Nullable private Disposable disposable;

    private final NewsAdapter.OnItemClickListener clickListener = new NewsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Activity activity, NewsItem newsItem) {
            String clickMess = newsItem.getTitle();
            Utils.showMessage(findViewById(android.R.id.content), clickMess);
            NewsDetailsActivity.startActivity(activity, newsItem);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        rv = findViewById(R.id.news_list);
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

//    @Override
//    protected void onStart() {
//        super.onStart();

//        ProgressBar pb = findViewById(R.id.progressBar);
//        pb.setVisibility(View.VISIBLE);
//
//        executor = Executors.newSingleThreadExecutor();
//        executor.execute(new BgRunnable(this));

//        final long timeToWait = 2000L;
//        disposable = Observable.fromCallable(new Callable<Object>() {
//            @Override
//            public Object call() {
//                return Utils.loadInTime(timeToWait);
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) {
//                        updateUI();
//                    }
//                });

//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        executor = null;
//        if (disposable != null) {
//            disposable.dispose();
//            disposable = null;
//        }
//    }

//    private void rxOnStart() {
//        disposibal =
//    }

//    private void updateUI() {
//        Log.i("NewsActivity", "updateUI");
//        if (textView != null) {
//
//        }
//    }
}
