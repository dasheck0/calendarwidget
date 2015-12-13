package com.dasheck.calendarwidget.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.View;
import com.dasheck.calendarwidget.models.HeroItem;
import java.util.List;

/**
 * Created by dasheck on 12/13/15.
 */
public interface TransitionController {

  public void transist(Fragment fragment, List<HeroItem> heroElements);
}
