package app.h1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.h1.R;


public class BugsFragment extends Fragment {

    LinearLayout m_xss, m_ssrf, m_sqli, m_xxe, m_oauth, m_rce;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bugs, container, false);


        m_xss = view.findViewById(R.id.xss);
        m_ssrf = view.findViewById(R.id.ssrf);
        m_sqli = view.findViewById(R.id.sqli);
        m_xxe = view.findViewById(R.id.xxe);
        m_oauth = view.findViewById(R.id.oauth);
        m_rce = view.findViewById(R.id.rce);

        m_xss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "XSS Selected..", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).navigate(R.id.action_nav_bug_reports_to_reportDetailFragment);
            }
        });

        m_ssrf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_bug_reports_to_reportDetailFragment);
            }
        });

        return view;



    }

//    @Override
//    public void onClick(View v) {
//        Navigation.findNavController(v).navigate(R.id.action_nav_bug_reports_to_reportDetailFragment);
//    }
}