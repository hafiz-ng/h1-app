package app.h1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import app.h1.R;

public class CommonBugsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_type);
    }

    public void SQLInjectionListener(View view) {
        Intent i = new Intent(CommonBugsActivity.this, CommonBugsResultActivity.class);
        startActivity(i);
    }

    public void XSSListener(View view) {
        Intent i = new Intent(CommonBugsActivity.this, CommonBugsResultActivity.class);
        startActivity(i);
    }
}