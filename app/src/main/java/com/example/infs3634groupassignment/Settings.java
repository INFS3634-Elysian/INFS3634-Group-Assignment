package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    // Declaring variables that will be used in this activity
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    private ImageView app;
    private ImageView team;
    private ImageView privacy;
    private ImageView account;
    private View divider;
    private TextView finalText;
    private TextView finalText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");
        // Linking java and xml attributes
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);
        app = findViewById(R.id.ivApp);
        team = findViewById(R.id.ivTeam);
        privacy = findViewById(R.id.ivPrivacy);
        account = findViewById(R.id.ivAccount);
        finalText = findViewById(R.id.tvFinal);
        divider = findViewById(R.id.divider);
        finalText2 = findViewById(R.id.tvFinal2);

        // Setting the final text and divider to be invisible for the meantime. It will reappear once the user clicks on one of the four "What to..." images.
        finalText.setVisibility(View.INVISIBLE);
        divider.setVisibility(View.INVISIBLE);

        // Upon clicking the About the App image, set the final text and divider to be visible and display specific text.
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("About the App");
                divider.setVisibility(View.VISIBLE);
                String text2 =  ("XYZ aims to add value to the wider UNSW community by providing a <b>one-stop-shop solution</b> that prepares them for <b>every step of the recruitment process</b>. Whilst the recruitment process differs across firms and industries, the scope of XYZ will ensure <b>complete coverage of all possible stages</b>." +
                        "<br />" +
                        "This will begin from the initial application stage which requires a submission of a resume and cover letter, to all types of psychometric tests, and to the student’s first day of work." +
                        "<br />" +
                        "With the founders being UNSW students who have gone through the same process, the <b>personal touch to the application</b> coupled with the use of <b>external resources from industry professionals</b>, we hope to provide UNSW students with a uniquely tailored application that facilitates learning through well-developed resources, tests and other functions"
                );
                finalText2.setText(Html.fromHtml(text2));
                           }
        });

        // Upon clicking the About the Team image, set the final text and divider to be visible and display specific text.
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("About the Team");
                divider.setVisibility(View.VISIBLE);
                String text2 = ("Our team consists of the following four founders who together, designed and developed the application:" +
                        "<br /><br /><b>Cathy Liang</b> | Bachelor of Commerce and Bachelor of Information Systems at UNSW" +
                        "<br /><b>Jasen Yu</b> | Bachelor of Commerce and Bachelor of Information Systems at UNSW" +
                        "<br /><b>Sandra Ma</b> | Bachelor of Commerce and Bachelor of Information Systems at UNSW" +
                        "<br /><b>Truman Ng</b> | Bachelor of Commerce and Bachelor of Information Systems at UNSW" +
                        "<br /><br /> If you'd like to contact our team, please visit our website: elysian.co"
                );
                finalText2.setText(Html.fromHtml(text2));

                final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                if (databaseHelper.getAchievementStatus("Meet the team!")) {

                } else {
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.toast_layout,
                            (ViewGroup)findViewById(R.id.relativeLayout1));
                    ImageView image = view.findViewById(R.id.imvImage);
                    image.setImageResource(R.drawable.ach_team);
                    TextView text = view.findViewById(R.id.textView2);
                    text.setText("Meet the team!");

                    Toast toast = new Toast(getApplicationContext());
                    toast.setView(view);
                    toast.show();

                    databaseHelper.setAchievementStatus("Meet the team!");
                }
            }
        });

        // Upon clicking the Privacy Policy image, set the final text and divider to be visible and display specific text.
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("Privacy Policy");
                divider.setVisibility(View.VISIBLE);
                finalText2.setText("Your privacy is our #1 priority. As such, all user information obtained from the use of this app will not be shared with anyone unless the user provides consent.");
            }
        });

        // Upon clicking the My Account image, set the final text and divider to be visible and display specific text.
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("My Account");
                divider.setVisibility(View.VISIBLE);
                finalText2.setText("Your Account Name: Hamid\n" +
                        "Your password: **********");
            }
        });

        // Directing users to a specific page depending on which icon they click on the navigation bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Settings.class));
            }
        });

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        if (databaseHelper.getAchievementStatus("Set your settings")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_settings);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Set your settings");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Set your settings");
        }
    }
}
