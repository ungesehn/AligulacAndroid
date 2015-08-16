
package com.aligulac.data;

public class Period {
    private Number dom_p;
    private Number dom_t;
    private Number dom_z;
    private String end;
    private Number id;
    private boolean needs_recompute;
    private Number num_games;
    private Number num_newplayers;
    private Number num_retplayers;
    private String resource_uri;
    private String start;

    public Number getDom_p() {
        return this.dom_p;
    }

    public void setDom_p(Number dom_p) {
        this.dom_p = dom_p;
    }

    public Number getDom_t() {
        return this.dom_t;
    }

    public void setDom_t(Number dom_t) {
        this.dom_t = dom_t;
    }

    public Number getDom_z() {
        return this.dom_z;
    }

    public void setDom_z(Number dom_z) {
        this.dom_z = dom_z;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Number getId() {
        return this.id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public boolean getNeeds_recompute() {
        return this.needs_recompute;
    }

    public void setNeeds_recompute(boolean needs_recompute) {
        this.needs_recompute = needs_recompute;
    }

    public Number getNum_games() {
        return this.num_games;
    }

    public void setNum_games(Number num_games) {
        this.num_games = num_games;
    }

    public Number getNum_newplayers() {
        return this.num_newplayers;
    }

    public void setNum_newplayers(Number num_newplayers) {
        this.num_newplayers = num_newplayers;
    }

    public Number getNum_retplayers() {
        return this.num_retplayers;
    }

    public void setNum_retplayers(Number num_retplayers) {
        this.num_retplayers = num_retplayers;
    }

    public String getResource_uri() {
        return this.resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
