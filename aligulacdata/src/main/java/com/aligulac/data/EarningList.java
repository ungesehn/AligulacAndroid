
package com.aligulac.data;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EarningList {

    private Meta meta;

    @SerializedName("objects")
    private List<Earning> earnings = new ArrayList<Earning>();

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Earning> getEarnings() {
        return earnings;
    }

    public void setEarnings(List<Earning> objects) {
        this.earnings = objects;
    }

}
