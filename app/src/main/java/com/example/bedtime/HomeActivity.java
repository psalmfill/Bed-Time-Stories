package com.example.bedtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.bedtime.Adapters.CategoriesAdapter;
import com.example.bedtime.Adapters.StoryListingAdapter;
import com.example.bedtime.Api.ApiInterface;
import com.example.bedtime.Api.Client;
import com.example.bedtime.Api.Responses.CategoryAllResponse;
import com.example.bedtime.Api.Responses.StoryAllResponse;
import com.example.bedtime.Model.Category;
import com.example.bedtime.Model.Story;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    RecyclerView mStoriesRecycler,mCategoriesRecycler;
    StoryListingAdapter mAdapter;
    List<Story> mStories;
    List<Category> mCategories;
    CategoriesAdapter mCategoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //customize custom toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);

        mStoriesRecycler = findViewById(R.id.stories_rv);
        mCategoriesRecycler = findViewById(R.id.cat_rv);
        mStories = new ArrayList<>();
        mCategories = new ArrayList<>();
        mCategoriesAdapter = new CategoriesAdapter(this,mCategories,"home");
        mCategoriesRecycler.setAdapter(mCategoriesAdapter);
        mAdapter = new StoryListingAdapter(this,mStories);
        mStoriesRecycler.setLayoutManager(new LinearLayoutManager(this));
        mStoriesRecycler.setAdapter(mAdapter);
        loadData();
    }


    public void loadData(){
        Client.getInstance().create(ApiInterface.class).getAllCategories().enqueue(new Callback<CategoryAllResponse>() {
            @Override
            public void onResponse(Call<CategoryAllResponse> call, Response<CategoryAllResponse> response) {
                if(response.isSuccessful()){
                    CategoryAllResponse  categoryList = response.body();
                    List<Category> cl= categoryList.getData();
                    if(cl !=null){
                        mCategoriesAdapter.addCategories(cl);
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoryAllResponse> call, Throwable t) {

            }
        });
        Client.getInstance().create(ApiInterface.class).getAllStories().enqueue(new Callback<StoryAllResponse>() {
            @Override
            public void onResponse(Call<StoryAllResponse> call, Response<StoryAllResponse> response) {
                if(response.isSuccessful()){
                    StoryAllResponse  storyAllResponse = response.body();
                    List<Story> story= storyAllResponse.getData().getStories();
                    if(story !=null){
                        mAdapter.addStories(story);
                    }
                }
            }

            @Override
            public void onFailure(Call<StoryAllResponse> call, Throwable t) {
                Log.e("Story = " , t.toString());
            }
        });

    }
}
