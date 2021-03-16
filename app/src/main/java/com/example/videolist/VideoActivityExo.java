package com.example.videolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


import java.util.Objects;

public class VideoActivityExo extends AppCompatActivity {


    SimpleExoPlayer exoPlayer;
    PlayerView playerView;

    ImageView fullscreenButton;
    boolean fullscreen = false;

    String videoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  // to hidden status bar
        setContentView(R.layout.activity_video2);



        videoURL = getIntent().getStringExtra("url");


        playerView= findViewById(R.id.exoplayerView);


        // for access to id we need to add implementation 'com.google.android.exoplayer:exoplayer-ui:2.10.4' to gradle
        fullscreenButton = playerView.findViewById(R.id.exo_fullscreen_icon);

        exoPlayer = ExoPlayerFactory.newSimpleInstance(getApplicationContext());


        HttpProxyCacheServer proxyServer = new HttpProxyCacheServer.Builder(getApplicationContext()).maxCacheSize(1024 * 1024 * 1024).build();

        String proxyURL = proxyServer.getProxyUrl(videoURL);


        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), getApplicationContext().getPackageName()));


        playerView.setPlayer(exoPlayer);
//        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);

        exoPlayer.prepare(new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(proxyURL)));

        exoPlayer.setPlayWhenReady(true);
        exoPlayer.getPlaybackState();




        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fullscreen) {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(VideoActivityExo.this, R.drawable.ic_fullscreen_open));

                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

                    if(getSupportActionBar() != null){
                        getSupportActionBar().show();
                    }

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
//                    params.width = params.MATCH_PARENT;
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
//                    params.height = (int) ( 300 * getApplicationContext().getResources().getDisplayMetrics().density);
                    params.height = params.MATCH_PARENT;
                    playerView.setLayoutParams(params);

                    fullscreen = false;
                }else{
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(VideoActivityExo.this, R.drawable.ic_fullscreen_close));

                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

                    if(getSupportActionBar() != null){
                        getSupportActionBar().hide();
                    }

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;


//                    DisplayMetrics displayMetrics = new DisplayMetrics();
//                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//                    params.height = displayMetrics.heightPixels;
                    params.height = params.MATCH_PARENT;
//                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    playerView.setLayoutParams(params);

                    fullscreen = true;
                }
            }
        });

    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exoPlayer.stop();
    }

    @Override
    public void onPause() {
        super.onPause();
        exoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void onDestroy() {
        exoPlayer.release();
        super.onDestroy();
    }
}