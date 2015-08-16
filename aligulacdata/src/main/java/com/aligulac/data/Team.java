
package com.aligulac.data;

import java.util.List;

public class Team {
    private boolean active;
    private List<Object> aliases;
    private List<Object> current_nonplayers;
    private List<Current_players> current_players;
    private String disbanded;
    private String founded;
    private String homepage;
    private Number id;
    private String lp_name;
    private Number meanrating;
    private String name;
    private List<Past_players> past_players;
    private String resource_uri;
    private Number scoreak;
    private Number scorepl;
    private String shortname;

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Object> getAliases() {
        return this.aliases;
    }

    public void setAliases(List<Object> aliases) {
        this.aliases = aliases;
    }

    public List<Object> getCurrent_nonplayers() {
        return this.current_nonplayers;
    }

    public void setCurrent_nonplayers(List<Object> current_nonplayers) {
        this.current_nonplayers = current_nonplayers;
    }

    public List<Current_players> getCurrent_players() {
        return this.current_players;
    }

    public void setCurrent_players(List<Current_players> current_players) {
        this.current_players = current_players;
    }

    public String getDisbanded() {
        return this.disbanded;
    }

    public void setDisbanded(String disbanded) {
        this.disbanded = disbanded;
    }

    public String getFounded() {
        return this.founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getHomepage() {
        return this.homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Number getId() {
        return this.id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getLp_name() {
        return this.lp_name;
    }

    public void setLp_name(String lp_name) {
        this.lp_name = lp_name;
    }

    public Number getMeanrating() {
        return this.meanrating;
    }

    public void setMeanrating(Number meanrating) {
        this.meanrating = meanrating;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Past_players> getPast_players() {
        return this.past_players;
    }

    public void setPast_players(List<Past_players> past_players) {
        this.past_players = past_players;
    }

    public String getResource_uri() {
        return this.resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public Number getScoreak() {
        return this.scoreak;
    }

    public void setScoreak(Number scoreak) {
        this.scoreak = scoreak;
    }

    public Number getScorepl() {
        return this.scorepl;
    }

    public void setScorepl(Number scorepl) {
        this.scorepl = scorepl;
    }

    public String getShortname() {
        return this.shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
