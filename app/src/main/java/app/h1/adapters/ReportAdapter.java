package app.h1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.h1.R;
import app.h1.models.Report;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportHolder> {

    private Context context;
    private List<Report> reportList;

    public ReportAdapter(Context context, List<Report> reports) {
        this.context = context;
        this.reportList = reports;
    }

    @NonNull
    @Override
    public ReportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new ReportHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportHolder holder, int position) {
        Report report = reportList.get(position);
        holder.title.setText((report.getTitle().toString()));
        holder.reported_by.setText(report.getReported_by().toString());
        holder.program.setText(report.getProgram().toString());
        holder.disclose_date.setText(report.getDisclose_date());
        Glide.with(context).load(report.getImg()).into(holder.imageView);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public static class ReportHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, reported_by, program, disclose_date;
        ConstraintLayout constraintLayout;

        public ReportHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewProgram);
            title = itemView.findViewById(R.id.textViewTitle);
            reported_by = itemView.findViewById(R.id.textViewReporterName);
            program = itemView.findViewById(R.id.textViewProgramName);
            disclose_date = itemView.findViewById(R.id.textViewDay);
            constraintLayout = itemView.findViewById(R.id.main_layout);

        }
    }
}
