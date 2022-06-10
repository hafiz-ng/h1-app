package app.h1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.h1.R;
import app.h1.helper.NotificationCounter;

public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    NotificationCounter notificationCounter;
    TextView cookieTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        cookieTextView = findViewById(R.id.textView);



        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        String i = getIntent().getStringExtra("cookies");
        cookieTextView.setText(i);
//        Toast.makeText(NotificationActivity.this, i, Toast.LENGTH_SHORT).show();

        notificationCounter = new NotificationCounter(findViewById(R.id.textViewNotification));
    }

    public void increaseNotificationNum(View view) {
        notificationCounter.increaseNumber();
    }
}