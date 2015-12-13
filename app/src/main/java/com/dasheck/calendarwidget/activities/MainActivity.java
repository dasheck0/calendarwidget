package com.dasheck.calendarwidget.activities;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dasheck.calendarwidget.BuildConfig;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.adapters.DateAdapter;
import com.dasheck.calendarwidget.controllers.LollipopTransitionControllerImpl;
import com.dasheck.calendarwidget.controllers.TransitionController;
import com.dasheck.calendarwidget.controllers.TransitionControllerImpl;
import com.dasheck.calendarwidget.fragments.calendar.CalendarFragment;
import com.dasheck.calendarwidget.fragments.calendar.CalendarPresenter;
import com.dasheck.calendarwidget.models.HeroItem;
import com.dasheck.data.models.Date;
import com.dasheck.data.models.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  private TransitionController transitionController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    createTransitionController();
    loadInitialFragment();
  }

  private void createTransitionController() {
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
      transitionController = new TransitionControllerImpl(this, R.id.fragmentContainer);
    } else {
      transitionController = new LollipopTransitionControllerImpl(this, R.id.fragmentContainer);
    }
  }

  private void loadInitialFragment() {
    transist(CalendarFragment.newInstance(), new ArrayList<>());
  }

  public void transist(Fragment fragment, List<HeroItem> heroElements) {
    transitionController.transist(fragment, heroElements);
  }
}