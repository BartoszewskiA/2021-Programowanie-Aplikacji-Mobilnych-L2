package com.example.lab04p01_atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ramka;
    TextView opis;
    int pozycja = 0;
    int[] obrazki = new int[] {
            R.drawable.prawdziwek,
            R.drawable.pieczarka,
            R.drawable.muchomor
    };
    String[] opisy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opis = findViewById(R.id.opis);
        ramka = findViewById(R.id.ramka);
        ramka.setImageResource(obrazki[pozycja]);
        opisy = getResources().getStringArray(R.array.opisy);
        opis.setText(opisy[pozycja]);
    }

    public void przesun_przod(View view) {
        pozycja++;
        if (pozycja>2) pozycja=0;
        ramka.setImageResource(obrazki[pozycja]);
        opis.setText(opisy[pozycja]);
    }

    public void przesun_wst(View view) {
        pozycja--;
        if (pozycja<0) pozycja=2;
        ramka.setImageResource(obrazki[pozycja]);
        opis.setText(opisy[pozycja]);
    }
}