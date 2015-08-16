
package com.aligulac.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventList {
    private Meta meta;

    @SerializedName("objects")
    private List<Event> events;

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> objects) {
        this.events = objects;
    }
}
