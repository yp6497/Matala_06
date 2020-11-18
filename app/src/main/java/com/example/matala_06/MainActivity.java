package com.example.matala_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author  Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version	 1.1
 * @since	9/11/2020
 * short description- Checking if the series is geometric progression or numerical sequence and moves the information to the second activity.
 */
public class MainActivity extends AppCompatActivity {

    EditText edA, edH;
    String sA, sH;
    /**
     * The number which the series begin with.
     */
    float a,
    /**
     * hc- The series Difference or multiplication.
     */
    hc;
    /**
     * x- Know which series was chosen.
     */
    int x;
    Switch sw;
    TextView whichS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edA=findViewById(R.id.edA);
        edH=findViewById(R.id.edH);
        sw=findViewById(R.id.sw);
        whichS=findViewById(R.id.whichS);
    }

    /**
     * Start.
     * short description- moves the information to the next activity when you click the button.
     * @param view the view
     */
    public void start(View view) {

        sA = edA.getText().toString();
        sH = edH.getText().toString();

        /**
         * Checks if the user has entered all the information about the series.
         */
        if (sA.isEmpty() || sH.isEmpty()) {
            Toast.makeText(this, "please fill all thr feilds", Toast.LENGTH_SHORT).show();
        } else {

            /**
             * Moves to the second activity.
             */
            a=Float.parseFloat(sA);
            hc=Float.parseFloat(sH);

            edA.getText().clear();
            edH.getText().clear();

            Intent si = new Intent(this,nextActivity.class);
            si.putExtra("x",x);
            si.putExtra("a",a);
            si.putExtra("hc",hc);
            startActivity(si);
        }
    }

    /**
     * Which series.
     *@param view the view
     *short description- Checking if the switch is checked or not. checked= numerical sequence, not checked= geometric progression.
     */
    public void whichSeries(View view) {
        if (sw.isChecked()) {
            whichS.setText("  numerical sequence");
            x = 1;
        } else{
            whichS.setText("  geometric progression");
            x = 2;
        }
    }

    /**
     * Goes to the credits activity.
     * @param view the view
     */
    public void credits(View view) {
        Intent si= new Intent(this, creditsActivity.class);
        startActivity(si);
    }
}

