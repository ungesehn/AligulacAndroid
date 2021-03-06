
package com.aligulac.data;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class PredictMatch {
  List<Outcomes> outcomes;
  Player_Short pla;
  Player_Short plb;
  Number proba;
  Number probb;
  String resource_uri;
  Number rta;
  Number rtb;
  Number sca;
  Number scb;

  public PredictMatch() {
  }

  public List<Outcomes> getOutcomes() {
    return this.outcomes;
  }

  public void setOutcomes(List<Outcomes> outcomes) {
    this.outcomes = outcomes;
  }

  public Player_Short getPla() {
    return this.pla;
  }

  public void setPla(Player_Short pla) {
    this.pla = pla;
  }

  public Player_Short getPlb() {
    return this.plb;
  }

  public void setPlb(Player_Short plb) {
    this.plb = plb;
  }

  public Number getProba() {
    return this.proba;
  }

  public void setProba(Number proba) {
    this.proba = proba;
  }

  public Number getProbb() {
    return this.probb;
  }

  public void setProbb(Number probb) {
    this.probb = probb;
  }

  public String getResource_uri() {
    return this.resource_uri;
  }

  public void setResource_uri(String resource_uri) {
    this.resource_uri = resource_uri;
  }

  public Number getRta() {
    return this.rta;
  }

  public void setRta(Number rta) {
    this.rta = rta;
  }

  public Number getRtb() {
    return this.rtb;
  }

  public void setRtb(Number rtb) {
    this.rtb = rtb;
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
}
