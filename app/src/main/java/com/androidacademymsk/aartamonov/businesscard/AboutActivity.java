package com.androidacademymsk.aartamonov.businesscard;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.support.design.widget.Snackbar.make;

public class AboutActivity extends AppCompatActivity {

    private final static String HABR_URL = "https://www.habr.com";
    private final static String VK_URL = "https://vk.com";
    private final static String[] EMAIL_ADDRESS = {"andr.academy.msk@gmail.com"};
    private final static String MAILTO = "mailto:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        init();
    }

    private void init() {

        initHabr();
        initVk();
        initSendEmail();
        final TextView disclaimer = findViewById(R.id.disclaimer_view);
        disclaimer.setText(R.string.disclaimer_text);
    }

    private void initHabr() {
        final ImageView habrImg = findViewById(R.id.habr_logo);
        habrImg.setClickable(true);
        habrImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebBrowser(HABR_URL);
            }
        });
    }

    private void initVk() {
        final ImageView vkImg = findViewById(R.id.vk_logo);
        vkImg.setClickable(true);
        vkImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebBrowser(VK_URL);
            }
        });
    }

    private void initSendEmail() {
        final EditText messageEdit = findViewById(R.id.message_text);
        final Button sendBtn = findViewById(R.id.send_btn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mess = messageEdit.getText().toString();
                if (mess == null || mess.isEmpty()) {
                    showMessage(getString(R.string.warn_empty_message));
                    return;
                }
                sendEmail(mess);
            }
        });
    }

    private void openWebBrowser(String resUrl) {
        final Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse(resUrl));
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        } else {
            showMessage(getString(R.string.error_no_browser_app));
        }
    }

    private void sendEmail(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(MAILTO));
        intent.putExtra(Intent.EXTRA_EMAIL, EMAIL_ADDRESS);
        intent.putExtra(Intent.EXTRA_SUBJECT, R.string.email_subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            showMessage(getString(R.string.error_no_email_app));
        }
    }

    private void showMessage(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        View mainView = findViewById(android.R.id.content);
         make(mainView, message, Snackbar.LENGTH_LONG).show();
    }
}
