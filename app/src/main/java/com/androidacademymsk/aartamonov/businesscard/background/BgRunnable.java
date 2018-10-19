package com.androidacademymsk.aartamonov.businesscard.background;

import android.app.Activity;

import com.androidacademymsk.aartamonov.businesscard.Utils;

import java.lang.ref.WeakReference;

public class BgRunnable implements Runnable {
    private final WeakReference<Activity> activityRef;

    public BgRunnable(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
    }

    @Override
    public void run() {
        Long waitTime = Utils.loadInTime(1000);
        Activity activity = activityRef.get();
        if (activity != null) {
            activity.runOnUiThread(new UIRunnable(activity, waitTime));
        }
    }
}
