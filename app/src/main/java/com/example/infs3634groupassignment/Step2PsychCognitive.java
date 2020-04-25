package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Step2PsychCognitive extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;
    private TextView txvQNo;

    Button btn_answer1, btn_answer2, btn_answer3, btn_answer4;

    ImageView iv_face;

    List<Step2PsychCognitiveItem> list;

    Random r;

    int turn = 1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2_psych_cognitive);

        r = new Random();

        iv_face = findViewById(R.id.iv_face);

        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_answer4 =  findViewById(R.id.btn_answer4);
        txvQNo = findViewById(R.id.txvQNo);

        list = new ArrayList<>();
        for(int i = 0; i < new Step2PsychCognitiveData().answers.length; i++) {
            list.add(new Step2PsychCognitiveItem(new Step2PsychCognitiveData().answers[i], new Step2PsychCognitiveData().faces[i]));

        }

        Collections.shuffle(list);

        newQuestion(turn);

        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check answers
                checkAnswer(btn_answer1);
            }
        });


        btn_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check answers
                checkAnswer(btn_answer2);
            }

        });

        btn_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check answers
                checkAnswer(btn_answer3);
            }

        });

        btn_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check answers
                checkAnswer(btn_answer4);
            }

        });



        setTitle("Step 2: Psychometric Test- Cognitive");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychCognitive.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychCognitive.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychCognitive.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychCognitive.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step2PsychCognitive.this, Settings.class));
            }
        });
    }

    private void newQuestion(int number) {
        iv_face.setImageResource(list.get(number - 1).getImage());
        txvQNo.setText("Question: " + number + " of 15");

        //randomise button with correct answer
        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch(correct_answer) {
            case 1:
                btn_answer1.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                btn_answer2.setText(list.get(secondButton).getName());
                btn_answer3.setText(list.get(thirdButton).getName());
                btn_answer4.setText(list.get(fourthButton).getName());


                break;
            case 2:
                btn_answer2.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                btn_answer1.setText(list.get(secondButton).getName());
                btn_answer3.setText(list.get(thirdButton).getName());
                btn_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:
                btn_answer3.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                btn_answer2.setText(list.get(secondButton).getName());
                btn_answer1.setText(list.get(thirdButton).getName());
                btn_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:
                btn_answer4.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                btn_answer2.setText(list.get(secondButton).getName());
                btn_answer3.setText(list.get(thirdButton).getName());
                btn_answer1.setText(list.get(fourthButton).getName());
                break;
        }

    }

    private void checkAnswer(Button btn_answer){

        if (btn_answer.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
            Toast.makeText(Step2PsychCognitive.this, "Correct!", Toast.LENGTH_SHORT).show();

            score++;

            if(turn < list.size()) {
                turn++;
                //score++;
                newQuestion(turn);
            } else {
                Toast.makeText(Step2PsychCognitive.this, "You have finished the cognitive test ", Toast.LENGTH_SHORT).show();
                Intent Step2PsychCognitiveScoreIntent = new Intent(this,Step2PsychCognitiveScore.class);
                Step2PsychCognitiveScoreIntent.putExtra("score",score);
                startActivity(Step2PsychCognitiveScoreIntent);
                finish();
            }
        } else {
            Toast.makeText(Step2PsychCognitive.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            //Toast.makeText(Step2PsychCognitive.this, "You lost the game!", Toast.LENGTH_SHORT).show();
            //finish();
            if(turn < list.size()) {
                turn++;
                newQuestion(turn);
            } else {
                Toast.makeText(Step2PsychCognitive.this, "You have finished the test ", Toast.LENGTH_SHORT).show();
                Intent Step2PsychCognitiveScoreIntent = new Intent(this,Step2PsychCognitiveScore.class);
                Step2PsychCognitiveScoreIntent.putExtra("score",score);
                startActivity(Step2PsychCognitiveScoreIntent);
                finish();
            }


        }
    }
}
