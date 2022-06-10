
package app.h1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import app.h1.MainActivity;
import app.h1.R;

public class Hacker101Activity extends AppCompatActivity {

    ImageView imageView;
    Button m_hacker101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacker101);
        imageView = findViewById(R.id.back);
        m_hacker101 =findViewById(R.id.buttonHacker101);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hacker101Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

        m_hacker101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hacker101_url = "https://www.hacker101.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(hacker101_url));
                startActivity(i);
            }
        });
    }
}