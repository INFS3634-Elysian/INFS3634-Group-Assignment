package com.example.infs3634groupassignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class OtherDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_detail);


        //unwrap intent message, get the resID and store as int to send to the DetailFragments
        String optionMessage = getIntent().getExtras().getString("option");


        //if statement to determine which option it is.
        if (optionMessage.equals("option1")) {//call the fragment from here to set the activity view
            OtherNetworkTipsFragment myFrag = new OtherNetworkTipsFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, myFrag);
            transaction.commit();

        } else if (optionMessage.equals("option2")) {
            OtherNetworkBlogFragment otherBlogFrag = new OtherNetworkBlogFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, otherBlogFrag);
            transaction.commit();


        } else if (optionMessage.equals("option3")) { //other career
            OtherCareerPortalFragment otherBlogFrag = new OtherCareerPortalFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, otherBlogFrag);
            transaction.commit();


        } else if (optionMessage.equals("option4")) { //other career
            OtherJobOppsFragment otherBlogFrag = new OtherJobOppsFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.networkingScrollview, otherBlogFrag);
            transaction.commit();


        }

    }
}
