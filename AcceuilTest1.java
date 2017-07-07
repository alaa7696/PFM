package com.octo.app.charts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final int itemcount = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CombinedChart chart = (CombinedChart)findViewById(R.id.chart);
        chart.setDrawGridBackground(true);
        chart.setDrawOrder(new CombinedChart.DrawOrder[]{CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE});
        CombinedData data = new CombinedData();
        BarData bd = generatePNdata();
        data.setData(bd);
        BarDataSet x = (BarDataSet)bd.getDataSetByIndex(0);
        List<BarEntry> y = x.getValues();
        data.setData(generateLineData(y));
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setData(data);
        chart.getXAxis().setAxisMinimum(-0.5f);
        chart.getXAxis().setAxisMaximum(chart.getXChartMax()+0.5f);
        chart.setDrawValueAboveBar(false);
        chart.getLegend().setEnabled(false);
        chart.setVisibleXRangeMaximum(7);
        chart.invalidate();

    }

    private BarData generatePNdata() {
        ArrayList<BarEntry> x = new ArrayList<>();
        List<Integer> colors = new ArrayList<Integer>();
        int green = Color.rgb(110, 190, 102);
        int red = Color.rgb(211, 74, 88);

        for (int index = 0; index < itemcount; index++) {
            x.add(new BarEntry(index, getRandom(15, 1)));
            colors.add(green);
            x.add(new BarEntry(index, -getRandom(15, 1)));
            colors.add(red);
        }

        BarDataSet set = new BarDataSet(x,"values");
        set.setColors(colors);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);
        data.setDrawValues(false);
        return data;



    }


    private LineData generateLineData(List<BarEntry> y) {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<Entry>();
        int i = 0;
        for (int index = 0; i < y.size()-1; index++,i=i+2)
            entries.add(new Entry(index,(y.get(i).getY()+y.get(i+1).getY())/2));

        LineDataSet set = new LineDataSet(entries, "Line DataSet");
        set.setColor(Color.rgb(249, 175, 47));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setDrawValues(false);

        d.addDataSet(set);

        return d;
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }


}
