package com.example.nurul_day3;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSSection extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listMitraSect = new String[] {
                "Call", "Message", "Directions", "Website", "Google Info", "Exit"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMitraSect));
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
                String telephone = "tel:074321777";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(telephone));
            }
            else if (pilihan.equals("Message")) {
                String smsText = "Nama : \n" + "Keluhan : ";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:080101112021"));
                a.putExtra("sms_body", smsText);
            }
            else if (pilihan.equals("Directions")) {
                String lokasi = "https://goo.gl/maps/Zzm5tnZWv1YvKke1A";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasi));
            }
            else if (pilihan.equals("Website")) {
                String web = "https://play.google.com/store/apps/details?id=com.rsmmb.user.rsmmbonline&hl=en&gl=US";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            }
            else if (pilihan.equals("Google Info")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Mitra Medika Batanghari Hospital");
            }

            startActivity(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
