package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="au.edu.unsw.infs3634.beers.MESSAGE";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // Directing users to a specific page depending on which icon they click on the navigation bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Settings.class));
            }
        });

        ApplicationStepsAdapter.RecyclerViewClickListener listener = new ApplicationStepsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchApplicationSteps(position);
            }
        };
        mAdapter = new ApplicationStepsAdapter(ApplicationDatabase.getApplicationDatabase(), listener);
        mRecyclerView.setAdapter(mAdapter);
        setTitle("Welcome to Your Dashboard, Hamid");

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.getAchievementStatus("Home, Sweet, Home")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_home);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Home, Sweet, Home");

            Toast toast = new Toast(this);
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Home, Sweet, Home");
        }
    }

    private void launchApplicationSteps(int position) {
        final Intent intent;
        if (position == 0) {
            intent = new Intent(this, Step1Application.class);
            startActivity(intent);
        } else if (position == 1) {
            intent = new Intent(this, Step2PsychBehavioural.class);
            startActivity(intent);
        } else if (position == 2) {
            intent = new Intent(this, Step2PsychCognitive.class);
            startActivity(intent);
        } else if (position == 3) {
            intent = new Intent(this, Step2PsychNumerical.class);
            startActivity(intent);
        } else if (position == 4) {
            intent = new Intent(this, Step3VideoInterview.class);
            startActivity(intent);
        } else if (position == 5) {
            intent = new Intent(this, Step4Acentre.class);
            startActivity(intent);
//        } else if (position == 7) {
//            intent = new Intent(this, Step4AcentreInterview.class);
//            startActivity(intent);
        } else if (position == 6) {
            intent = new Intent(this, Step5Outcome.class);
            startActivity(intent);
        } else if (position == 7) {
            intent = new Intent(this, Step6FirstDay.class);
            startActivity(intent);
        } else if (position == 8) {
            intent = new Intent(this, OtherNetworking.class);
            startActivity(intent);
        } else if (position == 9) {
            intent = new Intent(this, OtherCareerOpp.class);
            startActivity(intent);
        }
    }}

