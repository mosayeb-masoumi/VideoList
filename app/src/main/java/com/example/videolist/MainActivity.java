package com.example.videolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VideoItemInteraction {

    RecyclerView recyclerView;
    VideoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        List<String> links = new ArrayList<>();

        links.add("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_5mb.mp4");
        links.add("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_5mb.mp4");
        links.add("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_5mb.mp4");
        links.add("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_5mb.mp4");
        links.add("https://filesamples.com/samples/video/mp4/sample_640x360.mp4");





        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new VideoAdapter(links, this);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void notifyDataSetChanged() {

        adapter.notifyDataSetChanged();
    }
}