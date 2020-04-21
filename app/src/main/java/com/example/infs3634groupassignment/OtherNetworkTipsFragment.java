package com.example.infs3634groupassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class OtherNetworkTipsFragment extends Fragment {

    public OtherNetworkTipsFragment() {
        // Required empty public constructor
    }

    private Button connect1, connect2, connect3, connect4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Connect Buttons


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_other_network_tips, container, false);



        return v;
    }
}
