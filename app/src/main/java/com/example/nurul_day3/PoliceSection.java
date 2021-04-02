package com.example.nurul_day3;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PoliceSection extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listPolresSect = new String[] {
                "Call", "Message", "Directions", "Website", "Google Info", "Exit"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPolresSect));
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
            if (pilihan.equals("Call")) {
                String telephone = "tel:074321280";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(telephone));
            }
            else if (pilihan.equals("Message")) {
                String smsText = "Nama : \n" + "Laporan : ";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:080101112021"));
                a.putExtra("sms_body", smsText);
            }
            else if (pilihan.equals("Directions")) {
                String lokasi = "https://goo.gl/maps/XF6tuBKpacK97U2D9";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasi));
            }
            else if (pilihan.equals("Website")) {
                String web = "http://polresbatanghari.jambi.polri.go.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            }
            else if (pilihan.equals("Google Info")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Polres Batanghari");
            }

            startActivity(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
