package app.h1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.h1.R;
import app.h1.helper.NotificationCounter;

public class NotificationFragment extends Fragment {

    NotificationCounter notificationCounter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

//        notificationCounter = new NotificationCounter(view.findViewById(R.id.textViewNotification));

        return view;
    }

//    public void increaseNotificationNum(View view) {
//        notificationCounter.increaseNumber();
//    }
}