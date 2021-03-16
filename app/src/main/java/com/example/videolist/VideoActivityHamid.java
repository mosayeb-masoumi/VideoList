package com.example.videolist;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.danikula.videocache.HttpProxyCacheServer;
//import com.google.android.exoplayer2.ExoPlayerFactory;
//import com.google.android.exoplayer2.SimpleExoPlayer;
//import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
//import com.google.android.exoplayer2.extractor.ExtractorsFactory;
//import com.google.android.exoplayer2.source.ExtractorMediaSource;
//import com.google.android.exoplayer2.source.MediaSource;
//import com.google.android.exoplayer2.source.ProgressiveMediaSource;
//import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
//import com.google.android.exoplayer2.trackselection.TrackSelector;
//import com.google.android.exoplayer2.ui.PlayerView;
//import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DataSource;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
//import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
//import com.google.android.exoplayer2.util.Util;
import com.potyvideo.library.AndExoPlayerView;

public class VideoActivityHamid extends AppCompatActivity {

//    SimpleExoPlayer exoPlayer;
//    PlayerView playerView;
    String videoURL;

    private AndExoPlayerView andExoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoURL = getIntent().getStringExtra("url");
        andExoPlayerView = findViewById(R.id.andExoPlayerView);

//        HttpProxyCacheServer proxyServer = new HttpProxyCacheServer.Builder(this).maxCacheSize(1024 * 1024 * 1024).build();
//        String proxyUrl = proxyServer.getProxyUrl(videoURL);
//        mediaPlayer.setDataSource(proxyUrl);

        andExoPlayerView.setSource(videoURL);

    }
    @Override
    public void onBackPressed () {
        super.onBackPressed();
        andExoPlayerView.stopPlayer();
    }

    @Override
    protected void onStop () {
        super.onStop();
        andExoPlayerView.stopPlayer();
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        andExoPlayerView.stopPlayer();
    }
}