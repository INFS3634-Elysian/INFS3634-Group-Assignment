package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Step4AcentreInterview extends AppCompatActivity {

    RecyclerView recyclerView;
    int[] images;
    String[] description;
    String[] groupacURL;


    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4_acentre_interview);

        recyclerView = findViewById(R.id.recyclerView);
        images = new int[]{R.drawable.aci_1, R.drawable.aci_2, R.drawable.aci_3, R.drawable.aci_4, R.drawable.aci_5};
        description = new String[]{
                "Recruitment Process at Macquarie",
                "PwC's Interview preparation",
                "Deloitte's 6 Interview Mistakes",
                "Salesforce Interview Tips",
                "Google's Interview Process"




        };
        groupacURL = new String[]{
                "https://www.macquarie.com/au/en/careers/recruitment-process.html",
                "https://www.pwc.com/us/en/careers/entry-level/internships/interview-preparation.html",
                "https://www2.deloitte.com/tz/en/pages/careers/articles/sixmistakes.html",
                "https://www.salesforce.com/company/careers/candidate-resources/interview-tips/",
                "https://careers.google.com/how-we-hire/interview/"


        };

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Step4AcentreInterview.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Step4bAdapter step4bAdapter = new Step4bAdapter(Step4AcentreInterview.this, images, description, groupacURL);
        recyclerView.setAdapter(step4bAdapter);





        setTitle("Step 4: Assessment Centre- Interview");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreInterview.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreInterview.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreInterview.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreInterview.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreInterview.this, Settings.class));
            }
        });
    }
}
