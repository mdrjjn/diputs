package com.example.drmax.diputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StreamDownloadTask;

import java.util.ArrayList;
import java.util.List;

public class Contribute extends AppCompatActivity {

    private Button btnSubmitPunch;
    private TextView answerDisplay;
    private EditText punchEdit;
    private EditText inpQue;
    private long nextIndex;
    FirebaseDatabase fbDb;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);


        btnSubmitPunch = (Button)findViewById(R.id.btnSubmitPunchline);
        btnSubmitPunch = (Button)findViewById(R.id.btnSubmitPunchline);
        punchEdit   = (EditText)findViewById(R.id.punchLine);
        inpQue = (EditText)findViewById(R.id.inpQuestion);
        nextIndex = 0;

        //Connecting to firebase
        fbDb = FirebaseDatabase.getInstance();
        myRef = fbDb.getReference("/punchlines");


        //getting the length of the array
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                nextIndex = dataSnapshot.getChildrenCount();
                nextIndex++;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        btnSubmitPunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the value of the punchline input
                String punchLine = punchEdit.getText().toString();
                String question = inpQue.getText().toString();

                if(punchLine.length() > 0) {
                    Punchline punchObj = new Punchline(question, punchLine);

                    DatabaseReference newRef = fbDb.getReference("/punchlines/" + nextIndex);

                    newRef.setValue(punchObj);

                    //Display the response to the user that the line has been successfully uploaded
                    punchEdit.setText("");
                    punchEdit.setHint("All set! Thanks for contributing)");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Type in something dummie!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}
