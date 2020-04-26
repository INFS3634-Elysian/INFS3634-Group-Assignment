package com.example.infs3634groupassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class OtherDetail extends AppCompatActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_detail);

        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);


        //unwrap intent message, get the resID and store as int to send to the DetailFragments
        String optionMessage = getIntent().getExtras().getString("option");


        //if statement to determine which option it is.
        if (optionMessage.equals("option1")) {//call the fragment from here to set the activity view
            setTitle("Networking Tips");
            OtherNetworkTipsFragment myFrag = new OtherNetworkTipsFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, myFrag);
            transaction.commit();

        } else if (optionMessage.equals("option2")) {
            setTitle("Networking Blog");
            OtherNetworkBlogFragment otherBlogFrag = new OtherNetworkBlogFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, otherBlogFrag);
            transaction.commit();


        } else if (optionMessage.equals("option3")) { //other career
            setTitle("UNSW Careers Portal");
            OtherCareerPortalFragment otherBlogFrag = new OtherCareerPortalFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, otherBlogFrag);
            transaction.commit();


        } else if (optionMessage.equals("option4")) { //other career
            setTitle("Other Job Opportunities");
            OtherJobOppsFragment otherBlogFrag = new OtherJobOppsFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, otherBlogFrag);
            transaction.commit();


        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherDetail.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherDetail.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherDetail.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherDetail.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherDetail.this, Settings.class));
            }
        });

    }
}
