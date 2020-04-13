package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Vector;

public class Step3VideoInterview extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<Step3aVideos> step3aVideos = new Vector<>();

    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3_video_interview);

        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rfhBSdfeSXU\" frameborder=\"0\" allowfullscreen></iframe>") );
        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/umQKkcBPL08&t\" frameborder=\"0\" allowfullscreen></iframe>") );
        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/aevCwBCYWtY\" frameborder=\"0\" allowfullscreen></iframe>") );
        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1FAmKu13pS0&t\" frameborder=\"0\" allowfullscreen></iframe>") );
        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/J2VnJOw5Cd0\" frameborder=\"0\" allowfullscreen></iframe>") );
        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/64x880PzZ9k\" frameborder=\"0\" allowfullscreen></iframe>") );
        step3aVideos.add(new Step3aVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qRQDL9HQErk\" frameborder=\"0\" allowfullscreen></iframe>") );





        Step3aAdapter step3aAdapter = new Step3aAdapter(step3aVideos);

        recyclerView.setAdapter(step3aAdapter);



        setTitle("Step 3: Video Interview");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3VideoInterview.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3VideoInterview.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Step3VideoInterview.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3VideoInterview.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3VideoInterview.this, Settings.class));
            }
        });



    }
}
