package com.dasheck.calendarwidget.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dasheck.calendarwidget.R;
import com.dasheck.calendarwidget.models.HeroItem;
import com.dasheck.calendarwidget.utilities.Constants;
import com.dasheck.data.models.Date;
import com.dasheck.data.utilities.DateUtilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dasheck on 12/12/15.
 */
public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

  private static final String STYLE_NORMAL = "normal";
  private static final String STYLE_SELECTED = "selected";
  private static final String STYLE_HAS_EVENT = "hasEvent";

  private Context context;
  private List<Date> items;
  private OnDateClickListener onDateClickListener;
  private int selected;

  public DateAdapter(Context context) {
    this.context = context;
    this.items = new ArrayList<>();
    this.selected = -1;
  }

  public void add(Date date) {
    items.add(date);
    notifyDataSetChanged();
  }

  public void addAll(Collection<? extends Date> collection) {
    items.addAll(collection);
    notifyDataSetChanged();
  }

  public void clear() {
    items.clear();
    notifyDataSetChanged();
  }

  public Date get(int position) {
    return items.get(position);
  }

  public void clearSelection() {
    selected = -1;
  }

  public void setOnDateClickListener(
      OnDateClickListener onDateClickListener) {
    this.onDateClickListener = onDateClickListener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Date item = get(position);

    if (item.isActive()) {
      holder.dayNumberTextView.setText(
          String.valueOf(DateUtilities.getDayOfMonth(item.getTimestamp())));
      holder.dayNumberTextView.setOnClickListener(v -> {
        if (onDateClickListener != null) {
          if (selected != -1) {
            notifyItemChanged(selected);
          }
          selected = position;
          notifyItemChanged(selected);
          onDateClickListener.onDateClick(
              new HeroItem(holder.dayNumberTextView, Constants.TRANSITION_HERO_NAME_CALENDAR),
              position);
        }
      });

      applyStyle(holder.dayNumberTextView,
          item.getEvent() == null ? STYLE_NORMAL : STYLE_HAS_EVENT);

      if (selected == position) {
        applyStyle(holder.dayNumberTextView, STYLE_SELECTED);
      }
    } else {
      holder.dayNumberTextView.setText("");
    }
  }

  @Override public int getItemCount() {
    return items.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.dayNumberTextView) TextView dayNumberTextView;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public interface OnDateClickListener {
    void onDateClick(HeroItem heroItem, int position);
  }

  private void applyStyle(TextView textView, String style) {
    int backgroundResourceId;
    int textColor;

    switch (style) {
      case STYLE_NORMAL:
        textView.setBackground(null);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        return;
      case STYLE_HAS_EVENT:
        backgroundResourceId = R.drawable.date_item_has_event;
        textColor = R.color.white;
        break;
      case STYLE_SELECTED:
        backgroundResourceId = R.drawable.date_item_seleted;
        textColor = R.color.colorPrimary;
        break;
      default:
        return;
    }

    Drawable background = context.getResources().getDrawable(backgroundResourceId);
    textColor = context.getResources().getColor(textColor);

    textView.setBackground(background);
    textView.setTextColor(textColor);
  }
}
