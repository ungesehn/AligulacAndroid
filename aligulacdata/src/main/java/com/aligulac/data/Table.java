
package com.aligulac.data;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private Player player;
    private List<Double> probs = new ArrayList<Double>();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Double> getProbs() {
        return probs;
    }

    public void setProbs(List<Double> probs) {
        this.probs = probs;
    }
}
