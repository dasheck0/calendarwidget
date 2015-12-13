package com.dasheck.data.models;

import java.util.List;

/**
 * Created by dasheck on 12/12/15.
 */
public class Date {

  private long timestamp;
  private boolean active;
  private Event event;

  public Date() {
  }

  public Date(long timestamp, boolean active, Event event) {
    this.timestamp = timestamp;
    this.active = active;
    this.event = event;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }
}
