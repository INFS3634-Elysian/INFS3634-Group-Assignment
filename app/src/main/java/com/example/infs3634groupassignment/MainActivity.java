package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButtonSignIn;
    private Button mButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSignIn = findViewById(R.id.btnSignIn);
        mButtonSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Home.class));
            }
        });
    }
}

// Only use this when we are going to use the Sign Up button. Leave for now.
//        mButtonSignUp = findViewById(R.id.btnSignUp);
//        mButtonSignUp.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//        startActivity(new Intent (MainActivity.this, Home.class));


