package com.example.lab06p01_kasyno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

   Random random;
   Spinner rodzaj_gry;
   ImageView ramka;
   TextView poleWylosowana, polePortfel, poleStawka;
   SeekBar suwak;
   int wylosowano;
   int portfel = 100;
   int stawka = 0;
   int gra =0;  //0 - parzyste
                //1 - nieparzyste
                //2 = podzielne przez 3
                //3 - podzielne przez 5
    int[] obrazki = new int[] {R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        rodzaj_gry = findViewById(R.id.rodzaj_gry);
        ramka = findViewById(R.id.ramka);
        poleWylosowana = findViewById(R.id.losowa);
        polePortfel = findViewById(R.id.portfel);
        poleStawka =  findViewById(R.id.stawka);
        suwak = findViewById(R.id.suwak);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                        getResources().getStringArray(R.array.rodzajeGier));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        rodzaj_gry.setAdapter(adapter);

        dodajSluchaczaSpinnera();
        dodajSluchaczaRamki();
        dodajSluchaczaSuwaka();

    }

    private void dodajSluchaczaSuwaka() {
        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                poleStawka.setText(String.valueOf(i));
                polePortfel.setText(String.valueOf(portfel-i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void dodajSluchaczaRamki() {
        ramka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wylosowano = random.nextInt(13) + 1;
                poleWylosowana.setText(String.valueOf(wylosowano));

                portfel = Integer.parseInt(polePortfel.getText().toString());
                stawka = Integer.parseInt(poleStawka.getText().toString());

                // tu sprawdzamy wygraną

                polePortfel.setText(String.valueOf(portfel));
                poleStawka.setText("0");

                suwak.setProgress(0);
                suwak.setMax(portfel);
            }
        });
    }

    private void dodajSluchaczaSpinnera() {
        rodzaj_gry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: gra=0; break;
                    case 1: gra=1; break;
                    case 2: gra=2; break;
                    case 3: gra=3; break;
                }
                ramka.setImageResource(obrazki[gra]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}