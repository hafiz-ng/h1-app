package app.h1.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import app.h1.MainActivity;
import app.h1.R;
import app.h1.SplashActivity;
import app.h1.helper.NotificationCounter;

public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    NotificationCounter notificationCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        notificationCounter = new NotificationCounter(findViewById(R.id.textViewNotification));
    }

    public void increaseNotificationNum(View view) {
        notificationCounter.increaseNumber();
    }
}