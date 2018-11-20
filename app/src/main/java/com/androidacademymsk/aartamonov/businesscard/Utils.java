package com.androidacademymsk.aartamonov.businesscard;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import java.text.DateFormat;
import java.util.Date;

import static android.support.design.widget.Snackbar.make;

public class Utils {

    static void showMessage(View mview, String message) {
        //        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//        View mainView = findViewById(android.R.id.content);
        make(mview, message, Snackbar.LENGTH_LONG).show();
    }
<<<<<<< Updated upstream
=======

    public static Long loadInTime(long howLongToWait) {
        try {
            Thread.sleep(howLongToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return howLongToWait;
    }

    public static String dateFormat(Date ddate) {
//        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(ctx);
//        dateFormat.format("yyyy", ddate);
//        return dateFormat.format(ddate);
        return android.text.format.DateFormat.format("dd.MM.yyyy, hh:mm", ddate).toString();
    }
>>>>>>> Stashed changes
}
