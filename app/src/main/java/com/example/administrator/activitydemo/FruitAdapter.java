package com.example.administrator.activitydemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fruit_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.iv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked ImageView: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked TextView: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit fruit = fruitList.get(i);
        viewHolder.iv_name.setImageResource(fruit.getImageId());
        viewHolder.tv_name.setText("" + fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView iv_name;
        TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            iv_name = (ImageView) itemView.findViewById(R.id.iv_name);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


}
