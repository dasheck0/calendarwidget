package com.dasheck.calendarwidget.fragments.create_event;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import butterknife.Bind;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.annotations.Layout;
import com.dasheck.calendarwidget.fragments.BaseFragment;
import com.nineoldandroids.animation.Animator;

/**
 * Created by dasheck on 12/13/15.
 */
@Layout(R.layout.fragment_create_event)
public class CreateEventFragment extends BaseFragment implements CreateEventView {

  public static final String BUNDLE_TIMESTAMP_KEY = "bundleTimestampKey";

  private CreateEventPresenter presenter;
  private boolean containerShown = false;

  @Bind(R.id.eventContainer) ViewGroup eventContainer;
  @Bind(R.id.dayTextView) TextView dayTextView;

  public static CreateEventFragment newInstance(long timestamp) {
    Bundle args = new Bundle();
    args.putLong(BUNDLE_TIMESTAMP_KEY, timestamp);
    CreateEventFragment fragment = new CreateEventFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    presenter = new CreateEventPresenterImpl(this);
    presenter.initializeViews();
    presenter.setTimestamp(getArguments().getLong(BUNDLE_TIMESTAMP_KEY));

    eventContainer.getViewTreeObserver()
        .addOnGlobalLayoutListener(() -> {
          if (!containerShown) {
            showEventContainer();
            containerShown = true;
          }
        });
  }

  @Override public void setDayNumber(int dayOfMonth) {
    dayTextView.setText(String.valueOf(dayOfMonth));
  }

  @Override public void showEventContainer() {
    YoYo.with(Techniques.SlideInRight)
        .duration(getResources().getInteger(R.integer.animation_duration))
        .withListener(new Animator.AnimatorListener() {
          @Override public void onAnimationStart(Animator animation) {
            animation.setInterpolator(new OvershootInterpolator());
            eventContainer.setVisibility(View.VISIBLE);
          }

          @Override public void onAnimationEnd(Animator animation) {

          }

          @Override public void onAnimationCancel(Animator animation) {

          }

          @Override public void onAnimationRepeat(Animator animation) {

          }
        })
        .playOn(eventContainer);
  }
}
