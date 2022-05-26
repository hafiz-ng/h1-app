package app.h1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.h1.R;
import app.h1.adapters.ReportAdapter;
import app.h1.models.Report;
import app.h1.models.VolleySingleton;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Report> reportList;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        requestQueue = VolleySingleton.getmInstance(getContext()).getRequestQueue();
        reportList = new ArrayList<>();
        fetchReports();

        return view;
    }

    private void fetchReports() {


        String url = "https://api.hafiz.ng/hacktivity.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                String id = jsonObject.getString("id");
                                String title = jsonObject.getString("title");
                                String reported_by = jsonObject.getString("reported_by");
                                String program = jsonObject.getString("program");
                                String disclose_date = jsonObject.getString("disclose_date");
                                String img = jsonObject.getString("program_img");
                                Report report = new Report(id, title, reported_by, program, disclose_date, img);

                                Toast.makeText(getActivity(), "Report IDs: " + id, Toast.LENGTH_SHORT).show();
                                reportList.add(report);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            ReportAdapter adapter = new ReportAdapter(getActivity(), reportList);
                            recyclerView.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}