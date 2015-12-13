package com.dasheck.calendarwidget.fragments.calendar;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.activities.MainActivity;
import com.dasheck.calendarwidget.adapters.DateAdapter;
import com.dasheck.calendarwidget.annotations.Layout;
import com.dasheck.calendarwidget.fragments.BaseFragment;
import com.dasheck.calendarwidget.fragments.create_event.CreateEventFragment;
import com.dasheck.calendarwidget.fragments.create_event.CreateEventView;
import com.dasheck.data.models.Date;
import java.util.List;

/**
 * Created by dasheck on 12/13/15.
 */
@Layout(R.layout.fragment_calendar)
public class CalendarFragment extends BaseFragment implements CalendarView,
    DateAdapter.OnDateClickListener {

  private CalendarPresenter presenter;
  private DateAdapter dateAdapter;

  @Bind(R.id.calendarList) RecyclerView calendarList;
  @Bind(R.id.dateTextView) TextView dateTextView;

  public static CalendarFragment newInstance() {
    return new CalendarFragment();
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter = new CalendarPresenterImpl(this);
    presenter.initializeViews();
    presenter.selectCurrentDate();
  }

  @OnClick(R.id.previousMonthButton) public void onPreviousMonthButtonClicked(View view) {
      presenter.loadPreviousMonth();
  }

  @OnClick(R.id.nextMonthButton) public void onNextMonthButtonClicked(View view) {
      presenter.loadNextMonth();
  }

  @Override public void bindAdapter() {
    dateAdapter = new DateAdapter(getContext());
    dateAdapter.setOnDateClickListener(this);

    calendarList.setHasFixedSize(true);
    calendarList.setLayoutManager(new GridLayoutManager(getContext(), 7));
    calendarList.setAdapter(dateAdapter);
  }

  @Override public void updateCalendar(List<Date> dates) {
    dateAdapter.clear();
    dateAdapter.addAll(dates);
  }

  @Override public void setMonthAndYear(String caption) {
    dateTextView.setText(caption);
  }

  @Override public void clearSelection() {
    dateAdapter.clearSelection();
  }

  @Override public void loadEventScreenForDate(long timestamp) {
    CreateEventFragment fragment = CreateEventFragment.newInstance(timestamp);
    ((MainActivity) getActivity()).transist(fragment);
  }

  @Override public void onDateClick(int position) {
    Date date = dateAdapter.get(position);
    presenter.chooseDate(date);
  }
}
