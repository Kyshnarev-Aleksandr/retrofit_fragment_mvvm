package com.kushnarev.food_shop_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kushnarev.food_shop_app.POJO.Photos_POJO;
import com.kushnarev.food_shop_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<Photos_POJO> postsList;

    public ImageAdapter(List<Photos_POJO> postsList) {
        this.postsList = postsList;
    }

    public void getPostsList(List<Photos_POJO> photos_pojos) {
        this.postsList = photos_pojos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(postsList.get(position).getTitle());
        holder.tvBody.setText(postsList.get(position).getBody());

        Picasso.get().load(postsList.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvBody;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
            imageView = itemView.findViewById(R.id.image);

        }
    }
}
