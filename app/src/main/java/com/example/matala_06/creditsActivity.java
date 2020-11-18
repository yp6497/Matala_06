package com.example.matala_06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**
 * @author  Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version	 1.1
 * @since	9/11/2020
 * short description- the credits activity.
 */
public class creditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * Goes to the back to the main activity.
     * @param view the view
     */
    public void returnBack(View view) {
        finish();
    }
}