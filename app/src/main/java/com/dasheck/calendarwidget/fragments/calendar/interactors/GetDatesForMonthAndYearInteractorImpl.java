package com.dasheck.calendarwidget.fragments.calendar.interactors;

import com.dasheck.data.models.Date;
import com.dasheck.data.utilities.DateUtilities;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by dasheck on 12/13/15.
 */
public class GetDatesForMonthAndYearInteractorImpl implements GetDatesForMonthAndYearInteractor {

  @Override public Observable<List<Date>> execute(int month, int year) {
    return Observable.create(new Observable.OnSubscribe<List<Date>>() {
      @Override public void call(Subscriber<? super List<Date>> subscriber) {
        List<Date> result = new ArrayList<Date>();

        for(int i = 1; i < DateUtilities.getFirstWeekdayOfMonth(month, year) - 1; i++) {
          result.add(new Date(0, false, null));
        }

        for (int i = 1; i < DateUtilities.getNumberOfDaysInMonth(month, year) + 1; i++) {
          result.add(new Date(DateUtilities.dateToUnix(i, month, year), true, null));
        }

        subscriber.onNext(result);
        subscriber.onCompleted();
      }
    });
  }
}
