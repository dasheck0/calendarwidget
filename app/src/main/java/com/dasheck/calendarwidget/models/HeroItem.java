package com.dasheck.calendarwidget.models;

import android.view.View;

/**
 * Created by dasheck on 12/13/15.
 */
public class HeroItem {

  private View view;
  private String name;

  public HeroItem(View view, String name) {
    this.view = view;
    this.name = name;
  }

  public View getView() {
    return view;
  }

  public void setView(View view) {
    this.view = view;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
