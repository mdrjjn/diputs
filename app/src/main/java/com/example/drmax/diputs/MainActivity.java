package com.example.drmax.diputs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickHelpButton(View view) {
        //TextView exampleTextView = (TextView) findViewById(R.id.text);
        //exampleTextView.setText("What's yo prob yo?");
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
        Intent intent = new Intent(this, Problem.class);
        startActivity(intent);
    }


    public void onClickContributeButton(View view) {
        //TextView exampleTextView = (TextView) findViewById(R.id.text);
        //exampleTextView.setText("What's yo prob yo?");
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
        Intent intent = new Intent(this, Contribute.class);
        startActivity(intent);


}
