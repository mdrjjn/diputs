package com.example.drmax.diputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contribute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);

        FirebaseDatabase fbDb = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fbDb.getReference("/message");
        Log.d("TAG", myRef.toString());
        myRef.setValue("wasup");
    }


}
