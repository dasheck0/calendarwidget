package com.dasheck.calendarwidget.fragments.create_event;

import com.dasheck.calendarwidget.fragments.BaseFragment;
import com.dasheck.calendarwidget.fragments.BasePresenterImpl;
import com.dasheck.data.utilities.DateUtilities;

/**
 * Created by dasheck on 12/13/15.
 */
public class CreateEventPresenterImpl extends BasePresenterImpl implements CreateEventPresenter {

  private CreateEventView view;

  public CreateEventPresenterImpl(CreateEventView view) {
    this.view = view;
  }

  @Override public void initializeViews() {
    //view.showEventContainer();
  }

  @Override public void setTimestamp(long timestamp) {
    view.setDayNumber(DateUtilities.getDayOfMonth(timestamp));
  }
}
