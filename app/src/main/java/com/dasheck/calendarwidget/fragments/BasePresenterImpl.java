package com.dasheck.calendarwidget.fragments;

import java.util.ArrayList;
import java.util.List;
import rx.Subscription;

/**
 * Created by dasheck on 12/13/15.
 */
public abstract class BasePresenterImpl implements Presenter {

  List<Subscription> subscriptions;

  @Override public void onResume() {
    subscriptions = new ArrayList<>();
  }

  @Override public void onPause() {
    
  }
}
