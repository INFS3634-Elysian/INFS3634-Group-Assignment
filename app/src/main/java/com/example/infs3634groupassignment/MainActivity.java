package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButtonSignIn;
    private Button mButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.deleteDatabase("behavioural.db");



        mButtonSignIn = findViewById(R.id.btnSignIn);
        mButtonSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Home.class));
                final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                if (databaseHelper.getAchievementStatus("The Journey Begins")) {

                } else {
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.toast_layout,
                            (ViewGroup)findViewById(R.id.relativeLayout1));
                    ImageView image = view.findViewById(R.id.imvImage);
                    image.setImageResource(R.drawable.ach_journey);
                    TextView text = view.findViewById(R.id.textView2);
                    text.setText("The Journey Begins");

                    Toast toast = new Toast(getApplicationContext());
                    toast.setView(view);
                    toast.show();

                    databaseHelper.setAchievementStatus("The Journey Begins");
                }
            }
        });
    }
}