package com.aligulac.data;

import java.util.List;

public class AligulacQuery {

    List events;

    List teams;

    List<AutocompletePlayer> players;

    public List getEvents() {
        return events;
    }

    public void setEvents(List events) {
        this.events = events;
    }

    public List getTeams() {
        return teams;
    }

    public void setTeams(List teams) {
        this.teams = teams;
    }

    public List<AutocompletePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<AutocompletePlayer> players) {
        this.players = players;
    }
}
