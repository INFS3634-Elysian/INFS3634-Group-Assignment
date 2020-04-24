package com.example.infs3634groupassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class OtherNetworkBlogFragment extends Fragment {
    private TextView blogText;
    private ImageView resImage;
    private Button connect1, connect2, connect3, connect4;

    public OtherNetworkBlogFragment() {
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
        View v = inflater.inflate(R.layout.fragment_other_networking_blog, container, false);
        connect1 = v.findViewById(R.id.connect1);
        connect1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSandra();

            }
        });

        connect2 = v.findViewById(R.id.connect2);
        connect2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTruman();

            }
        });

        connect3 = v.findViewById(R.id.connect3);
        connect3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openJasen();

            }
        });

        connect4 = v.findViewById(R.id.connect4);
        connect4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCathy();

            }
        });


        return v;


    }


    public void openSandra() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sandrama2/"));
        startActivity(browserIntent);
    }

    public void openTruman() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/chtrumanng/"));
        startActivity(browserIntent);
    }

    public void openJasen() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jasen-yu/"));
        startActivity(browserIntent);
    }

    public void openCathy() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/liangcathy/"));
        startActivity(browserIntent);
    }
}

