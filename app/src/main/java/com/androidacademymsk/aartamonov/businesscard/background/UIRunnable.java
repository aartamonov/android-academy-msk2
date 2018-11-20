package com.androidacademymsk.aartamonov.businesscard.background;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.androidacademymsk.aartamonov.businesscard.NewsAdapter;
import com.androidacademymsk.aartamonov.businesscard.R;
import com.androidacademymsk.aartamonov.businesscard.Utils;
import com.androidacademymsk.aartamonov.businesscard.data.DataUtils;
import com.androidacademymsk.aartamonov.businesscard.data.NewsItem;

import java.lang.ref.WeakReference;

public class UIRunnable implements Runnable {
    @NonNull
    private final WeakReference<Activity> activityRef;
    private final Long waitTime;
    private Activity activity;

    private final NewsAdapter.OnItemClickListener clickListener = null; /*new NewsAdapter.OnItemClickListener() {

        @Override
        public void onItemClick(NewsItem newsItem) {
            String clickMess = newsItem.getTitle();

            Utils.showMessage(activity.findViewById(android.R.id.content), clickMess);
        }
    };
*/
    public UIRunnable(@NonNull Activity activity, Long waitTime) {
        this.activityRef = new WeakReference<>(activity);
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        initActivity();
    }

    synchronized void initActivity() {
        activity = activityRef.get();
        if (activity != null) {
//            ProgressBar progressBar = activity.findViewById(R.id.progressBar);
//            progressBar.setVisibility(View.GONE);

            RecyclerView rv = activity.findViewById(R.id.news_list);
            rv.setHasFixedSize(true);
            Log.d("UIRunnable", rv.toString());

            RecyclerView.LayoutManager rvLayoutManager = new LinearLayoutManager(activity);
            Log.d("UIRunnable", rvLayoutManager.toString());
            rv.setLayoutManager(rvLayoutManager);

            RecyclerView.Adapter rvAdapter = new NewsAdapter(activity, DataUtils.generateNews(), clickListener);
            rv.setAdapter(rvAdapter);

        }
    }
}
