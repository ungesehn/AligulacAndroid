
package com.aligulac.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActiveRatingList {
    private Meta meta;
    
    @SerializedName("objects")
    private List<ActiveRating> activeRatings;

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<ActiveRating> getObjects() {
        return this.activeRatings;
    }

    public void setObjects(List<ActiveRating> objects) {
        this.activeRatings = objects;
    }
}
