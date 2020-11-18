package com.example.matala_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author  Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version	 1.1
 * @since	9/11/2020
 * short description- Checking if the series is vh or jd and moves the information to the second activity.
 */
public class nextActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {


    ListView lv;
    TextView IorS;
    String xisovS;
    /**
     * The number which the series begin with.
     */
    float a,
    /**
     * The series Difference or multiplication.
     */
    hc,
    /**
     *  Calculates the organs.
     */
    xisov,
    num,
    /**
     *  Calculates the series sum.
     */
    sum = 0;
    /**
     *  Know which series was chosen.
     */
    int x,
    /**
     * The organ index.
     */
    index;
    /**
     * The array of organs in the series.
     */
    String[] eivar = new String[20];
    /**
     * The array of the sum in every organ in the series.
     */
    Float[] sumA = new Float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        lv = findViewById(R.id.lv);
        IorS = findViewById(R.id.wa);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnCreateContextMenuListener(this);
        registerForContextMenu(lv);

        Intent gi = getIntent();
        x = gi.getIntExtra("x", 1);
        a = gi.getFloatExtra("a", 1);
        hc = gi.getFloatExtra("hc", 1);
        num = a;

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, eivar);
        lv.setAdapter(adp);

        for (int i = 0; i < 20; i++) {
               /**
                * Calculates the numerical sequence.
               */
            if (x == 1) {
                if (i == 0) {
                    xisov = num;
                    sum = num;
                } else {
                    xisov = num + hc;
                    sum = sum + xisov;
                }

                /**
                 * Calculates the geometric progression.
                 */
            } else if (x == 2) {
                if (i == 0) {
                    xisov = num;
                    sum = num;
                } else {
                    xisov = num * hc;
                    sum = sum + xisov;
                }
            }
            sumA[i] = sum;
            xisovS = Float.toString(xisov);
            eivar[i] = xisovS;
            num = Float.parseFloat(eivar[i]);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    /**
     * description- Creates the menu.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu,v,menuInfo);
            menu.setHeaderTitle("Which information do you want to see?");
            menu.add("index");
            menu.add("sum");

        }

    /**
     * description- Checking which line in the menu was chosen and puts in the text view the information.
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String inf = item.getTitle().toString();
        index = (info.position );
        if (inf.equals("index")) {
            index= index+1;
            IorS.setText("The index: " + index);
            return true;
        }
        if(inf.equals("sum")) {
            IorS.setText("The sum: " + sumA[index]);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * Goes back to the main activity.
     * @param view the view
     */
    public void finis(View view) {
        finish();
    }
}
