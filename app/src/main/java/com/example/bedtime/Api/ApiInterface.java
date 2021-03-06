package com.example.bedtime.Api;

import com.example.bedtime.Api.Responses.CategoryAllResponse;
import com.example.bedtime.Api.Responses.StoryAllResponse;
import com.example.bedtime.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("category/all")
    Call<CategoryAllResponse> getAllCategories();
        
    @GET("story")
    Call<StoryAllResponse> getAllStories();
    @POST("user/register")
    Call<String> registerUser(@Body User user);

    @POST("user/login")
    Call<String> loginUser(@Body User user);

    @GET("user/profile/{id}")
    Call<User> getProfile(@Path("id") String id);
}
