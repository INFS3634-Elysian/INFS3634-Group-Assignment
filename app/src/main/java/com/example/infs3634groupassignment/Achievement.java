package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Achievement extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    private ProgressBar progress;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        setTitle("Achievements");

        //NavBar Functions
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Achievement.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Achievement.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Achievement.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Achievement.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Achievement.this, Settings.class));
            }
        });

        //Instantiation of DBHelper and Achievement

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        if (databaseHelper.getAchievementStatus("Achievements, so many Achievements...")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_achievements);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Achievements, so many Achievements...");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Achievements, so many Achievements...");
        }

        //Measure Individual and Overall Progress of achievements
        progress = findViewById(R.id.pgbAchProg);
        progress.setMax(21);

        for (int i = 1; i < 22; i++) {
            if (databaseHelper.getAchievementProgress(i)) {
                counter++;
            }
        }
        progress.setProgress(counter);
        TextView progressView = findViewById(R.id.txvProgress);
        progressView.setText("Current Progress: " + counter + " of 21");

        if (databaseHelper.getAchievementProgress(1)) {
            TextView txv = findViewById(R.id.txv1_1);
            txv.setText("The Journey Begins");
            TextView txv2 = findViewById(R.id.txv1_2);
            txv2.setText("Opened the App for the first time");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv1);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv1_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv1_2);
            txv2.setText("Try opening the App!");
        }

        if (databaseHelper.getAchievementProgress(2)) {
            TextView txv = findViewById(R.id.txv2_1);
            txv.setText("Completed: Resumes");
            TextView txv2 = findViewById(R.id.txv2_2);
            txv2.setText("Opened the Resume Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv2);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv =  findViewById(R.id.txv2_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv2_2);
            txv2.setText("Try opening the Resume Page!");
        }

        if (databaseHelper.getAchievementProgress(3)) {
            TextView txv = findViewById(R.id.txv3_1);
            txv.setText("Completed: Curriculum Vitae");
            TextView txv2 = findViewById(R.id.txv3_2);
            txv2.setText("Opened the CV Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv3);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv3_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv3_2);
            txv2.setText("Try opening the CV Page!");
        }

        if (databaseHelper.getAchievementProgress(4)) {
            TextView txv = findViewById(R.id.txv4_1);
            txv.setText("Completed: Behavioural Tests");
            TextView txv2 = findViewById(R.id.txv4_2);
            txv2.setText("Opened the Behavioural Tests Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv4);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv4_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv4_2);
            txv2.setText("Try opening the Behavioural Tests Page!");
        }

        if (databaseHelper.getAchievementProgress(5)) {
            TextView txv = findViewById(R.id.txv5_1);
            txv.setText("Completed: Cognitive Tests");
            TextView txv2 = findViewById(R.id.txv5_2);
            txv2.setText("Opened the Cognitive Test Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv5);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv5_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv5_2);
            txv2.setText("Try opening the Cognitive Tests Page!");
        }

        if (databaseHelper.getAchievementProgress(6)) {
            TextView txv = findViewById(R.id.txv6_1);
            txv.setText("Completed: Numerical Tests");
            TextView txv2 = findViewById(R.id.txv6_2);
            txv2.setText("Opened the Numerical Test Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv6);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv6_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv6_2);
            txv2.setText("Try opening the Numerical Tests Page!");
        }

        if (databaseHelper.getAchievementProgress(7)) {
            TextView txv = findViewById(R.id.txv7_1);
            txv.setText("Completed: Video Interviews");
            TextView txv2 = findViewById(R.id.txv7_2);
            txv2.setText("Opened the Video Interviews Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv7);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv7_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv7_2);
            txv2.setText("Try opening the Video Interview Page!");
        }

        if (databaseHelper.getAchievementProgress(8)) {
            TextView txv = findViewById(R.id.txv8_1);
            txv.setText("Completed: Group Work");
            TextView txv2 = findViewById(R.id.txv8_2);
            txv2.setText("Opened the Group Work Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv8);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv8_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv8_2);
            txv2.setText("Try opening the Group Work Page!");
        }

        if (databaseHelper.getAchievementProgress(9)) {
            TextView txv = findViewById(R.id.txv9_1);
            txv.setText("Completed: Personal Interviews");
            TextView txv2 = findViewById(R.id.txv9_2);
            txv2.setText("Opened the Personal Interviews Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv9);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv9_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv9_2);
            txv2.setText("Try opening the Personal Interviews Page!");
        }

        if (databaseHelper.getAchievementProgress(10)) {
            TextView txv = findViewById(R.id.txv10_1);
            txv.setText("Completed: Outcomes");
            TextView txv2 = findViewById(R.id.txv10_2);
            txv2.setText("Opened the Outcomes Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv10);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv10_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv10_2);
            txv2.setText("Try opening the Outcomes Page!");
        }

        if (databaseHelper.getAchievementProgress(11)) {
            TextView txv = findViewById(R.id.txv11_1);
            txv.setText("Completed: First Day");
            TextView txv2 = findViewById(R.id.txv11_2);
            txv2.setText("Opened the First Day Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv11);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv11_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv11_2);
            txv2.setText("Try opening the First Day Page!");
        }

        if (databaseHelper.getAchievementProgress(12)) {
            TextView txv = findViewById(R.id.txv12_1);
            txv.setText("Home, Sweet, Home");
            TextView txv2 = findViewById(R.id.txv12_2);
            txv2.setText("Opened the Home Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv7);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv12_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv12_2);
            txv2.setText("Try opening the Home Page!");
        }

        if (databaseHelper.getAchievementProgress(13)) {
            TextView txv = findViewById(R.id.txv13_1);
            txv.setText("Achievements, so many");
            TextView txv2 = findViewById(R.id.txv13_2);
            txv2.setText("Opened the Achievements Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv13);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv13_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv13_2);
            txv2.setText("Try opening the Achievements Page!");
        }

        if (databaseHelper.getAchievementProgress(14)) {
            TextView txv = findViewById(R.id.txv14_1);
            txv.setText("Time to take some notes");
            TextView txv2 = findViewById(R.id.txv14_2);
            txv2.setText("Opened the Notebook Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv14);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv14_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv14_2);
            txv2.setText("Try opening the Notebook Page!");
        }

        if (databaseHelper.getAchievementProgress(15)) {
            TextView txv = findViewById(R.id.txv15_1);
            txv.setText("Who am I?");
            TextView txv2 = findViewById(R.id.txv15_2);
            txv2.setText("Opened the Profile Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv15);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv15_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv15_2);
            txv2.setText("Try opening the Profile Page!");
        }

        if (databaseHelper.getAchievementProgress(16)) {
            TextView txv = findViewById(R.id.txv16_1);
            txv.setText("Set your settings");
            TextView txv2 = findViewById(R.id.txv16_2);
            txv2.setText("Opened the Settings Page");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv16);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv16_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv16_2);
            txv2.setText("Try opening the Settings Page!");
        }

        if (databaseHelper.getAchievementProgress(17)) {
            TextView txv = findViewById(R.id.txv17_1);
            txv.setText("Meet the team!");
            TextView txv2 = findViewById(R.id.txv17_2);
            txv2.setText("Find the Developers");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv17);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv17_1);
            txv.setText("Locked Achievement");
            TextView txv2 = findViewById(R.id.txv17_2);
            txv2.setText("Trying finding the Developers");
        }

        if (databaseHelper.getAchievementProgress(18)) {
            TextView txv = findViewById(R.id.txv18_1);
            txv.setText("A Behavioural Hero!");
            TextView txv2 = findViewById(R.id.txv18_2);
            txv2.setText("Mastered Behavioural Tests");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv18);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv18_1);
            txv.setText("Hidden Achievement");
            TextView txv2 = findViewById(R.id.txv18_2);
            txv2.setText("Details will be revealed when unlocked");
        }

        if (databaseHelper.getAchievementProgress(19)) {
            TextView txv = findViewById(R.id.txv19_1);
            txv.setText("A Cognitive Hero!");
            TextView txv2 = findViewById(R.id.txv19_2);
            txv2.setText("Mastered Cognitive Tests");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv19);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv19_1);
            txv.setText("Hidden Achievement");
            TextView txv2 = findViewById(R.id.txv19_2);
            txv2.setText("Details will be revealed when unlocked");
        }

        if (databaseHelper.getAchievementProgress(20)) {
            TextView txv = findViewById(R.id.txv20_1);
            txv.setText("You did it!");
            TextView txv2 = findViewById(R.id.txv20_2);
            txv2.setText("You have got a job!");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv20);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv20_1);
            txv.setText("Hidden Achievement");
            TextView txv2 = findViewById(R.id.txv20_2);
            txv2.setText("Details will be revealed when unlocked");
        }

        if (databaseHelper.getAchievementProgress(21)) {
            TextView txv = findViewById(R.id.txv21_1);
            txv.setText("Life goes on...");
            TextView txv2 = findViewById(R.id.txv21_2);
            txv2.setText("You didn't get the job...");
        } else {
            ImageView imv = (ImageView) findViewById(R.id.imv21);
            imv.setImageDrawable(getResources().getDrawable(R.drawable.ach_lock_l));
            TextView txv = findViewById(R.id.txv21_1);
            txv.setText("Hidden Achievement");
            TextView txv2 = findViewById(R.id.txv21_2);
            txv2.setText("Details will be revealed when unlocked");
        }

    }
}
