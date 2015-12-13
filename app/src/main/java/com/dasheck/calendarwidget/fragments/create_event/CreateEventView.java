package com.dasheck.calendarwidget.fragments.create_event;

import com.dasheck.calendarwidget.fragments.BaseView;

/**
 * Created by dasheck on 12/13/15.
 */
public interface CreateEventView extends BaseView {

  void setDayNumber(int dayOfMonth);

  void showEventContainer();
}
