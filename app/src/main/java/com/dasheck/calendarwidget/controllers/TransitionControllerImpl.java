package com.dasheck.calendarwidget.controllers;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.dasheck.calendarwidget.models.HeroItem;
import java.util.List;

/**
 * Created by dasheck on 12/13/15.
 */
public class TransitionControllerImpl implements TransitionController {

  private AppCompatActivity activity;
  private int fragmentContainerId;

  public TransitionControllerImpl(AppCompatActivity activity, int fragmentContainerId) {
    this.activity = activity;
    this.fragmentContainerId = fragmentContainerId;
  }

  @Override public void transist(Fragment fragment, List<HeroItem> heroElements) {
    activity.getSupportFragmentManager()
        .beginTransaction()
        .replace(fragmentContainerId, fragment)
        .addToBackStack(((Object) fragment).getClass().getName())
        .commit();
  }
}
