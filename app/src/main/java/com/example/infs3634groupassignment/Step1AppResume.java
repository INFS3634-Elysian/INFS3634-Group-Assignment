package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Step1AppResume extends AppCompatActivity {
    final Activity activity = this;
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
    private YouTubePlayerView video1;

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

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        if (databaseHelper.getAchievementStatus("Completed: Resumes")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_resume);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Completed: Resumes");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Completed: Resumes");
        }

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

        //Finding Components
        info1 = findViewById(R.id.txvPart1);
        info2 = findViewById(R.id.txvPart2);
        info3 = findViewById(R.id.txvPart3);
        title1 = findViewById(R.id.txvTitle1);
        title2 = findViewById(R.id.txvTitle2);

        //Creating Text to Set Components
        String info1String = "A <b>résumé</b> or resume is a document used and created by a person to present their <b>background, skills, and accomplishments</b>.";
        String info2String = "Résumés can be used for a variety of reasons, but most often they are used to <b>secure new employment</b>.";
        String info3String = "A typical résumé contains a \"summary\" of <b>relevant job experience and education</b>. The résumé is usually one of the first items, along with a cover letter and sometimes an application for employment, which a potential employer sees regarding the job seeker and is <b>typically used to screen applicants</b>, often followed by an interview. ";
        String title1String = "<b>What is a résumé?</b>";
        String title2String = "<b>Why do we need résumés?</b>";


        //Set Components
        info1.setText(Html.fromHtml(info1String));
        info2.setText(Html.fromHtml(info2String));
        info3.setText(Html.fromHtml(info3String));
        title1.setText(Html.fromHtml(title1String));
        title2.setText(Html.fromHtml(title2String));
        video1 = findViewById(R.id.ytvVideo1);
        getLifecycle().addObserver(video1);








    }
}
