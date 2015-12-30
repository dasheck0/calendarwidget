package com.dasheck.calendarwidget.fragments.event;

import android.os.Bundle;
import butterknife.Bind;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.annotations.Layout;
import com.dasheck.calendarwidget.fragments.BaseFragment;

/**
 * Created by dasheck on 12/30/15.
 */
@Layout(R.layout.fragment_show_event)
public class ShowEventFragment extends BaseFragment implements ShowEventView {

  public static final String BUNDLE_TIMESTAMP_KEY = "bundleTimestampKey";

  public static ShowEventFragment newInstance(long timestamp) {
    Bundle args = new Bundle();
    args.putLong(BUNDLE_TIMESTAMP_KEY, timestamp);
    ShowEventFragment fragment = new ShowEventFragment();
    fragment.setArguments(args);
    return fragment;
  }



}
