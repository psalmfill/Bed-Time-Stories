package com.example.bedtime.Model;

public class Story {
    private String mTitle;

    private String mReleaseDate;

    public Story(String title, String releaseDate) {
        mTitle = title;
        mReleaseDate = releaseDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }
}
