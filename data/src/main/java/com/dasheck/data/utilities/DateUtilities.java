package com.dasheck.data.utilities;

import android.util.Pair;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by dasheck on 12/12/15.
 */
public class DateUtilities {

  public static int getDayOfMonth(long timestamp) {
    Calendar date = Calendar.getInstance();
    date.setTimeInMillis(timestamp * 1000);
    return date.get(Calendar.DAY_OF_MONTH);
  }

  public static int getNumberOfDaysInMonth(int month, int year) {
    Calendar date = Calendar.getInstance();
    date.set(year, month, 1);
    return date.getActualMaximum(Calendar.DAY_OF_MONTH);
  }

  public static long dateToUnix(int day, int month, int year) {
    Calendar date = Calendar.getInstance();
    date.set(year, month, day);
    return date.getTimeInMillis() / 1000;
  }

  public static Pair<Integer, Integer> getCurrentMonthAndYear() {
    Calendar date = Calendar.getInstance();
    return new Pair<>(date.get(Calendar.MONTH), date.get(Calendar.YEAR));
  }

  public static String getCaptionFromMonthAndYear(int month, int year) {
    Calendar date = Calendar.getInstance();
    date.set(year, month, 1);
    return date.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US).toUpperCase() + " " + year;
  }

  public static int getFirstWeekdayOfMonth(int month, int year) {
    Calendar date = Calendar.getInstance();
    date.set(year, month, 1);
    return date.get(Calendar.DAY_OF_WEEK);
  }
}
