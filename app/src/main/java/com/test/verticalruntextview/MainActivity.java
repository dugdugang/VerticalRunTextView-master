package com.test.verticalruntextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieView pieView;
    private ArrayList<PieData> pieDatas;
//    private CheckView testView;
    private BezierView bezierView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bezierView= (BezierView) findViewById(R.id.bezier);
//        testView = (CheckView) findViewById(R.id.test);
//        pieView = (PieView) findViewById(R.id.pieview);
//        pieDatas = new ArrayList<>();
//        for (int i = 1; i < 6; i++) {
//            pieDatas.add(new PieData(i + "", i * 100));
//        }
//        pieView.setPieDatas(pieDatas);
    }

    public void c1(View view) {
        bezierView.setFlag(0);
    }

    public void c2(View view) {
        bezierView.setFlag(1);

    }

//    public void onShow(View view) {
//        testView.check();
//    }
//
//    public void onHide(View view) {
//        testView.unCheck();
//
//    }
}
