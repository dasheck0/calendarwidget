package com.dasheck.calendarwidget.fragments.calendar;

import com.dasheck.calendarwidget.fragments.Presenter;

/**
 * Created by dasheck on 12/13/15.
 */
public interface CalendarPresenter extends Presenter {

  void selectCurrentDate();

  void loadPreviousMonth();

  void loadNextMonth();
}
