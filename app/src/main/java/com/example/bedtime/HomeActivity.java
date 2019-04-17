package com.example.bedtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bedtime.Adapters.StoryListingAdapter;
import com.example.bedtime.Model.Story;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView mStoriesRecycler;
    StoryListingAdapter mAdapter;
    List<Story> mStories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mStoriesRecycler = findViewById(R.id.stories_rv);
        mStories = new ArrayList<>();
        mStories.add(new Story("Tales by noon light","3 min read"));
        mStories.add(new Story("War Zone","7 min read"));
        mStories.add(new Story("Ali and the Angel","10 min read"));
        mStories.add(new Story("Story of the wicked king","20 min read"));
        mStories.add(new Story("A war without End","3 min read"));
        mStories.add(new Story("Okon and the old woman","5 min read"));
        mAdapter = new StoryListingAdapter(this,mStories);
        mStoriesRecycler.setLayoutManager(new LinearLayoutManager(this));
        mStoriesRecycler.setAdapter(mAdapter);
    }
}
