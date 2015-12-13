package com.dasheck.calendarwidget.fragments.create_event;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.annotations.Layout;
import com.dasheck.calendarwidget.fragments.BaseFragment;

/**
 * Created by dasheck on 12/13/15.
 */
@Layout(R.layout.fragment_create_event)
public class CreateEventFragment extends BaseFragment implements CreateEventView {

  public static final String BUNDLE_TIMESTAMP_KEY = "bundleTimestampKey";

  private CreateEventPresenter presenter;

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
  }
}
