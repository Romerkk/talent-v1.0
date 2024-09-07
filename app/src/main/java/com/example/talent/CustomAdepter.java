package com.example.talent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdepter extends RecyclerView.Adapter<CustomHolder> {

    Context context;
    ArrayList<CustomModel> customModelArrayList = new ArrayList<>();

    public CustomAdepter(Context context, ArrayList<CustomModel> customModelArrayList) {
        this.context = context;
        this.customModelArrayList = customModelArrayList;
    }




    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new CustomHolder(LayoutInflater.from(context).inflate( R.layout.card_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(customModelArrayList.get(position).getImage());
        holder.tvTitle.setText(customModelArrayList.get(position).getTitle());
        holder.tvDesc.setText(customModelArrayList.get(position).getDesc());

        holder.cardItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity2.class);

                intent.putExtra("icon",customModelArrayList.get(position).getImage());
                intent.putExtra("title",customModelArrayList.get(position).getTitle());
                intent.putExtra("desc",customModelArrayList.get(position).getDesc());
                context.startActivity(intent);





            }
        });





    }

    @Override
    public int getItemCount() {

        return customModelArrayList.size();





    }

    public void filterList(ArrayList<CustomModel> filtereadList ){


        customModelArrayList = filtereadList;
        notifyDataSetChanged();


    }

}
