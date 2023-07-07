package com.example.notes;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class HomeActivity extends AppCompatActivity {
    //ArrayList<HomeModel> homeModelArrayList = new ArrayList<>();
    ListView list;
    String[] fullName = new String[]{
            "Bachelor in Computer Application", "Bachelor of Business Administration",
            "Bachelor of Science", "Bachelor of Commerce",
            "Bachelor of Arts", "Bachelor of Education",
    };

    String[] className = new String[]{
            "BCA","BBA",
            "BSc","BCom",
            "BA","BEd",
    };

    Integer[] imgid = new Integer[]{
            R.drawable.bcalogo,R.drawable.bbalogo,
            R.drawable.bsclogo,R.drawable.bcomlogo,
            R.drawable.balogo,R.drawable.bedlogo,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeListAdapter adapter = new HomeListAdapter(this, className,fullName,imgid);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Welcome To "+className[position]+" Department", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this, BcaActivity.class));
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Welcome To "+className[position]+" Department", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this, BbaActivity.class));
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Welcome To "+className[position]+" Department", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Welcome To "+className[position]+" Department", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Welcome To "+className[position]+" Department", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"Welcome To "+className[position]+" Department", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}