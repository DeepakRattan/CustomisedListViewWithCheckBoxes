package com.example.deepakrattan.customisedlistviewwithcheckboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private SingleRow singleRow;
    private ArrayList<SingleRow> singleRowArrayList;
    private MyAdapter adapter;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        singleRowArrayList = new ArrayList<>();


        //Data Source
        int[] id = {1, 2, 3, 4, 5};
        String[] name = {"Ravi", "Ramesh", "Raj", "Ashu", "naman"};
        for (int i = 0; i < name.length; i++) {
            singleRow = new SingleRow(name[i], id[i]);
            singleRowArrayList.add(singleRow);
        }

        adapter = new MyAdapter(this, singleRowArrayList);
        lv.setAdapter(adapter);

       /* btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "Selected items are ";
                for (SingleRow s : adapter.getCheckedBox()) {
                    if (s.box) {
                        result += singleRow.getName();
                    }
                }
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });*/

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer("Selected names Are ");

                ArrayList<SingleRow> chkArrayList = adapter.getChkBoxArrayList();
                for (SingleRow s : chkArrayList) {
                    String name = s.getName();
                    buffer.append(name + ", ");
                }
                Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
