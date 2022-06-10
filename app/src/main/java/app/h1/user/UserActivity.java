package app.h1.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import app.h1.MainActivity;
import app.h1.R;
import app.h1.SignUpUser;

public class UserActivity extends AppCompatActivity {

    ImageView imageView, gotoMain, userDisplayPhoto;
    Button deleteUser;
    TextView userName;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        gotoMain = findViewById(R.id.back);
        imageView = findViewById(R.id.imageViewNext);
        deleteUser = findViewById(R.id.buttonDeleteUser);
        userName = findViewById(R.id.textViewUserName);
        userDisplayPhoto = findViewById(R.id.imageViewUser);


        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        Glide.with(UserActivity.this).load(user.getPhotoUrl()).into(userDisplayPhoto);
        userName.setText("Hello! " + user.getDisplayName());



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, ReadingList.class);
                startActivity(i);
            }
        });

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteUserDialog();
            }
        });


        gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void showDeleteUserDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.delete_user_alert, null);

        Button deleteButton = view.findViewById(R.id.buttonDeleteUser);
        Button noDelete = view.findViewById(R.id.buttonNo);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        alertDialog.show();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get instance of current user
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(UserActivity.this, "Account deleted", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(UserActivity.this, SignUpUser.class);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(UserActivity.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                    }
//                                    PD.dismiss();
                                }
                            });
                }
            }
        });

        noDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }

}