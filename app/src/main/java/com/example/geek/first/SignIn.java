package com.example.geek.first;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    private DatabaseReference mDatabase;

    TextView result;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Name");
        result = (TextView)findViewById(R.id.idResult);

        login = (Button)findViewById(R.id.idSignIn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() != null){

                            String name = dataSnapshot.getValue().toString();
                            result.setText("Data hase been successfully retrieved!\n" + name);

                        } else {
                            result.setText("There is no data found on the database..");
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        result.setText("Data retrieval has been failed!\n");
                    }
                });
            }
        });

    }
}
