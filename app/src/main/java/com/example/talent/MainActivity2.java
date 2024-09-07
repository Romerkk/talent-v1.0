package com.example.talent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    ImageView getImageView;
    TextView tvGeTitle,tvGetDesc;

    private Button bottom_voltarhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getImageView = findViewById( R.id.getImageView);
        tvGeTitle = findViewById(R.id.tvGeTitle);
        tvGetDesc = findViewById(R.id.tvGetDesc);
        bottom_voltarhome = findViewById(R.id.bottom_voltarhome);

        Intent intent = getIntent();

        String getTitle = intent.getStringExtra("title");
        String getDesc = intent.getStringExtra("desc");

        int getImage = intent.getIntExtra("icon",0);

        getImageView.setImageResource(getImage);
        tvGeTitle.setText(getTitle);
        tvGetDesc.setText(getDesc);


        getSupportActionBar().hide();



        bottom_voltarhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.talent.MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });






    }
}