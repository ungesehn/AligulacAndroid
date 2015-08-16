
package com.aligulac.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamList{
   	private Meta meta;
   	
    @SerializedName("objects")
   	private List<Team> teams;

 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}
 	public List<Team> getTeams(){
		return this.teams;
	}
	public void setTeams(List<Team> objects){
		this.teams = objects;
	}
}
