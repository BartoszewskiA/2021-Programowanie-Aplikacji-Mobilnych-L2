package com.example.lab08p01_gesty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    GestureDetector detektorGestow;
    TextView licznik;
    int l=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detektorGestow = new GestureDetector(this,this);
        licznik = findViewById(R.id.licznik);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detektorGestow.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    double malyKrok = 0;
    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

//       float dy = motionEvent1.getY() - motionEvent.getY();
//
//       if (dy<0)
//           malyKrok+=0.25;
//       else
//           malyKrok-=0.25;
//
//        if (malyKrok>=1 || malyKrok<=-1)
//        {
//            if (dy<0)
//                l++;
//            else
//                l--;
//            licznik.setText(String.valueOf(l));
//            malyKrok=0;
//        }

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        l=0;
        licznik.setText(String.valueOf(l));
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        float dy = motionEvent1.getY() - motionEvent.getY();
        float dx = motionEvent1.getX() - motionEvent.getX();

        if(Math.abs(dx)>Math.abs(dy))
        {
            if (dx>0)
                l++;
            else
                l--;
        }
        else
        {
            if (dy<0)
                l+=10;
            else
                l-=10;
        }

        licznik.setText(String.valueOf(l));
        //licznik.setText("dx="+dx+"\ndy="+dy);

        return false;
    }

}