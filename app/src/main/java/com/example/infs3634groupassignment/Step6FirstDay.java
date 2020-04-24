package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Step6FirstDay extends AppCompatActivity {

    // Declaring variables that will be used in this activity
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    private ImageView wear;
    private ImageView bring;
    private ImageView say;
    private ImageView other;
    private TextView finalText;
    private View divider;
    private TextView finalText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step6_first_day);
        setTitle("Step 6: First Day of Work");

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.getAchievementStatus("Completed: First Day")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_firstday);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Completed: First Day");

            Toast toast = new Toast(this);
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Completed: First Day");
        }

        home = findViewById(R.id.ivHome);
        trophy = findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        // Linking java and xml attributes
        wear = (ImageView) findViewById(R.id.ivApp);
        bring = (ImageView) findViewById(R.id.ivTeam);
        say = (ImageView) findViewById(R.id.ivPrivacy);
        other = (ImageView) findViewById(R.id.ivAccount);
        finalText = findViewById(R.id.tvFinal);
        divider = findViewById(R.id.divider);
        finalText2 = findViewById(R.id.tvFinal2);



        // Setting the final text and divider to be invisible for the meantime. It will reappear once the user clicks on one of the four "What to..." images.
        finalText.setVisibility(View.INVISIBLE);
        divider.setVisibility(View.INVISIBLE);

        // Directs users to a specific page depending on which icon they click on the navigation bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step6FirstDay.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step6FirstDay.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step6FirstDay.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step6FirstDay.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step6FirstDay.this, Settings.class));
            }
        });

        // Upon clicking the What to Wear image, set the final text and divider to be visible and display specific text.
        wear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finalText.setVisibility(View.VISIBLE);
                finalText.setText("What to Wear");
                divider.setVisibility(View.VISIBLE);
                finalText2.setText("What you wear will strongly depend on your team and the overall culture at your firm. But for most cases, the safest option will tend to be business professional attire. \n" +
                        "For men, that's a suit and tie \n" +
                        "For women, that's a blazer and dress shoes");

            }
        });

        // Upon clicking the What to Bring image, set the final text and divider to be visible and display specific text.
        bring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("What to Bring");
                divider.setVisibility(View.VISIBLE);
                finalText2.setText("There is no need to bring a luggage of personal items to your first day at work. Keep it to the essentials and you'll start your new job on the right note. A few of these essentials include:" +
                        "- The classic notepad and pen\n" +
                        "- Additional paperwork (if requested)\n" +
                        "- ID card or other documents that verify your identity\n" +
                        "- And of course, the right attitude\n");
            }
        });

        // Upon clicking the What to Say image, set the final text and divider to be visible and display specific text.
        say.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("What to Say");
                divider.setVisibility(View.VISIBLE);
                finalText2.setText("It is important that you be yourself and be natural when conversing with your team and others at the firm. Remember, your employer's impression of you is who you presented at the interview!" +
                        "- Prepare a personal speech as you will be meeting many new people \n" +
                        "- Actively listen so you are able to engage with the conversation\n" +
                        "- Collate a couple of small talk topics or questions in the case that you are stuck for words because of nerves!");
            }
        });

        // Upon clicking the Other image, set the final text and divider to be visible and display specific text.
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalText.setVisibility(View.VISIBLE);
                finalText.setText("Other");
                divider.setVisibility(View.VISIBLE);
                finalText2.setText(
                        "- Remember the names of those you meet\n" +
                                "- Grab a coffee with your team and get to know them\n" +
                                "- Accept that lunch invitation\n" +
                                "- Keep in contact with other candidates you met during the recruitment process\n"
                );
            }
        });
    }
}
