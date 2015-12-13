package com.dasheck.calendarwidget.fragments.calendar.interactors;

import com.dasheck.data.models.Date;
import java.util.List;
import rx.Observable;

/**
 * Created by dasheck on 12/13/15.
 */
public interface GetDatesForMonthAndYearInteractor {

  Observable<List<Date>> execute(int month, int year);
}
