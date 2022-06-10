package app.h1.ui;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import app.h1.R;

public class LoadReportActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button m_pay;
    EditText no_cookies;

    String CHANNEL_ID = "1";

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_report);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        m_pay = findViewById(R.id.button);
        no_cookies = findViewById(R.id.editText);

        createNotificationChannel();

        registrationToken();

        m_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no_of_cookies = no_cookies.getText().toString();

                Intent i = new Intent(LoadReportActivity.this, NotificationActivity.class);
                i.putExtra("cookies", no_of_cookies);

                PendingIntent pendingIntent = PendingIntent.getActivity(LoadReportActivity.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(LoadReportActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.notify_icon)
                        .setContentTitle("Cookies")
                        .setContentTitle("You just bought " + no_of_cookies + " Cookies!")
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(LoadReportActivity.this);


                // Notification ID is unique for each notification you create
                notificationManagerCompat.notify(1, builder.build());

                Toast.makeText(LoadReportActivity.this, no_of_cookies + " Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createNotificationChannel() {
        // create notification channel on API level 26+
        // NotificationChannel is a new Class and not in a support library

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "Channel Name";
            String description = "My Channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            // You cannot change importance or other notification behaviours after this
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
    }

    void registrationToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d("Token: ", token);
                        Toast.makeText(LoadReportActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_web, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.back) {
            if (webView.canGoBack()) {
                webView.goBack();

            } else if (item.getItemId() == R.id.forward) {
                if (webView.canGoForward()) {
                    webView.canGoForward();
                }
            }

        }

        return super.onOptionsItemSelected(item);
    }
}