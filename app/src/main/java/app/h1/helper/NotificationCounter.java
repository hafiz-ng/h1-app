package app.h1.helper;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import org.w3c.dom.Text;

import app.h1.R;

public class NotificationCounter {
    public Context context;
    private CardView cardView;
    private TextView notificationNumber;
    private final int MAX_NUMBER = 9;
    private int notification_number_counter = 0;

    public NotificationCounter(View view) {
        notificationNumber = view.findViewById(R.id.textViewNotification);
        cardView = view.findViewById(R.id.cardViewNotification);
    }

    public void increaseNumber() {
        notification_number_counter++;

        if(notification_number_counter > MAX_NUMBER) {
//            Toast.makeText(context, "Maximum number reach", Toast.LENGTH_SHORT).show();
        } else {
            notificationNumber.setText(String.valueOf(notification_number_counter));
        }
    }


}
