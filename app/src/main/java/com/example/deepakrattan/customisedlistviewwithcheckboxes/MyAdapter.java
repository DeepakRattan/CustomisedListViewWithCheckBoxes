package com.example.deepakrattan.customisedlistviewwithcheckboxes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by deepak.rattan on 5/11/2017.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SingleRow> singleRowArrayList;
    private LayoutInflater inflater;
    private ArrayList<SingleRow> chkBoxArrayList;
    private SingleRow s;

    public MyAdapter(Context context, ArrayList<SingleRow> singleRowArrayList) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
    }

    @Override
    public int getCount() {
        return singleRowArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return singleRowArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.single_row, viewGroup, false);


        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.chk);


        final SingleRow singleRow = singleRowArrayList.get(i);


        txtName.setText(singleRow.getName());


        checkBox.setOnCheckedChangeListener(myChecked);
        checkBox.setTag(i);
        checkBox.setChecked(singleRow.checked);

        chkBoxArrayList = new ArrayList<>();

        return view;
    }

    SingleRow getSingleRow(int pos) {
        return ((SingleRow) getItem(pos));
    }

    /*ArrayList<SingleRow> getCheckedBox() {
        ArrayList<SingleRow> chkBox = new ArrayList<>();
        for (SingleRow s : singleRowArrayList) {
            if (s.box) {
                chkBox.add(s);
            }
        }

        return chkBox;
    }*/
    ArrayList<SingleRow> getChkBoxArrayList() {
        return chkBoxArrayList;
    }

    CompoundButton.OnCheckedChangeListener myChecked = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            // getSingleRow((Integer) compoundButton.getTag()).box = b;
            if (b) {
                int pos = (int) compoundButton.getTag();
                s = singleRowArrayList.get(pos);
                s.setChecked(b);
                chkBoxArrayList.add(s);
            } else {
                int pos = (int) compoundButton.getTag();
                s = singleRowArrayList.get(pos);
                /*s.setChecked(b);
                chkBoxArrayList.remove(pos);*/
                if (chkBoxArrayList.contains(s)) {
                    chkBoxArrayList.remove(s);
                }
            }
        }
    };
}
