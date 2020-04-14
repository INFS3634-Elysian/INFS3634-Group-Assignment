package com.example.infs3634groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Step5OutcomeOffer extends YouTubeBaseActivity {
    private ImageView home;
    private ImageView trophy;
    private ImageView notebook;
    private ImageView profile;
    private ImageView settings;

//    ImageView congrats = (ImageView) findViewById(R.id.ivCongrats);
//    ImageView contract = (ImageView) findViewById(R.id.ivContract);
//    ImageView firmEvent = (ImageView) findViewById(R.id.ivFirmEvent);
//    int pic = getResources().getIdentifier("outcome_congrats","drawable","com.example.infs3634groupassignment")
//    congrats.setImageDrawable(pic);

    YouTubePlayerView mYoutubePlayerView;
    Button btnPlayYoutubeVideo;
    YouTubePlayer.OnInitializedListener mOnInitialisedListener;

    private static final String TAG ="Step 5 Outcome Offer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5_outcome_offer);
        setTitle("Step 5: Final Outcome- Offer");
        home = findViewById(R.id.ivHome);
        trophy= findViewById(R.id.ivTrophy);
        notebook = findViewById(R.id.ivNotebook);
        profile = findViewById(R.id.ivProfile);
        settings = findViewById(R.id.ivSettings);

//        Log.d(TAG,"onCreate: Starting");
//        btnPlayYoutubeVideo = (Button) findViewById(R.id.btnPlayYoutubeVideo);
//        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeVideo);
//
//        mOnInitialisedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                Log.d(TAG, "onClick: Done initialising.");
//                youTubePlayer.loadVideo("aifJqKiXaZA");
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                Log.d(TAG, "onClick: Failed to initialise.");
//            }
//        };
//        btnPlayYoutubeVideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG,"onClick: Initialising Youtuber Player.");
//                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitialisedListener);
//
//            }
//        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Home.class));
            }
        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Achievement.class));
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Notebook.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Profile.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step5OutcomeOffer.this, Settings.class));
            }
        });
    }
}
