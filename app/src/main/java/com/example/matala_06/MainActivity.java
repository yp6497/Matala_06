package com.example.matala_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edA,edH;
    String sA,sH;
    float a,h;
    int x;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edA=findViewById(R.id.edA);
        edH=findViewById(R.id.edH);
        sw=findViewById(R.id.sw);

    }

    public void start(View view) {

        sA=edA.getText().toString();
        sH=edH.getText().toString();

        if(sA.isEmpty()||sH.isEmpty()) {
            Toast.makeText(this,"please fill all thr feilds", Toast.LENGTH_SHORT).show();
        }
        else {

            if(sw.isChecked())
                x=1;
            else x=2;
            a=Float.parseFloat(sA);
            h=Float.parseFloat(sH);

            edA.getText().clear();
            edH.getText().clear();

            Intent si = new Intent(this,nextActivity.class);
            si.putExtra("x",x);
            si.putExtra("a",a);
            si.putExtra("h",h);
            startActivity(si);
        }

    }

    public void whichSeries(View view) {
    }
}

