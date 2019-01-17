package com.example.extra.filewriterreader;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    EditText filename_text;
    EditText editText;
    String result;
    String result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        
        editText = (EditText) findViewById(R.id.editText);
        filename_text = (EditText) findViewById(R.id.editText2);

        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    result2 = (String) editText.getText().toString();
                    return true;
                }
                return false;
            }
        });

        filename_text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    result = (String) filename_text.getText().toString();
                    return true;
                }
                return false;
            }
        });

    }
    public void readFile(View v){
        try{
            InputStream ins = context.openFileInput(result);

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";

            while((s=br.readLine())!=null) {
                editText.setText(s);
            }

            ins.close();
            
        }catch (IOException e){
            Log.e("IOException","Virhe");
        } finally {
            System.out.println("Luettu");
        }
    }

    public void writeFile(View v){
        try{
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(result,Context.MODE_PRIVATE));
            String s="";

            s=result2+"\n";
            ows.write(s);
            ows.close();
            
        }catch (IOException e){
            Log.e("IOException","Virhe");
        }finally {
            System.out.println("Kirjoitettu");
        }
    }
}
