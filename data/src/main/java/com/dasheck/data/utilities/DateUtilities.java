package com.dasheck.data.utilities;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by dasheck on 12/12/15.
 */
public class DateUtilities {

  public static int getDayOfMonth(long timestamp) {
    Calendar date = Calendar.getInstance();
    date.setTimeInMillis(timestamp * 1000);
    return date.get(Calendar.DAY_OF_MONTH);
  }

}
