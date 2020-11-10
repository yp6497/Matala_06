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

public class nextActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {

    ListView lv;
    TextView wa, whc, m, c;
    String xisovS;
    float a, hc, xisov, num, sum = 0;
    int x, y;


    String[] eivar = new String[20];
    Float[] sumA = new Float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        lv = findViewById(R.id.lv);
        wa = findViewById(R.id.wa);
        whc = findViewById(R.id.wh);
        m = findViewById(R.id.m);
        c = findViewById(R.id.c);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnCreateContextMenuListener(this);

        registerForContextMenu(lv);

        start();

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, eivar);
        lv.setAdapter(adp);

        for (int i = 0; i < 20; i++) {
            if (x == 1) {
                if (i == 0) {
                    xisov = num;
                    sum = num;
                } else {
                    xisov = num + hc;
                    sum = sum + xisov;
                }

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

    private void start() {

        Intent gi = getIntent();
        x = gi.getIntExtra("x", 1);
        a = gi.getFloatExtra("a", 1);
        hc = gi.getFloatExtra("h", 1);
        num = a;
        //wa.setText("x1=" + a);
        //if (x == 1) whc.setText("d=" + hc);
        //else whc.setText("q=" + hc);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // itemLayout.setLongClickable(true);

        //c.setText("Sn=" + sumA[position]);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        //if (v.getId() == R.id.lv) {
          //  ListView lv = (ListView) v;
            //AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            //Cont cM = (ContextMenu) lv.getItemAtPosition(acmi.position);


        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater= getMenuInflater();
            menu.setHeaderTitle("Math Operations");
            menu.add("sum");
            menu.add("difference");
            //menu.add(cM.name);


        }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String inf = item.getTitle().toString();
        y = (info.position )+ 1;
        if (info.equals("sum")) {

            wa.setText("index " + y);
            return true;
        }
        return super.onContextItemSelected(item);

    }

        public void finis(View view) {
        finish();
    }
}
