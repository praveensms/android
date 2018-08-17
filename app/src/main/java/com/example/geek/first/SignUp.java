package com.example.geek.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {


    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().getRoot();

    EditText name,email,password;

    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        name = (EditText)findViewById(R.id.idName);
        email = (EditText)findViewById(R.id.idEmail);
        password = (EditText)findViewById(R.id.idPassword);

        signUp = (Button)findViewById(R.id.idSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email= email.getText().toString();
                String Pass = password.getText().toString();

                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", Name);
                dataMap.put("Email", Email);
                dataMap.put("Password", Pass);

                mDatabase.push().setValue(dataMap);
            }
        });

    }
}
