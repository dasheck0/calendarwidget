package com.dasheck.calendarwidget.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.dasheck.calendarwidget.annotations.Layout;
import java.lang.annotation.Annotation;

/**
 * Created by dasheck on 12/13/15.
 */
public class BaseFragment extends Fragment implements BaseView {

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutResId(), container, false);
    ButterKnife.bind(this, view);

    return view;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }

  private int getLayoutResId() {
    Annotation annotation = ((Object) this).getClass().getAnnotation(Layout.class);
    if(annotation != null) {
      return ((Layout) annotation).value();
    } else {
      throw new IllegalStateException("You must provide a layout");
    }
  }

}
