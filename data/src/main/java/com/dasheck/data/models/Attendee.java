package com.dasheck.data.models;

/**
 * Created by dasheck on 12/12/15.
 */
public class Attendee {

  private String name;

  public Attendee() {
  }

  public Attendee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
