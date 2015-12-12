package com.dasheck.data.models;

/**
 * Created by dasheck on 12/12/15.
 */
public class Location {

  private String addressLine;
  private String zip;
  private String city;
  private double lattitude;
  private double longitude;

  public Location() {
  }

  public Location(String addressLine, String zip, String city, double lattitude, double longitude) {
    this.addressLine = addressLine;
    this.zip = zip;
    this.city = city;
    this.lattitude = lattitude;
    this.longitude = longitude;
  }

  public String getAddressLine() {
    return addressLine;
  }

  public void setAddressLine(String addressLine) {
    this.addressLine = addressLine;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public double getLattitude() {
    return lattitude;
  }

  public void setLattitude(double lattitude) {
    this.lattitude = lattitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
