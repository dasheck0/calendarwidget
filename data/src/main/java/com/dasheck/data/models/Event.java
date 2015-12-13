package com.dasheck.data.models;

import java.util.List;

/**
 * Created by dasheck on 12/12/15.
 */
public class Event {

  private Location location;
  private List<Attendee> attendees;

  public Event() {
  }

  public Event(Location location, List<Attendee> attendees) {
    this.location = location;
    this.attendees = attendees;
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
