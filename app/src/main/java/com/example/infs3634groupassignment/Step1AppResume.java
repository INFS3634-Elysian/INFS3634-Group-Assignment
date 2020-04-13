package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Step1AppResume extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;
    private TextView info1;
    private TextView info2;
    private TextView info3;
    private TextView title1;
    private TextView title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1_app_resume);
        setTitle("Step 1: Application- Resume");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppResume.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppResume.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppResume.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppResume.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppResume.this, Settings.class));
            }
        });

        info1 = findViewById(R.id.txvPart1);
        info2 = findViewById(R.id.txvPart2);
        info3 = findViewById(R.id.txvPart3);
        title1 = findViewById(R.id.txvTitle1);
        title2 = findViewById(R.id.txvTitle2);

        String info1String = "A <b>résumé</b> or resume is a document used and created by a person to present their <b>background, skills, and accomplishments</b>.";
        String info2String = "Résumés can be used for a variety of reasons, but most often they are used to <b>secure new employment</b>.";
        String info3String = "A typical résumé contains a \"summary\" of <b>relevant job experience and education</b>. The résumé is usually one of the first items, along with a cover letter and sometimes an application for employment, which a potential employer sees regarding the job seeker and is <b>typically used to screen applicants</b>, often followed by an interview. ";
        String title1String = "<b>What is a résumé?</b>";
        String title2String = "<b>Why do we need résumés?</b>";

        info1.setText(Html.fromHtml(info1String));
        info2.setText(Html.fromHtml(info2String));
        info3.setText(Html.fromHtml(info3String));
        title1.setText(Html.fromHtml(title1String));
        title2.setText(Html.fromHtml(title2String));

    }
}
