package com.example.deepakrattan.customisedlistviewwithcheckboxes;

/**
 * Created by deepak.rattan on 5/11/2017.
 */

public class SingleRow {

    private String name;
    private int id;
    boolean checked;

    public SingleRow(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
