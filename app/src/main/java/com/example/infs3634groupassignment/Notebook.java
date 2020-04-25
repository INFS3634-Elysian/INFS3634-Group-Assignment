package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Notebook extends AppCompatActivity {
    // Declaring variables that will be used in this activity
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormatTime;
    private SimpleDateFormat dateFormatDay;
    private String dateTime;
    private String dateDay;

    private Button btnSave;
    private SharedPreferences savedHeading;
    private SharedPreferences savedBody;
    private EditText heading;
    private EditText body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);
        setTitle("Notebook");

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        if (databaseHelper.getAchievementStatus("Time to take some notes")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup)findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_notepad);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Time to take some notes");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Time to take some notes");
        }

        // Linking java and xml attributes
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);
        btnSave = findViewById(R.id.btnSave);
        heading = findViewById(R.id.editHeading);
        body = findViewById(R.id.editGoal);
        // Setting the values of heading and body TextViews to what is stored in getSharedPreferences file.
        // Operating mode is set to private so that only this activity can access the file.
        savedHeading = getSharedPreferences("heading", MODE_PRIVATE);
        heading.setText((savedHeading.getString("tag","")));
        savedBody = getSharedPreferences("body", MODE_PRIVATE);
        body.setText((savedBody.getString("tag","")));

        // Displaying the current time and day under the heading
        calendar = Calendar.getInstance();
        dateFormatTime = new SimpleDateFormat("hh:mm a");
        dateFormatDay = new SimpleDateFormat("dd/MM/yyyy");
        dateTime = dateFormatTime.format(calendar.getTime());
        dateDay = dateFormatDay.format(calendar.getTime());
        dateTimeDisplay = findViewById(R.id.tvDate);
        dateTimeDisplay.setText(dateTime + ", " +dateDay);

        // Upon clicking the save button, the heading and body is saved in the database so the user can view it when they come back to this activity
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               if((heading.getText().toString() != null) && (body.getText().toString() != null)){
                    makeTag(heading.getText().toString());
                    makeTagTwo(body.getText().toString());
                    Toast.makeText(getApplicationContext(), "Your changes have been saved!", Toast.LENGTH_LONG).show();
                }
                else if(heading.getText().toString() != null){
                    makeTag(heading.getText().toString());
                    Toast.makeText(getApplicationContext(), "Your changes have been saved!", Toast.LENGTH_LONG).show();
                }
                else if(body.getText().toString() != null){
                    makeTagTwo(body.getText().toString());
                    Toast.makeText(getApplicationContext(), "Your changes have been saved!", Toast.LENGTH_LONG).show();
                } else if ((heading.getText().toString().equals("Heading")) && (body.getText().toString().equals("Start typing your notes!"))){
                    Toast.makeText(getApplicationContext(), "There's nothing to save!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Your changes have been saved!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Directing users to a specific page depending on which icon they click on the navigation bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notebook.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notebook.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notebook.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notebook.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notebook.this, Settings.class));
            }
        });
    }

    // Editing what is in the SharedPreferences file, and replacing the current heading with the new String inputted by the user
    private void makeTag(String tag){
        String head = savedHeading.getString(tag, "");
        SharedPreferences.Editor preferencesEditorHeading = savedHeading.edit();
        preferencesEditorHeading.putString("tag",tag);
        preferencesEditorHeading.commit();
    }

    // Editing what is in the SharedPreferences file, and replacing the current body text with the new String inputted by the user
    private void makeTagTwo(String tagTwo){
        String body = savedBody.getString(tagTwo, "");
        SharedPreferences.Editor preferencesEditorBody = savedBody.edit();
        preferencesEditorBody.putString("tag",tagTwo);
        preferencesEditorBody.commit();
    }


}
