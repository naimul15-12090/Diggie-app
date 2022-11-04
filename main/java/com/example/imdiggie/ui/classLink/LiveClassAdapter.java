package com.example.imdiggie.ui.classLink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdiggie.R;

import java.util.List;

public class LiveClassAdapter extends RecyclerView.Adapter<LiveClassAdapter.ClassLinkViewAdapter > {

    private List<LiveClassData> list;
    private Context context;
    private String category;

    public LiveClassAdapter(List<LiveClassData> list, Context context, String category) {
        this.list= list;
        this.context = context;
        this.category = category;

    }

    @NonNull
    @Override
    public ClassLinkViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.class_link_item_layout, parent,false);
        return new ClassLinkViewAdapter (view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClassLinkViewAdapter holder, final int position) {

        final LiveClassData item = list.get(position);
        holder.courseCode.setText(item.getCourseCode());
        holder.courseTitle.setText(item.getCourseTitle());
//        holder.liveClassLink.setText(item.getLiveClassLink());
        holder.classTime.setText(item.getClassTime());

        holder.joinClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getLiveClassLink()));
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ClassLinkViewAdapter extends RecyclerView.ViewHolder {

        private TextView courseCode, courseTitle, liveClassLink,classTime;
        private Button joinClassBtn;



        public ClassLinkViewAdapter(@NonNull View itemView) {
            super(itemView);

            courseCode = itemView.findViewById(R.id.courseCode);
            courseTitle = itemView.findViewById(R.id.courseTitle);
//            liveClassLink = itemView.findViewById(R.id.liveClassLink);
            classTime = itemView.findViewById(R.id.classTime);
            joinClassBtn = itemView.findViewById(R.id.joinClassBtn);


        }
    }


}
