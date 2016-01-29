package com.example.artests.l35ownview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //private MyWidgetView mWidget1, mWidget2, mWidget3;
    private CircleView mWidget1, mWidget2, mWidget3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        TouchCircle touchCircle = new TouchCircle(this);
        setContentView(touchCircle);
        /*mWidget1 = (MyWidgetView)findViewById(R.id.mywidget1);
        mWidget2 = (MyWidgetView)findViewById(R.id.mywidget2);
        mWidget3 = (MyWidgetView)findViewById(R.id.mywidget3);

        mWidget2.setColor(Color.RED);
        mWidget3.setBackgroundColor(Color.GREEN);
        mWidget3.setColor(Color.BLUE);*/
        /*mWidget1 = (CircleView)findViewById(R.id.mywidget1);
        mWidget2 = (CircleView)findViewById(R.id.mywidget2);
        mWidget3 = (CircleView)findViewById(R.id.mywidget3);

        mWidget2.setColor(Color.YELLOW);
        mWidget3.setColor(Color.BLUE);*/
    }
}
