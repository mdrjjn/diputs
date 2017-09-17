package com.example.drmax.diputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Random;

import java.util.Random;

public class Problem extends AppCompatActivity {

    private Button btnAnswer;
    private TextView displayAnswer;
    private long length;
    private Random index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        displayAnswer = (TextView)findViewById(R.id.displayAnswer);
        btnAnswer = (Button)findViewById(R.id.btnAnswer);

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        length = 0;

        FirebaseDatabase fbDb = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fbDb.getReference("/punchlines");
        // Read from the database

        //getting the length of the array
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                length = dataSnapshot.getChildrenCount();
                length++;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        //adding the onclick event listener
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setting up the random int
                index = new Random(length++);

                FirebaseDatabase fbDb = FirebaseDatabase.getInstance();
                DatabaseReference myRef = fbDb.getReference("/punchlines/" + index + "/");
                myRef.child("punchline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        displayAnswer.setText(snapshot.getValue().toString());  //prints "Do you have data? You'll love Firebase."
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

            }
        });
    }


}
