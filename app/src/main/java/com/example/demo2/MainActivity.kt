package com.example.demo2

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import android.R.attr.data
import android.graphics.Color
import android.widget.Button
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn : Button = findViewById(R.id.button)
        btn.setOnClickListener()
        {
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
        }
        var chart : LineChart = findViewById(R.id.chart)
        var bar : BarChart = findViewById(R.id.bar)
        var pie : PieChart = findViewById(R.id.pie)

        val entries: ArrayList<Entry> = ArrayList()
        val barEntries: ArrayList<BarEntry> = ArrayList()
        val pieEntries: ArrayList<PieEntry> = ArrayList()


        for (i in 1..10)
        {
            var example1 = Example()
            example1.x = i.toFloat()
            example1.y = Math.random().toFloat()
            entries.add(Entry(example1.x, example1.y))
            barEntries.add(BarEntry(example1.x, example1.y))
            pieEntries.add(PieEntry(example1.x, if (i % 2 == 0)  "even" else "odd"))
        }


         var dataSet : LineDataSet = LineDataSet(entries, "Example Label"); // add entries to dataset
        dataSet.setColor(Color.RED)
        dataSet.setValueTextColor(Color.BLACK) // styling, ...
        val set = BarDataSet(barEntries, "BarDataSet")
        var pieset = PieDataSet(pieEntries, "Yum Pie :)")
        pieset.color = Color.RED

        val barData = BarData(set)
        val lineData = LineData(dataSet)
        var pieData = PieData(pieset)
        chart.data = lineData
        chart.invalidate() // refresh
        bar.data = barData
        bar.invalidate()
        pie.data = pieData
        pie.invalidate()
    }
}

class Example{
    var x = 0F
    var y = 0F
}

