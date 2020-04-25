package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Step2PsychNumerical extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    //INSTANTIATING VARIABLES
    DatabaseHelper databaseHelper;
    String TAG = "Main_Activity";
    String setQNumerical = "";
    String setANumerical = "";
    String setO1Numerical = "";
    String setO2Numerical = "";
    String setO3Numerical = "";
    int btnIdNumerical;
    int counterNumerical = 0;
    int cCounterNumerical = 0;
    TextView questionNumerical, feedbackNumerical, scoreNumerical, progressNumerical;
    RadioButton optionANumerical, optionBNumerical, optionCNumerical, optionDNumerical;
    RadioButton selectedOptionNumerical;
    RadioGroup groupNumerical;
    Button submitNumerical, nextNumerical, tryAgainNumerical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2_psych_numerical);
        setTitle("Step 2: Psychometric Test- Numerical");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychNumerical.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychNumerical.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychNumerical.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychNumerical.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychNumerical.this, Settings.class));
            }
        });

        //FINDING COMPONENTS ONCE
        progressNumerical = findViewById(R.id.txvQNoNumerical);

        //INSTANTIATE DB HELPER
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        //SHOW ACHIEVEMENT
        if (databaseHelper.getAchievementStatus("Completed: Numerical Tests")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_numerical);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Completed: Numerical Tests");

            Toast toast = new Toast(this);
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Completed: Numerical Tests");
        }
        //CALLING FIRST INSTANCE OF QUESTION
        createQ();

        //SUBMIT CLICK LISTENER; if btn == checkedOption, CORRECT
        submitNumerical = findViewById(R.id.btnSubmitNumerical);
        submitNumerical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitCheck();
            }
        });

        //NEXT QUESTION CLICK LISTENER; essentially calls method: createQ again
        nextNumerical = findViewById(R.id.btnNextNumerical);
        nextNumerical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createQ();
            }
        });

        //TRY AGAIN CLICK LISTENER; resets quiz
        tryAgainNumerical = findViewById(R.id.btnTryAgainNumerical);
        tryAgainNumerical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryAgain();
            }
        });
    }

    //CREATE QUESTION METHOD; FUNCTIONS: counts question progress, sets question and answers via getQuestion() and getOptionN(), resets previous selections, deduces correct option via if-else
    public void createQ() {
        //INSTANTIATE DB HELPER
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        //INCREASE QUESTION COUNT ANSWERED
        counterNumerical++;
        progressNumerical.setText("Question: " + counterNumerical + " of 3");

        //SET QUESTION
        setQNumerical = databaseHelper.getQuestionNumerical();
        questionNumerical = findViewById(R.id.txvQuestionNumerical);
        questionNumerical.setText(setQNumerical);

        //SET ANSWERS
        setANumerical = databaseHelper.getAnswerNumerical();
        setO1Numerical = databaseHelper.getOption1Numerical();
        setO2Numerical = databaseHelper.getOption2Numerical();
        setO3Numerical = databaseHelper.getOption3Numerical();

        //RESET SELECTIONS
        optionANumerical = findViewById(R.id.rbnOptionANumerical);
        optionBNumerical = findViewById(R.id.rbnOptionBNumerical);
        optionCNumerical = findViewById(R.id.rbnOptionCNumerical);
        optionDNumerical = findViewById(R.id.rbnOptionDNumerical);

        submitNumerical = findViewById(R.id.btnSubmitNumerical);
        nextNumerical = findViewById(R.id.btnNextNumerical);
        tryAgainNumerical = findViewById(R.id.btnTryAgainNumerical);


        optionANumerical.setChecked(false);
        optionBNumerical.setChecked(false);
        optionCNumerical.setChecked(false);
        optionDNumerical.setChecked(false);

        optionANumerical.setEnabled(true);
        optionBNumerical.setEnabled(true);
        optionCNumerical.setEnabled(true);
        optionDNumerical.setEnabled(true);

        submitNumerical.setEnabled(true);
        nextNumerical.setEnabled(false);
        View nextView = findViewById(R.id.btnNextNumerical);
        nextView.setVisibility(View.INVISIBLE);
        tryAgainNumerical.setEnabled(false);
        View tryAgainView = findViewById(R.id.btnTryAgainNumerical);
        tryAgainView.setVisibility(View.GONE);


        int correct = (int) Math.floor(Math.random() * 4);
        Log.d(TAG, "OnCorrect: " + correct);

        if (correct == 0) {
            optionANumerical.setText(setANumerical);
            optionBNumerical.setText(setO1Numerical);
            optionCNumerical.setText(setO2Numerical);
            optionDNumerical.setText(setO3Numerical);
            btnIdNumerical = findViewById(R.id.rbnOptionANumerical).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        } else if (correct == 1) {
            optionANumerical.setText(setO1Numerical);
            optionBNumerical.setText(setANumerical);
            optionCNumerical.setText(setO2Numerical);
            optionDNumerical.setText(setO3Numerical);
            btnIdNumerical = findViewById(R.id.rbnOptionBNumerical).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        } else if (correct == 2) {
            optionANumerical.setText(setO2Numerical);
            optionBNumerical.setText(setO1Numerical);
            optionCNumerical.setText(setANumerical);
            optionDNumerical.setText(setO3Numerical);
            btnIdNumerical = findViewById(R.id.rbnOptionCNumerical).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        } else {
            optionANumerical.setText(setO2Numerical);
            optionBNumerical.setText(setO1Numerical);
            optionCNumerical.setText(setO3Numerical);
            optionDNumerical.setText(setANumerical);
            btnIdNumerical = findViewById(R.id.rbnOptionDNumerical).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        }

        Log.d(TAG, "CorrectOptionId: " + btnIdNumerical);
    }

    //SUBMIT CHECKING METHOD; FUNCTIONS: disables retry upon submission, verifies answer, checks for quiz completion
    public void submitCheck() {
        //ALLOW GROUP TO BE ACCESSED
        groupNumerical = findViewById(R.id.rgpOptionsNumerical);



        //VERIFY ANSWER
        try {
            int checkedOption = groupNumerical.getCheckedRadioButtonId();
            selectedOptionNumerical = findViewById(checkedOption);
            Log.d(TAG, "CheckedOptionId: " + checkedOption);
            Log.d(TAG, "Checked Option: " + selectedOptionNumerical.getText());

            if (checkedOption == btnIdNumerical) {
                Toast.makeText(getApplicationContext(), "Great Work!", Toast.LENGTH_LONG).show();
                cCounterNumerical++;
            } else {
                Toast.makeText(getApplicationContext(), "That wasn't quite right", Toast.LENGTH_LONG).show();
            }

            //DISABLE RETRY
            optionANumerical.setEnabled(false);
            optionBNumerical.setEnabled(false);
            optionCNumerical.setEnabled(false);
            optionDNumerical.setEnabled(false);

            nextNumerical = findViewById(R.id.btnNextNumerical);
            nextNumerical.setEnabled(true);
            View nextView = findViewById(R.id.btnNextNumerical);
            nextView.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "submitCheck: You did not submit an option");
            Toast.makeText(getApplicationContext(), "Please select an option first", Toast.LENGTH_LONG).show();
        }

        //IF QUIZ COMPLETED
        if (counterNumerical == 3) {
            submitNumerical = findViewById(R.id.btnSubmitNumerical);
            submitNumerical.setEnabled(false);
            nextNumerical = findViewById(R.id.btnNextNumerical);
            nextNumerical.setEnabled(false);
            View nextView = findViewById(R.id.btnNextNumerical);
            nextView.setVisibility(View.GONE);
            tryAgainNumerical = findViewById(R.id.btnTryAgainNumerical);
            tryAgainNumerical.setEnabled(true);
            View tryAgainView = findViewById(R.id.btnTryAgainNumerical);
            tryAgainView.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), "Final Score: " + cCounterNumerical + "/3", Toast.LENGTH_LONG).show();

            if (cCounterNumerical == 3) {
                final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                if (databaseHelper.getAchievementStatus("A Behavioural Hero!")) {

                } else {
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.toast_layout,
                            (ViewGroup)findViewById(R.id.relativeLayout1));
                    ImageView image = view.findViewById(R.id.imvImage);
                    image.setImageResource(R.drawable.ach_star);
                    TextView text = view.findViewById(R.id.textView2);
                    text.setText("A Numerical Hero!");

                    Toast toast = new Toast(getApplicationContext());
                    toast.setView(view);
                    toast.show();

                    databaseHelper.setAchievementStatus("A Numerical Hero!");
                }
            }
        }
    }

    //TRY AGAIN METHOD; FUNCTIONS: resets quiz progress to first question, resets previous selections
    public void tryAgain() {
        //RESET QUIZ PROGRESS
        counterNumerical= 1;
        cCounterNumerical = 0;

        //RESET VARIABLES
        optionANumerical = findViewById(R.id.rbnOptionANumerical);
        optionBNumerical = findViewById(R.id.rbnOptionBNumerical);
        optionCNumerical = findViewById(R.id.rbnOptionCNumerical);
        optionDNumerical = findViewById(R.id.rbnOptionDNumerical);

        submitNumerical = findViewById(R.id.btnSubmitNumerical);
        nextNumerical = findViewById(R.id.btnNextNumerical);
        tryAgainNumerical = findViewById(R.id.btnTryAgainNumerical);


        optionANumerical.setChecked(false);
        optionBNumerical.setChecked(false);
        optionCNumerical.setChecked(false);
        optionDNumerical.setChecked(false);

        optionANumerical.setEnabled(true);
        optionBNumerical.setEnabled(true);
        optionCNumerical.setEnabled(true);
        optionDNumerical.setEnabled(true);

        submitNumerical.setEnabled(true);
        nextNumerical.setEnabled(false);
        tryAgainNumerical.setEnabled(false);
        View tryAgainView = findViewById(R.id.btnTryAgainNumerical);
        tryAgainView.setVisibility(View.INVISIBLE);


        progressNumerical.setText("Question: " + counterNumerical + " of 3");
    }
}
