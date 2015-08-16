
package com.aligulac.data;

public class Mtable {

    private int exp_match_losses;
    private int exp_match_wins;
    private int exp_set_losses;
    private int exp_set_wins;
    private Player player;

    public int getExp_match_losses() {
        return exp_match_losses;
    }

    public void setExp_match_losses(int exp_match_losses) {
        this.exp_match_losses = exp_match_losses;
    }

    public int getExp_match_wins() {
        return exp_match_wins;
    }

    public void setExp_match_wins(int exp_match_wins) {
        this.exp_match_wins = exp_match_wins;
    }

    public int getExp_set_losses() {
        return exp_set_losses;
    }

    public void setExp_set_losses(int exp_set_losses) {
        this.exp_set_losses = exp_set_losses;
    }

    public int getExp_set_wins() {
        return exp_set_wins;
    }

    public void setExp_set_wins(int exp_set_wins) {
        this.exp_set_wins = exp_set_wins;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
