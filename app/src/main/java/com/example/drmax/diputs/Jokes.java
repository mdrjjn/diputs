package com.example.drmax.diputs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Jokes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);


    }
    public void onClickRandomJokeButton(View view){
        Intent intent = new Intent();
        startActivity(intent);
    }
}
