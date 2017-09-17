package com.example.drmax.diputs;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class History extends AppCompatActivity {
    TextView t;
    int i = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        t=(TextView)findViewById(R.id.txtFact);
        final Button button = (Button) findViewById(R.id.btnClick);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickbtnNext();
            }
        });
    }
    public void onClickbtnNext() {
        switch (i%10){
            case 1:
                t.setText("Purdue has the first university owned airport in the US");
                break;
            case 2:
                t.setText("Amelia Earhart prepped for her infamous flight around the world at Purdue");
                break;
            case 3:
                t.setText("The first and last astronauts to step foot on the moon were Purdue grads (Neil Armstrong and Eugene Cernan)");
                break;
            case 4:
                t.setText("Triple XXX is the oldest drive-in in Indiana");
                break;
            case 5:
                t.setText("Kermit the Frog was named after a Purdue professor of philosophy");
                break;
            case 6:
                t.setText("Purdue started the first Computer Science program in the US");
                break;
            case 7:
                t.setText("Purdue ranks as the 4th best public university by the Wall Street Journal");
                break;
            case 8:
                t.setText("Purdue is 117-89 against IU in men's basketball");
                break;
            case 9:
                t.setText("Purdue also leads IU 72-41 in football");
                break;
            case 10:
                t.setText("And last but not least, IU Sucks!");
                break;
        }

        i++;
    }

}
