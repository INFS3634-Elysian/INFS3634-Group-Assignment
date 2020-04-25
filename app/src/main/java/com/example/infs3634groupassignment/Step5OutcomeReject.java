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

public class Step5OutcomeReject extends AppCompatActivity {
    // Declaring variables that will be used in this activity
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;
    private Button offer;
    private TextView summary;
    private TextView tv11;
    private TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5_outcome_reject);
        setTitle("Step 5: Final Outcome");

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.getAchievementStatus("Life goes on...")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_failure);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Life goes on...");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Life goes on...");
        }

        // Linking java and xml attributes
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);
        offer = findViewById(R.id.btnOffer);
        summary = findViewById(R.id.tvSummary);
        tv11= findViewById(R.id.tv11);
        tv6 = findViewById(R.id.tv6);

        String text1 = ("After weeks (and perhaps even <b>months</b>) of hard work spent on polishing your resume, completing psychometric tests and attending interviews, <b>you are finally contacted by your recruiter...</b>");
        summary.setText(Html.fromHtml(text1));
        String text11= ("So a quick summary: " +
                "<br />- Let it go and cry it out! " +
                "<br />- <b>Be honest with yourself</b> and ask yourself why you didn't receive the offer " +
                "<br />- Know that this just <b>wasn't the right opportunity</b>");
        tv11.setText(Html.fromHtml(text11));
        String text6= ("By sending a polite response to your recruiter, you'll already: " +
                "<br />- <b> Stand out </b> among the pool of others who ignored or deleted that rejection email " +
                "<br />- Demonstrate your ability to <b> respond to negative news well </b> and " +
                "<br />- Potentially <b> strengthen your professional relationship </b> with your recruiter");
        tv6.setText(Html.fromHtml(text6));

        // Directs users to a specific page depending on which icon they click on the navigation bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeReject.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeReject.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeReject.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeReject.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeReject.this, Settings.class));
            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeReject.this, Step5OutcomeOffer.class));
            }
        });
    }
}
