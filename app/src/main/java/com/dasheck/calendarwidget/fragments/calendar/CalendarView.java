package com.dasheck.calendarwidget.fragments.calendar;

import com.dasheck.calendarwidget.fragments.BaseView;
import com.dasheck.data.models.Date;
import java.util.List;

/**
 * Created by dasheck on 12/13/15.
 */
public interface CalendarView extends BaseView {

  void bindAdapter();

  void updateCalendar(List<Date> dates);

  void setMonthAndYear(String caption);
}
