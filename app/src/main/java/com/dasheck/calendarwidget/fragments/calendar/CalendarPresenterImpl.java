package com.dasheck.calendarwidget.fragments.calendar;

import android.util.Log;
import android.util.Pair;
import com.dasheck.calendarwidget.fragments.BasePresenterImpl;
import com.dasheck.calendarwidget.fragments.calendar.interactors.GetDatesForMonthAndYearInteractor;
import com.dasheck.calendarwidget.fragments.calendar.interactors.GetDatesForMonthAndYearInteractorImpl;
import com.dasheck.calendarwidget.models.HeroItem;
import com.dasheck.data.models.Date;
import com.dasheck.data.utilities.DateUtilities;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by dasheck on 12/13/15.
 */
public class CalendarPresenterImpl extends BasePresenterImpl implements CalendarPresenter {

  private CalendarView view;
  private GetDatesForMonthAndYearInteractor getDatesForMonthAndYearInteractor;

  private int currentMonth;
  private int currentYear;

  public CalendarPresenterImpl(CalendarView view) {
    this.view = view;
    this.getDatesForMonthAndYearInteractor = new GetDatesForMonthAndYearInteractorImpl();
  }

  @Override public void initializeViews() {
    view.bindAdapter();
  }

  @Override public void selectCurrentDate() {
    Pair<Integer, Integer> monthAndYear = DateUtilities.getCurrentMonthAndYear();
    currentMonth = monthAndYear.first;
    currentYear = monthAndYear.second;

    loadCurrentCalendar();
  }

  @Override public void loadPreviousMonth() {
    currentMonth -= 1;
    sanitizeMonthAndYear();
    loadCurrentCalendar();
  }

  @Override public void loadNextMonth() {
    currentMonth += 1;
    sanitizeMonthAndYear();
    loadCurrentCalendar();
  }

  @Override public void chooseDate(HeroItem heroItem, Date date) {
    if(date.getEvent() == null) {
      view.loadEventCreationScreenForDate(heroItem, date.getTimestamp());
    } else {
      view.loadEventScreenForDate(heroItem, date.getTimestamp());
    }
  }

  private void loadCurrentCalendar() {
    getDatesForMonthAndYearInteractor.execute(currentMonth, currentYear).subscribe(dates -> {
          view.clearSelection();
          view.setMonthAndYear(DateUtilities.getCaptionFromMonthAndYear(currentMonth, currentYear));
          view.updateCalendar(dates);
        }
    );
  }

  private void sanitizeMonthAndYear() {
    if(currentMonth == -1) {
      currentMonth = 11;
      currentYear -= 1;
    } else if(currentMonth == 12) {
      currentMonth = 0;
      currentYear += 1;
    }
  }
}
