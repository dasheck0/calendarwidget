package com.dasheck.calendarwidget.fragments.calendar;

import com.dasheck.calendarwidget.fragments.Presenter;
import com.dasheck.calendarwidget.models.HeroItem;
import com.dasheck.data.models.Date;

/**
 * Created by dasheck on 12/13/15.
 */
public interface CalendarPresenter extends Presenter {

  void selectCurrentDate();

  void loadPreviousMonth();

  void loadNextMonth();

  void chooseDate(HeroItem heroItem, Date date);
}
