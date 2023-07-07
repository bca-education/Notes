package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText std_name, std_enroll, std_enroll_confirm;
    Button register;
    TextView already_account;
    RegisterDataBase registerDataBase;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        std_name = findViewById(R.id.std_name);
        std_enroll = findViewById(R.id.std_enroll);
        std_enroll_confirm = findViewById(R.id.std_enroll_confirm);
        register = findViewById(R.id.buttonRegister);
        already_account = findViewById(R.id.std_already_account);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        already_account.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));

        registerDataBase = new RegisterDataBase(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = std_name.getText().toString();
                String enrollTXT = std_enroll.getText().toString();
                String enrollCTEXT = std_enroll_confirm.getText().toString();

                if (nameTXT.length() == 0|| enrollTXT.length() == 0 || enrollCTEXT.length() == 0)
                    Toast.makeText(RegisterActivity.this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
                else
                {
                    if(enrollTXT.equals(enrollCTEXT))
                    {
                        boolean checkenroll = registerDataBase.checkEnroll(enrollCTEXT);
                        if(checkenroll == false)
                        {
                            boolean insert = registerDataBase.insertStudentData(enrollCTEXT, nameTXT);
                            if(insert)
                            {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "Student Already Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Enrollment Number Doesn't Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}