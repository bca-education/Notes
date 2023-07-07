package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class BbaActivity extends AppCompatActivity {
    ImageView first, second, third, fourth, fifth, six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bba);

        first = findViewById(R.id.FirstSem);
        second = findViewById(R.id.SecondSem);
        third = findViewById(R.id.ThirdSem);
        fourth = findViewById(R.id.FourthSem);
        fifth = findViewById(R.id.FifthSem);
        six = findViewById(R.id.SixthSem);

        first.setOnClickListener(v -> startActivity(new Intent(BbaActivity.this, FirstSem.class)));
//        second.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this,SecondSem.class)));
//        third.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, ThirdSem.class)));
//        fourth.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, FourthSem.class)));
//        fifth.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, FifthSem.class)));
//        six.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, SixSem.class)));

    }
}