
package com.aligulac.data;

import java.util.List;

public class Event {
    private String category;
    private List<Object> children;
    private String earliest;
    private List<Earning> earnings;
    private String fullname;
    private String homepage;
    private Number id;
    private Number idx;
    private String latest;
    private String lp_name;
    private String name;
    private String parent;
    private boolean prizepool;
    private String resource_uri;
    private String tl_thread;
    private String tlpd_db;
    private String tlpd_id;
    private String type;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Object> getChildren() {
        return this.children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    public String getEarliest() {
        return this.earliest;
    }

    public void setEarliest(String earliest) {
        this.earliest = earliest;
    }

    public List<Earning> getEarnings() {
        return this.earnings;
    }

    public void setEarnings(List<Earning> earnings) {
        this.earnings = earnings;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public Number getIdx() {
        return this.idx;
    }

    public void setIdx(Number idx) {
        this.idx = idx;
    }

    public String getLatest() {
        return this.latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getLp_name() {
        return this.lp_name;
    }

    public void setLp_name(String lp_name) {
        this.lp_name = lp_name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean getPrizepool() {
        return this.prizepool;
    }

    public void setPrizepool(boolean prizepool) {
        this.prizepool = prizepool;
    }

    public String getResource_uri() {
        return this.resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public String getTl_thread() {
        return this.tl_thread;
    }

    public void setTl_thread(String tl_thread) {
        this.tl_thread = tl_thread;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
