package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Step5OutcomeOffer extends AppCompatActivity {
    // Declaring variables that will be used in this activity
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;
    private Button offer;
    private Button rejection;
    private TextView summary;
    private TextView tv6;
    private TextView tv7;
    private TextView tv10;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5_outcome_offer);
        setTitle("Step 5: Final Outcome");
        // Linking java and xml attributes
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);
        offer = findViewById(R.id.btnOffer);
        rejection =findViewById(R.id.btnRejection);
        summary = findViewById(R.id.tvSummary);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv10 = findViewById(R.id.tv10);

        String text1 = ("After weeks (and perhaps even <b>months</b>) of hard work spent on polishing your resume, completing psychometric tests and attending interviews, <b>you are finally contacted by your recruiter...</b>");
        summary.setText(Html.fromHtml(text1));
        String text6 = ("The period between the day you receive your offer and your very first day at work <b>will differ firm to firm</b>. Though typically, you may expect the following:");
        tv6.setText(Html.fromHtml(text6));
        String text7 =("So a quick summary of <b> what to look out for in an employment contract </b>follows the below: ");
        tv7.setText(Html.fromHtml(text7));
        String text10 = ("A number of checks may be conducted to organise any necessary paperwork, verify your identity and prepare you for your first day. " +
                "\n\nAgain, <b>each firm has a different onboarding process</b>. However, you can expect to go through some of the following steps:");
        tv10.setText(Html.fromHtml(text10));




        // Directs users to a specific page depending on which icon they click on the navigation bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Settings.class));
            }
        });
        rejection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Step5OutcomeOffer.this, Step5OutcomeReject.class));
            }
        });
    }
}
