package com.example.videolist;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import com.potyvideo.library.AndExoPlayerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout root;
    //    AndExoPlayerView player;
    ImageView img_play;
    VideoView videoView;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        root = itemView.findViewById(R.id.rl_root);
//        player = itemView.findViewById(R.id.player);
        img_play = itemView.findViewById(R.id.img_play);
        videoView = itemView.findViewById(R.id.videoView);


    }

    public void bindData(String model, int position) {

//        if(Constant.LASTPOSITION !=position){
//            player.stopPlayer();
//
//            img_play.setVisibility(View.VISIBLE);
//        }

    }

    public void setOnVideoHolderListener(VideoItemInteraction listener, String url, int position, Context context) {

        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, VideoActivityExo.class);
                intent.putExtra("url",url);
                context.startActivity(intent);
//                HttpProxyCacheServer proxyServer = new HttpProxyCacheServer.Builder(itemView.getContext()).maxCacheSize(1024 * 1024 * 1024).build();
//                String proxyUrl = proxyServer.getProxyUrl(link);
////                mediaPlayer.setDataSource(proxyUrl);
//
//                Uri uri = Uri.parse(proxyUrl);
//                videoView.setVideoURI(uri);
//                MediaController mediaController = new MediaController(context);
//                videoView.setMediaController(mediaController);
//
//                mediaController.setAnchorView(videoView);
//
//                videoView.start();
//
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mediaPlayer) {
//                        videoView.stopPlayback();
//                    }
//                });



//                try
//                {
//                    MediaController mediaController = new MediaController(context);
//                    mediaController.setAnchorView(videoView);
//
//                    Uri video = Uri.parse(link);
//                    videoView.setMediaController(mediaController);
//                    videoView.setVideoURI(video);
//                    videoView.requestFocus();
//                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
//                    {
//
//                        public void onPrepared(MediaPlayer mp)
//                        {
////                            progressDialog.dismiss();
//                            videoView.start();
//                        }
//                    });
//
//                    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                        @Override
//                        public void onCompletion(MediaPlayer mediaPlayer) {
//                            videoView.stopPlayback();
//                        }
//                    });
//
//                }
//                catch(Exception e)
//                {
////                    progressDialog.dismiss();
//                    System.out.println("Video Play Error :"+e.toString());
////                    finish();
//                }

            }
        });
    }
}
