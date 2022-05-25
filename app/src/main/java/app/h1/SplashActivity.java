package app.h1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.h1.ui.CommonBugsActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView m_imageView;
    TextView m_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        m_imageView = findViewById(R.id.imageViewGoogleBtn);

        m_textview = findViewById(R.id.textView);

        m_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}