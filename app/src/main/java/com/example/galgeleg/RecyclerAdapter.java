package com.example.galgeleg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    private ArrayList<RecyclerItem> recyclerItemArrayList;


    public static class myViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView name, points, text;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageview);
            this.name = itemView.findViewById(R.id.textView1);
            this.points = itemView.findViewById(R.id.textView2);
            this.text = itemView.findViewById(R.id.textView3);
        }
    }

    //constructor
    public RecyclerAdapter(ArrayList<RecyclerItem> recyclerItemArrayList) {
        this.recyclerItemArrayList = recyclerItemArrayList;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        myViewHolder viewHolder = new myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        RecyclerItem currentItem = recyclerItemArrayList.get(position);

        holder.imageView.setImageResource(currentItem.getImage());
        holder.name.setText(currentItem.getName());
        holder.points.setText(String.valueOf(currentItem.getPoint()));
        holder.text.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return recyclerItemArrayList.size();
    }
}
