package com.dasheck.calendarwidget.fragments.event;

import com.dasheck.calendarwidget.fragments.BasePresenterImpl;

/**
 * Created by dasheck on 12/30/15.
 */
public class ShowEventPresenterImpl extends BasePresenterImpl implements ShowEventPresenter {

  private ShowEventView view;

  public ShowEventPresenterImpl(ShowEventView view) {
    this.view = view;
  }

  @Override public void initializeViews() {

  }
}
