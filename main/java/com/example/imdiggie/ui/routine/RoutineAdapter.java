package com.example.imdiggie.ui.routine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imdiggie.FullImageView;
import com.example.imdiggie.R;

import java.util.List;

public class RoutineAdapter extends RecyclerView.Adapter<RoutineAdapter.RoutineViewAdapter> {

    private Context context;
    private List<String> images;

    public RoutineAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public RoutineViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.routine_image,parent,false);
        return new RoutineViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoutineViewAdapter holder, final int position) {
        Glide.with(context).load(images.get(position)).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class RoutineViewAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;

        public RoutineViewAdapter(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }
}
