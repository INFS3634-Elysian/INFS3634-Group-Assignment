package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.getAchievementStatus("Completed: Cognitive Tests")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_cognitive);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Completed: Cognitive Tests");

            Toast toast = new Toast(this);
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Completed: Cognitive Tests");
        }
    }
}
