package com.example.talent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView tvTitle,tvDesc;
    CardView cardItemView;


    public CustomHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById( R.id.imageView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvDesc = itemView.findViewById(R.id.tvDesc);
        cardItemView = itemView.findViewById(R.id.cardItemView);






    }
}
