package com.dasheck.calendarwidget.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.adapters.DateAdapter;
import com.dasheck.calendarwidget.fragments.calendar.CalendarFragment;
import com.dasheck.calendarwidget.fragments.calendar.CalendarPresenter;
import com.dasheck.data.models.Date;
import com.dasheck.data.models.Event;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    loadInitialFragment();
  }

  void loadInitialFragment() {
    CalendarFragment fragment = CalendarFragment.newInstance();
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .addToBackStack(((Object) fragment).getClass().getName())
        .commit();
  }
}