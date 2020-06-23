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

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> levelsNames;

    ArrayList<monthSalesData> monthSalesDataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = findViewById(R.id.barChart);

        barEntryArrayList = new ArrayList<>();
        levelsNames = new ArrayList<>();
        fillMonthSales();
        for(int i = 0; i<monthSalesDataArrayList.size(); i++){
            String month = monthSalesDataArrayList.get(i).getMonth();
            int sales = monthSalesDataArrayList.get(i).getSales();
            barEntryArrayList.add(new BarEntry(i, sales));
            levelsNames.add(month);
        }
        BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "Monthly Sales");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Description description = new Description();
        description.setText("Months");
        barChart.setDescription(description);
        BarData barData = new BarData();
        barChart.setData(barData);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(levelsNames));
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(levelsNames.size());
        xAxis.setLabelRotationAngle(270);
        barChart.animateY(2000);
        barChart.invalidate();


    }
   private void fillMonthSales(){
        monthSalesDataArrayList.clear();
        monthSalesDataArrayList.add(new monthSalesData("January, 2020", 225000));
       monthSalesDataArrayList.add(new monthSalesData("February, 2020", 215000));
       monthSalesDataArrayList.add(new monthSalesData("March, 2020", 185000));
       monthSalesDataArrayList.add(new monthSalesData("April, 2020", 375000));
       monthSalesDataArrayList.add(new monthSalesData("may, 2020", 140000));
       monthSalesDataArrayList.add(new monthSalesData("June, 2020", 260000));
       monthSalesDataArrayList.add(new monthSalesData("July, 2020", 125000));
       monthSalesDataArrayList.add(new monthSalesData("August, 2020", 295000));
   }
}