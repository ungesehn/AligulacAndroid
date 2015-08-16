
package com.aligulac.data;

public class Matches {
    private String eventtext;
    private String identifier;
    private Player_Short pla;
    private Player_Short plb;
    private boolean unfixed;

    public String getEventtext() {
        return this.eventtext;
    }

    public void setEventtext(String eventtext) {
        this.eventtext = eventtext;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public boolean getUnfixed() {
        return this.unfixed;
    }

    public void setUnfixed(boolean unfixed) {
        this.unfixed = unfixed;
    }
}
