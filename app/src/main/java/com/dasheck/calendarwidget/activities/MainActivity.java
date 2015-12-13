package com.dasheck.calendarwidget.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.adapters.DateAdapter;
import com.dasheck.data.models.Date;
import com.dasheck.data.models.Event;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DateAdapter.OnDateClickListener {

  @Bind(R.id.calendarList) RecyclerView calendarList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);


    DateAdapter adapter = new DateAdapter(this);
    adapter.setOnDateClickListener(this);

    calendarList.setHasFixedSize(true);
    calendarList.setLayoutManager(new GridLayoutManager(this, 7));
    calendarList.setAdapter(adapter);

    List<Date> dates = new ArrayList<>();

    for(int i = 0; i < 5; i ++) {
      dates.add(new Date(0, false, null));
    }

    for(int i = 0; i < 31; i ++) {
      Event event = null;
      if(i % 10 == 0) {
        event = new Event();
      }
      dates.add(new Date(i*86400 + 1446332400, true, event));
    }

    adapter.addAll(dates);
  }

  @Override public void onDateClick(int position) {
    Log.d("TAG", "Clicked: " + position);
  }
}