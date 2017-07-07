package com.example.xps.testocto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

/*public class MainActivity extends AppCompatActivity {
    Intent intent;
    EditText editText;
    Button button;
    TextView textView;
    LineChart chart ;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView);
        barChart=(BarChart)findViewById(R.id.bar);

        chart = (LineChart) findViewById(R.id.chart);
        lunchBart();

        //lunchLine();
        chart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                textView.setText("mouvement");

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                textView.setText("fin mouvement");
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {
                textView.setText("double touch");
            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });

    }
    public void  lunchLine()
    {
        final String[] quarters = new String[] { "Q1", "Q2", "Q3", "Q4" };



        chart .getXAxis().setAxisMaximum(20);
        chart.getXAxis().setGridColor(R.color.colorPrimary);
        chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Data[] tab=new Data[3];
        tab[0]=new Data(0f,10000f);
        tab[1]=new Data(1f,14000f);
        tab[2]=new Data(3f,20000f);
        List<Entry> entries = new ArrayList<Entry>();

        for (Data data : tab) {

            // turn your data into Entry objects
            entries.add(new Entry(data.getX(), data.getY()));

        }

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(R.color.colorPrimary);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        chart.invalidate(); // refresh

    }
    void lunchBart()
    {
        /*XAxis xAxis=barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);

        List<BarEntry> entries=new ArrayList<BarEntry>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData barData=new BarData(set);
        barData.setBarWidth(0.9f);


        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(barChart);
        xAxis.setValueFormatter(xAxisFormatter);

        IAxisValueFormatter custom = new MyAxisValueFormatter();

        YAxis leftAxis = barChart.getAxisLeft();
        //leftAxis.setTypeface(mTfLight);
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f);
       // barChart.setData(barData);
        barChart.setFitBars(true);
        setData(12, 50);

        barChart.invalidate();
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.setData(data);
       // barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.getXAxis().setAxisMinimum(0f);
        chart.invalidate(); // refresh
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void setData(int count, float range) {

        float start = 0f;

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();





                yVals1.add(new BarEntry(0, 10f));
        yVals1.add(new BarEntry(1, 20f));
        yVals1.add(new BarEntry(2, 80f));
        yVals1.add(new BarEntry(3, 90f));
        yVals1.add(new BarEntry(4, 110f));
        yVals1.add(new BarEntry(11, 150f));


        BarDataSet set1;

        if (barChart.getData() != null &&
                barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "The year 2017");

            set1.setDrawIcons(false);

            set1.setColors(ColorTemplate.MATERIAL_COLORS);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            barChart.setData(data);
        }
    }

    protected RectF mOnValueSelectedRectF = new RectF();

    @SuppressLint("NewApi")

    public void onValueSelected(Entry e, Highlight h) {

        if (e == null)
            return;

        RectF bounds = mOnValueSelectedRectF;
        barChart.getBarBounds((BarEntry) e, bounds);
        MPPointF position = barChart.getPosition(e, YAxis.AxisDependency.LEFT);

        Log.i("bounds", bounds.toString());
        Log.i("position", position.toString());

        Log.i("x-index",
                "low: " + barChart.getLowestVisibleX() + ", high: "
                        + barChart.getHighestVisibleX());

        MPPointF.recycleInstance(position);
    }
}*/


    public class MainActivity extends AppCompatActivity {
        private final int itemcount = 12;
        String[] tab={"janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};

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
            chart.getXAxis().setValueFormatter(new MyAxisValueFormatter(tab));
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


