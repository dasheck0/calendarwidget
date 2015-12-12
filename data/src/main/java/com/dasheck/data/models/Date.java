package com.dasheck.data.models;

import java.util.List;

/**
 * Created by dasheck on 12/12/15.
 */
public class Date {

  private long timestamp;
  private Location location;
  private List<Attendee> attendees;

  public Date() {
  }

  public Date(long timestamp, Location location,
      List<Attendee> attendees) {
    this.timestamp = timestamp;
    this.location = location;
    this.attendees = attendees;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public List<Attendee> getAttendees() {
    return attendees;
  }

  public void setAttendees(List<Attendee> attendees) {
    this.attendees = attendees;
  }
}
