package com.example.bedtime.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bedtime.Model.Category;
import com.example.bedtime.R;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryHolder> {
    Context mContext;
    List<Category> mCategories;

    public CategoriesAdapter(Context context, List<Category> categories) {
        mContext = context;
        mCategories = categories;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_single_card,
                parent,false);

        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.mName.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        return mCategories != null ? mCategories.size() : 0;
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mName;

        public CategoryHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.category_image);
            mName = itemView.findViewById(R.id.category_name);

        }
    }
}
