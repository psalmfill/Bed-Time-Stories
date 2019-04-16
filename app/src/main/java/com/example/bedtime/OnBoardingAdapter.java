package com.example.bedtime;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OnBoardingAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private String[] mTitles ;
    private String[] mBodies ;

    public OnBoardingAdapter(Context context, String[] titles, String[] bodies) {
        mContext = context;
        mTitles = titles;
        mBodies = bodies;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.onboarding_layout,container,false);
        TextView title = view.findViewById(R.id.slide_title);
        TextView body = view.findViewById(R.id.slide_body);
        title.setText(mTitles[position]);
        body.setText(mBodies[position]);
        container.addView(view);
        return view;
    }
}
