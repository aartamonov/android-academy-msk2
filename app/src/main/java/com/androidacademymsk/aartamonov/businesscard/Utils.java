package com.androidacademymsk.aartamonov.businesscard;

import android.support.design.widget.Snackbar;
import android.view.View;

import static android.support.design.widget.Snackbar.make;

public class Utils {

    static void showMessage(View mview, String message) {
        //        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//        View mainView = findViewById(android.R.id.content);
        make(mview, message, Snackbar.LENGTH_LONG).show();
    }
}
