package com.example.drmax.diputs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Jokes extends AppCompatActivity {

    Button displayJoke;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        displayJoke = (Button) findViewById(R.id.helpButton);
        text1 = (TextView)findViewById(R.id.text);
        displayJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase fb1 = FirebaseDatabase.getInstance();
                DatabaseReference dr1 = fb1.getReference("/joke");
                dr1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ArrayList<String> stuff = new ArrayList<String>();
                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                            stuff.add(ds.getValue(String.class));
                        }
                        int rand = (int)(Math.random()*stuff.size());
                        text1.setText(stuff.get(rand));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}
