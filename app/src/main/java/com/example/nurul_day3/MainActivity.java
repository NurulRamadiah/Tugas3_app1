package com.example.nurul_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void sectionRS(View view) {
        Intent i = new Intent(this,RS.class);
        startActivity(i);
    }

    public void sectionPol(View view) {
        Intent i = new Intent(this,Police.class);
        startActivity(i);
    }

    public void sectionMarket(View view) {
        Intent i = new Intent(this, Market.class);
        startActivity(i);
    }

    public void sectionEdu(View view) {
        Intent i = new Intent(this, Edu.class);
        startActivity(i);
    }
}