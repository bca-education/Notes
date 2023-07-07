package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class FirstSem extends AppCompatActivity {
    TabLayout firstTab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sem);

        firstTab = findViewById(R.id.firstSem);
        viewPager = findViewById(R.id.viewPage);


        ViewPagerTextNotesAdapter adapter = new ViewPagerTextNotesAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        firstTab.setupWithViewPager(viewPager);

    }
}