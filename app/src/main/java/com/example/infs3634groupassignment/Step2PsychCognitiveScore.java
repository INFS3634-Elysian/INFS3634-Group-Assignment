package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Step2PsychCognitiveScore extends AppCompatActivity {

    private TextView finalScoreTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2_psych_cognitive_score);

        this.setTitle("Step2 - PsychCognitiveScore");
        int score = getIntent().getIntExtra("score",0);

        finalScoreTxt = findViewById(R.id.finalScoreTxt);
        finalScoreTxt.setText(Integer.toString(score));

    }
}
