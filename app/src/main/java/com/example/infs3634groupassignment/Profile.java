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
import android.os.AsyncTask;

import com.example.infs3634groupassignment.Entities.Inspire;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    private EditText goal;
    private SharedPreferences savedGoal;
    private Button btnSave;
    private Button btnInspire;
    private TextView tvQuote;

    private String TAG = "Profile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        home = findViewById(R.id.ivHome);
        trophy = findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

        goal = findViewById(R.id.editGoal);
        btnSave = findViewById(R.id.btnSave);
        btnInspire = findViewById(R.id.btnInspire);
        tvQuote = findViewById(R.id.tvQuote);

        btnInspire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new GetQuoteTask().execute();
            }
        });


        // Functionality for saving goal into sharedPreferences file
        savedGoal = getSharedPreferences("goal", MODE_PRIVATE);
        goal.setText((savedGoal.getString("tag", "")));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goal.getText().toString() != null) {
                    makeTag(goal.getText().toString());
                    Toast.makeText(getApplicationContext(), "Your changes have been saved!", Toast.LENGTH_LONG).show();
                } else if (goal.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "There is nothing to save!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Your changes have been saved!", Toast.LENGTH_LONG).show();
                }
            }
        });




        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Settings.class));
            }
        });

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        if (databaseHelper.getAchievementStatus("Who am I?")) {

        } else {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup) findViewById(R.id.relativeLayout1));
            ImageView image = view.findViewById(R.id.imvImage);
            image.setImageResource(R.drawable.ach_profile);
            TextView text = view.findViewById(R.id.textView2);
            text.setText("Who am I?");

            Toast toast = new Toast(getApplicationContext());
            toast.setView(view);
            toast.show();

            databaseHelper.setAchievementStatus("Who am I?");
        }
    }


    private void makeTag(String tag) {
        String head = savedGoal.getString(tag, "");
        SharedPreferences.Editor preferencesEditorHeading = savedGoal.edit();
        preferencesEditorHeading.putString("tag", tag);
        preferencesEditorHeading.commit();
    }

    // Functionality for the inspirational quote
    // Use asyncTask to enable faster performance of the API call
    // Convert Json response string into a Java object, connect retrofit with Inspire interface and call API to retrieve the joke
    private class GetQuoteTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.chucknorris.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                InspireService service = retrofit.create(InspireService.class);
                Call<Inspire> inspiresCall = service.getValue();
                Response<Inspire> inspiresResponse = inspiresCall.execute();
                String inspires = inspiresResponse.body().getValue();
                return inspires;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String inspire) {
                        tvQuote.setVisibility(View.VISIBLE);
                        tvQuote.setText("\"" + inspire + "\"");
                        btnInspire.setText("More!");
        }
    }
}

