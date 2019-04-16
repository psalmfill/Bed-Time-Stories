package com.example.bedtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.bedtime.Adapters.CategoriesAdapter;
import com.example.bedtime.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    RecyclerView mCategory_rv;
    CategoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //customize custom toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setElevation(0);

        TextView mTitle =  toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Categories");

        mCategory_rv = findViewById(R.id.category_rv);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Myths"));
        categories.add(new Category("Love"));
        categories.add(new Category("Tale"));
        categories.add(new Category("Night"));
        categories.add(new Category("Life"));
        categories.add(new Category("School"));
        mAdapter = new CategoriesAdapter(this, categories);
        mCategory_rv.setLayoutManager(new LinearLayoutManager(this));
        mCategory_rv.setAdapter(mAdapter);
    }
}
