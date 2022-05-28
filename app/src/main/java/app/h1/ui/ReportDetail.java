package app.h1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import app.h1.MainActivity;
import app.h1.R;

public class ReportDetail extends AppCompatActivity {

    ImageView imageView;
    Button readReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);
        imageView = findViewById(R.id.back);
        readReport = findViewById(R.id.buttonReadReport);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReportDetail.this, MainActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView = findViewById(R.id.imageView);
        TextView title = findViewById(R.id.textViewTitle);
        TextView reported_by = findViewById(R.id.textViewReportedBy);
        TextView program_name = findViewById(R.id.textViewProgramName);
        TextView disclosed_date = findViewById(R.id.textViewDisclosedDate);
        TextView severity_result = findViewById(R.id.textViewSeverityResult);
        TextView bounty_amount = findViewById(R.id.textViewBountyAmount);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mReportedBy = bundle.getString("reported_by");
        String mProgram = bundle.getString("program");
        String mDiscloseDate = bundle.getString("disclose_date");
        String mId = bundle.getString("id");


        readReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://hackerone.com/reports/" + mId;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        title.setText(mTitle);
        reported_by.setText(mReportedBy);
        program_name.setText(mProgram);
        disclosed_date.setText(mDiscloseDate);

        Toast.makeText(ReportDetail.this, "Report ID: " + mId, Toast.LENGTH_SHORT).show();
        String report_url = "https://api.hackerone.com/v1/reports/";

    }

}