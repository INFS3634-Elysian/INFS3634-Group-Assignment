package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView tv10;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5_outcome_offer);
        setTitle("Step 5: Final Outcome");

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.getAchievementStatus("You did it!")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_success);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("You did it!");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("You did it!");
        }


        // Linking java and xml attributes
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);
        offer = findViewById(R.id.btnOffer);
        rejection =findViewById(R.id.btnRejection);
        summary = findViewById(R.id.tvSummary);
        tv10 = findViewById(R.id.tv10);

        String text1 = ("After weeks (and perhaps even <b>months</b>) of hard work spent on polishing your resume, completing psychometric tests and attending interviews, <b>you are finally contacted by your recruiter...</b>");
        summary.setText(Html.fromHtml(text1));
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
