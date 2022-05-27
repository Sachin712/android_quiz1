package com.example.n01420704_quiz1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyData extends RecyclerView.Adapter<RecyclerViewHolder>{
    String[] name;

    public MyData(String n[])
    {
        this.name=n;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.getView().setText(name[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.frame_textview;
    }
}
