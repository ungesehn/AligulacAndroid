
package com.aligulac.data;

import java.util.List;

public class Player {
    private List<Object> aliases;
    private String birthday;
    private String country;
    private Current_rating current_rating;
    private List<Object> current_teams;
    private String dom_end;
    private String dom_start;
    private Number dom_val;
    private Number id;
    private String lp_name;
    private String mcnum;
    private String name;
    private List<Object> past_teams;
    private String race;
    private String resource_uri;
    private Number sc2c_id;
    private String sc2e_id;
    private String tag;
    private String tlpd_db;
    private String tlpd_id;

    public List<Object> getAliases() {
        return this.aliases;
    }

    public void setAliases(List<Object> aliases) {
        this.aliases = aliases;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Current_rating getCurrent_rating() {
        return this.current_rating;
    }

    public void setCurrent_rating(Current_rating current_rating) {
        this.current_rating = current_rating;
    }

    public List<Object> getCurrent_teams() {
        return this.current_teams;
    }

    public void setCurrent_teams(List<Object> current_teams) {
        this.current_teams = current_teams;
    }

    public String getDom_end() {
        return this.dom_end;
    }

    public void setDom_end(String dom_end) {
        this.dom_end = dom_end;
    }

    public String getDom_start() {
        return this.dom_start;
    }

    public void setDom_start(String dom_start) {
        this.dom_start = dom_start;
    }

    public Number getDom_val() {
        return this.dom_val;
    }

    public void setDom_val(Number dom_val) {
        this.dom_val = dom_val;
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

    public String getMcnum() {
        return this.mcnum;
    }

    public void setMcnum(String mcnum) {
        this.mcnum = mcnum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getPast_teams() {
        return this.past_teams;
    }

    public void setPast_teams(List<Object> past_teams) {
        this.past_teams = past_teams;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getResource_uri() {
        return this.resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public Number getSc2c_id() {
        return this.sc2c_id;
    }

    public void setSc2c_id(Number sc2c_id) {
        this.sc2c_id = sc2c_id;
    }

    public String getSc2e_id() {
        return this.sc2e_id;
    }

    public void setSc2e_id(String sc2e_id) {
        this.sc2e_id = sc2e_id;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTlpd_db() {
        return this.tlpd_db;
    }

    public void setTlpd_db(String tlpd_db) {
        this.tlpd_db = tlpd_db;
    }

    public String getTlpd_id() {
        return this.tlpd_id;
    }

    public void setTlpd_id(String tlpd_id) {
        this.tlpd_id = tlpd_id;
    }

    @Override
    public String toString() {
        return this.tag;
    }
}
