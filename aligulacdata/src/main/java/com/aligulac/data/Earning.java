
package com.aligulac.data;

public class Earning {

    private String currency;
    private int earnings;
    private Event event;
    private int id;
    private String origearnings;
    private int placement;
    private Player player;
    private String resource_uri;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigearnings() {
        return origearnings;
    }

    public void setOrigearnings(String origearnings) {
        this.origearnings = origearnings;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getResource_uri() {
        return resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

}
