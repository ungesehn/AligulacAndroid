
package com.aligulac.data;

import org.parceler.Parcel;

@Parcel
public class Player_Short {
  String country;
  Number id;
  String race;
  Number score;
  String tag;

  public Player_Short() {
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Number getId() {
    return this.id;
  }

  public void setId(Number id) {
    this.id = id;
  }

  public String getRace() {
    return this.race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public Number getScore() {
    return this.score;
  }

  public void setScore(Number score) {
    this.score = score;
  }

  public String getTag() {
    return this.tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }
}
