package com.example.infs3634groupassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class OtherCareerPortalFragment extends Fragment {
    private Button career1;

    public OtherCareerPortalFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_other_career_portal, container, false);
        career1 = v.findViewById(R.id.career1);
        career1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openCareer();
            }
        });
        return v;
    }


    public void openCareer(){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jobs.unsw.edu.au/"));
        startActivity(browserIntent);
    }
}
