package com.example.barchart_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BarEntry> arrayList;
    ArrayList<String> agentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarChart doneRankChart= findViewById(R.id.barChart);
        arrayList = new ArrayList();
        agentName = new ArrayList<>();

        arrayList.add(new BarEntry(1,100));
        arrayList.add(new BarEntry(2,200));
        arrayList.add(new BarEntry(3,300));
        arrayList.add(new BarEntry(4,400));
        arrayList.add(new BarEntry(5,500));

        agentName.add("");
        agentName.add("Sumon");
        agentName.add("Raju");
        agentName.add("Jahangir");
        agentName.add("Hashem");
        agentName.add("Pervej");
        agentName.add("");

        BarDataSet bardataset = new BarDataSet(arrayList, "Leaderboard");
        doneRankChart.animateY(2000);
        BarData data = new BarData(bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        doneRankChart.setData(data);

        XAxis xAxis=doneRankChart.getXAxis();
        xAxis.setLabelCount(agentName.size());
        xAxis.setValueFormatter(new IndexAxisValueFormatter(agentName));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
//        doneRankChart.getXAxis().setValueFormatter(agentName);
        doneRankChart.getXAxis().setAxisMinValue(0f);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setLabelRotationAngle(270);
        xAxis.setGranularity(1f);
        doneRankChart.invalidate();
    }
}