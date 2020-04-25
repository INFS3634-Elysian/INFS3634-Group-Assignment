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

import org.w3c.dom.Text;

public class Step1AppCv extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;
    private TextView title1;
    private TextView title2;
    private TextView info1;
    private TextView info2;
    private TextView info3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1_app_cv);
        setTitle("Step 1: Application- CV");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppCv.this, Home.class));
             }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppCv.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppCv.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppCv.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step1AppCv.this, Settings.class));
            }
        });

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        if (databaseHelper.getAchievementStatus("Completed: Curriculum Vitae")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_curriculum);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Completed: Curriculum Vitae");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Completed: Curriculum Vitae");
        }

        //Find Components
        title1 = findViewById(R.id.txvTitle1);
        title2 = findViewById(R.id.txvTitle2);
        info1 = findViewById(R.id.txvPart1);
        info2 = findViewById(R.id.txvPart2);
        info3 = findViewById(R.id.txvPart3);

        //Creating text to set components <b>, </b>
        String title1String = "<b>What is a Curriculum Vitae?</b>";
        String title2String = "<b>How does it differ from a resume?</b>";
        String info1String = "A <b>curriculum vitae</b>, <b>often shortened as CV</b>, is a written overview of someone's life's work.  A CV is a very <b>in-depth document</b> that describes your career journey <b>step-by-step</b> including all the achievments you are proud of, and all the publications that bear your name";
        String info2String = "The primary differences between a resume and a curriculum vitae are <b>length, what is included and what each is used for</b>. While both are used in job applications, a resume and a CV are <b>not always interchangeable</b>.";
        String info3String = "While resumes are usually <b>competency-based</b>, showcasing one's skills and work experience, CVs are <b>credential-based</b>. This requires providing a comprehensive listing of one's education, certifications, research experience and professional affiliations and memberships. An example CV can be seen below:";

        //Setting Components
        title1.setText(Html.fromHtml(title1String));
        title2.setText(Html.fromHtml(title2String));
        info1.setText(Html.fromHtml(info1String));
        info2.setText(Html.fromHtml(info2String));
        info3.setText(Html.fromHtml(info3String));


    }
}
