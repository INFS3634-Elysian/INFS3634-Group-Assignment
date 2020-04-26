package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Step4AcentreGroup extends AppCompatActivity {

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
        setContentView(R.layout.activity_step4_acentre_group);

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.getAchievementStatus("Completed: Group Work")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_groupwork);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Completed: Group Work");

            Toast toast = new Toast(this);
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Completed: Group Work");
        }

        recyclerView = findViewById(R.id.recyclerView);
        images = new int[]{R.drawable.ac_1, R.drawable.ac_2, R.drawable.ac_3, R.drawable.ac_4};
        description = new String[]{
                "KPMG AC Success Guide 2020",
                "How to ace assessment centre day",
                "Practice Group Exercises",
                "CommBank’s Assessment Centre Advice"

        };
        groupacURL = new String[]{
                "https://www.assessmentcentrehq.com/kpmg-assessment-centre/",
                "https://gradaustralia.com.au/interviews-and-assessments/how-to-ace-assessment-centre-day",
                "https://www.assessmentday.co.uk/assessmentcentre/group-exercises.html",
                "https://www.commbank.com.au/guidance/blog/attending-an-assessment-centre-201609.html"

        };

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Step4AcentreGroup.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Step4aAdapter step4aAdapter = new Step4aAdapter(Step4AcentreGroup.this, images, description, groupacURL);
        recyclerView.setAdapter(step4aAdapter);


        setTitle("Step 4: Assessment Centre- Group Work");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreGroup.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreGroup.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreGroup.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreGroup.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step4AcentreGroup.this, Settings.class));
            }
        });
    }
}
