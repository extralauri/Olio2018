package com.example.extra.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText input_text;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        input_text = (EditText) findViewById(R.id.editText);

        input_text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    result = (String) input_text.getText().toString();
                    text.setText(result);
                    return true;
                }
                return false;
            }
        });
    }

     public void testFunction(View v){
        System.out.println("Hello world!");
        result = (String) input_text.getText().toString();
        text.setText(result);
    }
}
