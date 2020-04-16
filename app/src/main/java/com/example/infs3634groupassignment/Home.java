package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="au.edu.unsw.infs3634.beers.MESSAGE";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ApplicationStepsAdapter.RecyclerViewClickListener listener = new ApplicationStepsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchApplicationSteps(position);
            }
        };
        mAdapter = new ApplicationStepsAdapter(ApplicationDatabase.getApplicationDatabase(), listener);
        mRecyclerView.setAdapter(mAdapter);
        setTitle("Welcome to Your Dashboard, Hamid");
    }

    private void launchApplicationSteps(int position) {
        final Intent intent;
        if (position == 0) {
            intent = new Intent(this, Step1AppResume.class);
            startActivity(intent);
        } else if (position == 1) {
            intent = new Intent(this, Step1AppCv.class);
            startActivity(intent);
        } else if (position == 2) {
            intent = new Intent(this, Step2PsychBehavioural.class);
            startActivity(intent);
        } else if (position == 3) {
            intent = new Intent(this, Step2PsychCognitive.class);
            startActivity(intent);
        } else if (position == 4) {
            intent = new Intent(this, Step2PsychNumerical.class);
            startActivity(intent);
        } else if (position == 5) {
            intent = new Intent(this, Step3VideoInterview.class);
            startActivity(intent);
        } else if (position == 6) {
            intent = new Intent(this, Step4AcentreGroup.class);
            startActivity(intent);
        } else if (position == 7) {
            intent = new Intent(this, Step4AcentreInterview.class);
            startActivity(intent);
        } else if (position == 8) {
            intent = new Intent(this, Step5Outcome.class);
            startActivity(intent);
        } else if (position == 9) {
            intent = new Intent(this, Step6FirstDay.class);
            startActivity(intent);
        } else if (position == 10) {
            intent = new Intent(this, OtherNetworking.class);
            startActivity(intent);
        } else if (position == 11) {
            intent = new Intent(this, OtherCareerOpp.class);
            startActivity(intent);
        }
    }}

