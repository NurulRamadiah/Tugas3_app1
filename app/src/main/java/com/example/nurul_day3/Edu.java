package com.example.nurul_day3;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Edu extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listEdu = new String[] {
                "Universitas Jambi", "Universitas Batanghari", "STIE GK", "STAI", "Universitas Muhammadiyah Jambi"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listEdu));
    }

    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanPilihan(pilihan);
    }

    private void tampilkanPilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Universitas Jambi")) {
                a = new Intent(this, EduSection.class);
            }
            else if (pilihan.equals("Universitas Batanghari")) {

            }

            startActivity(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
