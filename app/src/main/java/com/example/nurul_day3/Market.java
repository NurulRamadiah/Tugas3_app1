package com.example.nurul_day3;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Market extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listMarket = new String[] {
                "Pasar Keramat Tinggi", "BBC"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMarket));
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
            if (pilihan.equals("Pasar Keramat Tinggi")) {
                a = new Intent(this, MarketSection.class);
            }
            else if (pilihan.equals("BBC")) {

            }

            startActivity(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
