package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BcaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca);
        ImageView first, second, third, fourth, fifth, six;

        first = findViewById(R.id.FirstSem);
        second = findViewById(R.id.SecondSem);
        third = findViewById(R.id.ThirdSem);
        fourth = findViewById(R.id.FourthSem);
        fifth = findViewById(R.id.FifthSem);
        six = findViewById(R.id.SixthSem);

        first.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, FirstSem.class)));
//        second.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this,SecondSem.class)));
//        third.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, ThirdSem.class)));
//        fourth.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, FourthSem.class)));
//        fifth.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, FifthSem.class)));
//        six.setOnClickListener(v -> startActivity(new Intent(BcaActivity.this, SixSem.class)));
    }
}