package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Step2PsychBehavioural extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    //INSTANTIATING VARIABLES
    DatabaseHelper databaseHelper;
    String TAG = "Main_Activity";
    String setQ = "";
    String setA = "";
    String setO1 = "";
    String setO2 = "";
    String setO3 = "";
    int btnId;
    int counter = 0;
    int cCounter = 0;
    TextView question, feedback, score, progress;
    RadioButton optionA, optionB, optionC, optionD;
    RadioButton selectedOption;
    RadioGroup group;
    Button submit, next, tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2_psych_behavioural);
        setTitle("Step 2: Psychometric Test- Behavioural");

        //NAV BAR FUNCTIONS
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychBehavioural.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychBehavioural.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychBehavioural.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychBehavioural.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychBehavioural.this, Settings.class));
            }
        });

        //INSTANTIATE DB HELPER
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        //CALLING FIRST INSTANCE OF QUESTION
        createQ();

        //SUBMIT CLICK LISTENER; if btn == checkedOption, CORRECT
        submit = findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitCheck();
            }
        });

        //NEXT QUESTION CLICK LISTENER; essentially calls method: createQ again
        next = findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createQ();
            }
        });

        //TRY AGAIN CLICK LISTENER; resets quiz
        tryAgain = findViewById(R.id.btnTryAgain);
        tryAgain.setOnClickListener(new View.OnClickListener() {
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
        counter++;
        progress = findViewById(R.id.txvQNo);
        progress.setText(counter + "/3");

        //SET QUESTION
        setQ = databaseHelper.getQuestion();
        question = findViewById(R.id.txvQuestion);
        question.setText(setQ);

        //SET ANSWERS
        setA = databaseHelper.getAnswer();
        setO1 = databaseHelper.getOption1();
        setO2 = databaseHelper.getOption2();
        setO3 = databaseHelper.getOption3();

        //RESET SELECTIONS
        optionA = findViewById(R.id.rbnOptionA);
        optionB = findViewById(R.id.rbnOptionB);
        optionC = findViewById(R.id.rbnOptionC);
        optionD = findViewById(R.id.rbnOptionD);

        submit = findViewById(R.id.btnSubmit);
        next = findViewById(R.id.btnNext);
        tryAgain = findViewById(R.id.btnTryAgain);


        optionA.setChecked(false);
        optionB.setChecked(false);
        optionC.setChecked(false);
        optionD.setChecked(false);

        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);

        submit.setEnabled(true);
        next.setEnabled(false);
        tryAgain.setEnabled(false);
        View tryAgainView = findViewById(R.id.btnTryAgain);
        tryAgainView.setVisibility(View.INVISIBLE);


        int correct = (int) Math.floor(Math.random() * 4);
        Log.d(TAG, "OnCorrect: " + correct);

        if (correct == 0) {
            optionA.setText(setA);
            optionB.setText(setO1);
            optionC.setText(setO2);
            optionD.setText(setO3);
            btnId = findViewById(R.id.rbnOptionA).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        } else if (correct == 1) {
            optionA.setText(setO1);
            optionB.setText(setA);
            optionC.setText(setO2);
            optionD.setText(setO3);
            btnId = findViewById(R.id.rbnOptionB).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        } else if (correct == 2) {
            optionA.setText(setO2);
            optionB.setText(setO1);
            optionC.setText(setA);
            optionD.setText(setO3);
            btnId = findViewById(R.id.rbnOptionC).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        } else {
            optionA.setText(setO2);
            optionB.setText(setO1);
            optionC.setText(setO3);
            optionD.setText(setA);
            btnId = findViewById(R.id.rbnOptionD).getId();
            Log.d(TAG, "CorrectAnswer: " + correct);
        }

        Log.d(TAG, "CorrectOptionId: " + btnId);
    }

    //SUBMIT CHECKING METHOD; FUNCTIONS: disables retry upon submission, verifies answer, checks for quiz completion
    public void submitCheck() {
        //ALLOW GROUP TO BE ACCESSED
        group = findViewById(R.id.rgpOptions);

        //DISABLE RETRY
        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);

        next = findViewById(R.id.btnNext);
        next.setEnabled(true);

        //VERIFY ANSWER
        int checkedOption = group.getCheckedRadioButtonId();
        selectedOption = findViewById(checkedOption);
        Log.d(TAG, "CheckedOptionId: " + checkedOption);
        Log.d(TAG, "Checked Option: " + selectedOption.getText());

        if (checkedOption == btnId) {
            feedback = findViewById(R.id.txvFeedback);
            feedback.setText("Great Job!");
            cCounter++;
        } else {
            feedback = findViewById(R.id.txvFeedback);
            feedback.setText("Terrible!");
        }



        //IF QUIZ COMPLETED
        if (counter == 3) {
            submit = findViewById(R.id.btnSubmit);
            submit.setEnabled(false);
            next = findViewById(R.id.btnNext);
            next.setEnabled(false);
            tryAgain = findViewById(R.id.btnTryAgain);
            tryAgain.setEnabled(true);
            View tryAgainView = findViewById(R.id.btnTryAgain);
            tryAgainView.setVisibility(View.VISIBLE);

            score = findViewById(R.id.txvScore);
            score.setText(cCounter + "/3");
        }
    }

    //TRY AGAIN METHOD; FUNCTIONS: resets quiz progress to first question, resets previous selections
    public void tryAgain() {
        //RESET QUIZ PROGRESS
        counter = 1;
        cCounter = 0;

        //RESET VARIABLES
        optionA = findViewById(R.id.rbnOptionA);
        optionB = findViewById(R.id.rbnOptionB);
        optionC = findViewById(R.id.rbnOptionC);
        optionD = findViewById(R.id.rbnOptionD);

        submit = findViewById(R.id.btnSubmit);
        next = findViewById(R.id.btnNext);
        tryAgain = findViewById(R.id.btnTryAgain);


        optionA.setChecked(false);
        optionB.setChecked(false);
        optionC.setChecked(false);
        optionD.setChecked(false);

        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);

        submit.setEnabled(true);
        next.setEnabled(false);
        tryAgain.setEnabled(false);
        View tryAgainView = findViewById(R.id.btnTryAgain);
        tryAgainView.setVisibility(View.INVISIBLE);

        progress = findViewById(R.id.txvQNo);
        progress.setText(counter + "/3");

        score = findViewById(R.id.txvScore);
        score.setText("");

    }
}
