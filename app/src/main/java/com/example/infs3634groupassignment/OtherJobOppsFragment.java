package com.example.infs3634groupassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OtherJobOppsFragment extends Fragment {

    private Button gradAusButton, seekButton, linkedInButton, indeedButton;

    public OtherJobOppsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_other_job_opps, container, false);
        gradAusButton = v.findViewById(R.id.gradAusButton);
        gradAusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openGradAus();
            }
        });

        seekButton = v.findViewById(R.id.seekButton);
        seekButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSeek();

            }
        });

        linkedInButton = v.findViewById(R.id.linkedInButton);
        linkedInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openLinkedIn();

            }
        });

        indeedButton = v.findViewById(R.id.indeedButton);
        indeedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openIndeed();

            }
        });

        return v;
    }

    public void openGradAus() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gradaustralia.com.au/"));
        startActivity(browserIntent);
    }

    public void openSeek() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.seek.com.au/"));
        startActivity(browserIntent);
    }

    public void openLinkedIn() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/"));
        startActivity(browserIntent);
    }

    public void openIndeed() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://au.indeed.com/?r=us"));
        startActivity(browserIntent);
    }
}
