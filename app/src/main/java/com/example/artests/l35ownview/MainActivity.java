package com.example.artests.l35ownview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private MyWidgetView mWidget1, mWidget2, mWidget3;
    private ShapeView mShapeView;
    private CircleView mWidget1, mWidget2, mWidget3;
    private LineView mLineView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mShapeView = (ShapeView) findViewById(R.id.shapeView);
        //TouchCircle touchCircle = new TouchCircle(this);
        //setContentView(touchCircle);
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
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Вы выбрали: " +
                mShapeView.getSelectedShape(), Toast.LENGTH_LONG).show();
    }
}
