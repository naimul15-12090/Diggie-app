package com.example.imdiggie.ui.faculty;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdiggie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeacherAdapter  extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<TeacherData> list;
    private Context context;
    private String category;

    public TeacherAdapter(List<TeacherData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;

    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent,false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {

        final TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.initial.setText(item.getInitial());
        holder.teacherId.setText(item.getTeacherId());
        holder.phone.setText(item.getPhone());
        holder.email.setText(item.getEmail());
        try {
            Picasso.get().load(item.getImage()).into(holder.teacherImage);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, initial,phone,teacherId;
        private ImageView teacherImage;


        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teacherName);
            initial = itemView.findViewById(R.id.teacherInitial);
            email = itemView.findViewById(R.id.teacherEmail);
            teacherId = itemView.findViewById(R.id.teacherId);
            phone = itemView.findViewById(R.id.teacherPhone);
            teacherImage = itemView.findViewById(R.id.teacherImage);

        }
    }
}
