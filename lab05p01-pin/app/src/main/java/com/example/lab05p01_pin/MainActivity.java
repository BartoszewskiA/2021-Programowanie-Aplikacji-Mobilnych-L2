package com.example.lab05p01_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] tablicaMieszajaca;
    Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p0;
    TextView dostep;
    View.OnClickListener sluchacz;
    String pass ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        utworzTablice();
        znajdzUchwytyKontrolek();
        dodajEtykietyPrzycisków();
        utworzSluchaczaZdarzen();
        dodajSluchaczaZdarzen();
    }



    private void utworzSluchaczaZdarzen() {
        sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = view.getId();
            switch (Id)
            {
                case R.id.button00: pass+=String.valueOf(tablicaMieszajaca[0]); sprawdz(); break;
                case R.id.button01: pass+=String.valueOf(tablicaMieszajaca[1]); sprawdz(); break;
                case R.id.button02: pass+=String.valueOf(tablicaMieszajaca[2]); sprawdz(); break;
                case R.id.button03: pass+=String.valueOf(tablicaMieszajaca[3]); sprawdz(); break;
                case R.id.button04: pass+=String.valueOf(tablicaMieszajaca[4]); sprawdz(); break;
                case R.id.button05: pass+=String.valueOf(tablicaMieszajaca[5]); sprawdz(); break;
                case R.id.button06: pass+=String.valueOf(tablicaMieszajaca[6]); sprawdz(); break;
                case R.id.button07: pass+=String.valueOf(tablicaMieszajaca[7]); sprawdz(); break;
                case R.id.button08: pass+=String.valueOf(tablicaMieszajaca[8]); sprawdz(); break;
                case R.id.button09: pass+=String.valueOf(tablicaMieszajaca[9]); sprawdz(); break;
            }
            }
        };
    }

    private void sprawdz() {
        if (pass.equals("1234")) dostep.setText("OK");
    }


    private void znajdzUchwytyKontrolek() {
        p1 = findViewById(R.id.button01);
        p2 = findViewById(R.id.button02);
        p3 = findViewById(R.id.button03);
        p4 = findViewById(R.id.button04);
        p5 = findViewById(R.id.button05);
        p6 = findViewById(R.id.button06);
        p7 = findViewById(R.id.button07);
        p8 = findViewById(R.id.button08);
        p9 = findViewById(R.id.button09);
        p0 = findViewById(R.id.button00);
        dostep = findViewById(R.id.dostep);
    }

    private void dodajEtykietyPrzycisków() {
        p0.setText(String.valueOf(tablicaMieszajaca[0]));
        p1.setText(String.valueOf(tablicaMieszajaca[1]));
        p2.setText(String.valueOf(tablicaMieszajaca[2]));
        p3.setText(String.valueOf(tablicaMieszajaca[3]));
        p4.setText(String.valueOf(tablicaMieszajaca[4]));
        p5.setText(String.valueOf(tablicaMieszajaca[5]));
        p6.setText(String.valueOf(tablicaMieszajaca[6]));
        p7.setText(String.valueOf(tablicaMieszajaca[7]));
        p8.setText(String.valueOf(tablicaMieszajaca[8]));
        p9.setText(String.valueOf(tablicaMieszajaca[9]));
    }

    private void dodajSluchaczaZdarzen() {
        p1.setOnClickListener(sluchacz);
        p2.setOnClickListener(sluchacz);
        p3.setOnClickListener(sluchacz);
        p4.setOnClickListener(sluchacz);
        p5.setOnClickListener(sluchacz);
        p6.setOnClickListener(sluchacz);
        p7.setOnClickListener(sluchacz);
        p8.setOnClickListener(sluchacz);
        p9.setOnClickListener(sluchacz);
        p0.setOnClickListener(sluchacz);
    }

    private void utworzTablice() {
        tablicaMieszajaca = new int[10];
        Random random = new Random();
        boolean powtorzenie = false;
        int poz = 0;
        while(poz<10)
        {
            do {
                tablicaMieszajaca[poz] = random.nextInt(10);
                powtorzenie = false;
                for (int i=0; i<poz ; i++)
                    if (tablicaMieszajaca[i]==tablicaMieszajaca[poz])
                        powtorzenie = true;
            } while(powtorzenie);
            poz++;
        }

    }
}