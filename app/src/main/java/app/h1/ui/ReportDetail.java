package app.h1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.h1.R;

public class ReportDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);


        ImageView imageView = findViewById(R.id.imageView);
        TextView title = findViewById(R.id.textViewTitle);
        TextView reported_by = findViewById(R.id.textViewReportedBy);
        TextView program_name = findViewById(R.id.textViewProgramName);
        TextView disclosed_date = findViewById(R.id.textViewDisclosedDate);
        TextView severity_result = findViewById(R.id.textViewSeverityResult);
        TextView bounty_amount = findViewById(R.id.textViewBountyAmount);
        Button btn_report = findViewById(R.id.buttonReadReport);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mReportedBy = bundle.getString("reported_by");
        String mProgram = bundle.getString("program");
        String mDiscloseDate = bundle.getString("disclose_date");

        title.setText(mTitle);
        reported_by.setText(mReportedBy);
        program_name.setText(mProgram);
        disclosed_date.setText(mDiscloseDate);

        String report_url = "https://api.hackerone.com/v1/reports/";

    }
}