package com.example.imdiggie.pdf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.imdiggie.R;

import java.util.List;

import okhttp3.HttpUrl;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {

    private Context context;
    private List<PdfData> list;

    public PdfAdapter(Context context, List<PdfData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pdf_item_layout,parent,false);
        return new PdfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, final int position) {

        holder.pdfTitle.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context,PdfViewerActivity.class);
               intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
               context.startActivity(intent);
            }
        });

        holder.pdfDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PdfViewHolder extends RecyclerView.ViewHolder {

        private TextView pdfTitle;
        private ImageView pdfDownload;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);

            pdfTitle = itemView.findViewById(R.id.pdfTitle);
            pdfDownload = itemView.findViewById(R.id.pdfDownload);


        }
    }

}
