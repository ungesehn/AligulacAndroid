
package com.aligulac.data;

import org.parceler.Parcel;

@Parcel
public class Outcomes {
  Number prob;
  Number sca;
  Number scb;

  public Outcomes() {
  }

  public Number getProb() {
    return this.prob;
  }

  public void setProb(Number prob) {
    this.prob = prob;
  }

  public Number getSca() {
    return this.sca;
  }

  public void setSca(Number sca) {
    this.sca = sca;
  }

  public Number getScb() {
    return this.scb;
  }

  public void setScb(Number scb) {
    this.scb = scb;
  }

  public String getScoreCombined() {
    return sca.toString() + "-" + scb.toString();
  }
}
