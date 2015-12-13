package com.dasheck.calendarwidget.controllers;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.models.HeroItem;
import java.util.List;

/**
 * Created by dasheck on 12/13/15.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class LollipopTransitionControllerImpl implements TransitionController {

  private AppCompatActivity activity;
  private int fragmentContainerId;

  private Transition enterTransition;
  private Transition sharedElementTransition;

  public LollipopTransitionControllerImpl(AppCompatActivity activity, int fragmentContainerId) {
    this.activity = activity;
    this.fragmentContainerId = fragmentContainerId;

    enterTransition = new Fade().setDuration(
        activity.getResources().getInteger(R.integer.animation_transition_duration));
    sharedElementTransition = TransitionInflater.from(activity)
        .inflateTransition(R.transition.shared_element)
        .setDuration(activity.getResources().getInteger(R.integer.animation_transition_duration));
  }

  public void transist(Fragment fragment, List<HeroItem> heroElements) {
    Fragment currentFragment = getCurrentFragment();
    if (currentFragment != null) {
      currentFragment.setSharedElementReturnTransition(sharedElementTransition);
      currentFragment.setExitTransition(enterTransition);
    }

    fragment.setSharedElementEnterTransition(sharedElementTransition);
    fragment.setEnterTransition(enterTransition);

    FragmentTransaction transaction = activity.getSupportFragmentManager()
        .beginTransaction()
        .replace(fragmentContainerId, fragment, ((Object) fragment).getClass().getName())
        .addToBackStack(((Object) fragment).getClass().getName());

    for (HeroItem heroElement : heroElements) {
      ViewCompat.setTransitionName(heroElement.getView(), heroElement.getName());
      transaction.addSharedElement(heroElement.getView(), heroElement.getName());
    }

    transaction.commit();
  }

  public Fragment getCurrentFragment() {
    FragmentManager manager = activity.getSupportFragmentManager();
    if (manager.getBackStackEntryCount() == 0) {
      return null;
    }

    FragmentManager.BackStackEntry backEntry =
        manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1);
    String name = backEntry.getName();
    return manager.findFragmentByTag(name);
  }
}
