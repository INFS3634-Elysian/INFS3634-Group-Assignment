package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Step1Application extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1_application);
        setTitle("Step 1: Application");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Settings.class));
            }
        });

        btn1 = findViewById(R.id.btnRe);
        btn2 = findViewById(R.id.btnCV);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Step1AppResume.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1Application.this, Step1AppCv.class));
            }
        });
    }
}
