package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText user_login_name, user_enroll;
    Button btn;
    TextView tv;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://database-application-327cf-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_login_name = findViewById(R.id.edit_user_login_name);
        user_enroll = findViewById(R.id.edit_user_login_enroll);

        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        RegisterDataBase registerDataBase = new RegisterDataBase(this);

        btn.setOnClickListener(v -> {

            String username = user_login_name.getText().toString();
            String enroll = user_enroll.getText().toString();

            if (username.length() == 0 || enroll.length() == 0)
            {
                Toast.makeText(getApplicationContext(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
            }
            else
            {
                boolean checkEnrollUser = registerDataBase.checkUserDetails(enroll, username);
                if (checkEnrollUser)
                {
                    Toast.makeText(LoginActivity.this, username + " Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Student", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));
    }

}