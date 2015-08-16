
package com.aligulac.data;

import java.util.List;

public class PredictProLeague{
   	private List<Matches> matches;
   	private List<Meanres> meanres;
   	private List<Outcomes> outcomes;
   	private Number prob_draw;
   	private Number proba;
   	private Number probb;
   	private String resource_uri;
   	private Number sca;
   	private Number scb;

 	public List<Matches> getMatches(){
		return this.matches;
	}
	public void setMatches(List<Matches> matches){
		this.matches = matches;
	}
 	public List<Meanres> getMeanres(){
		return this.meanres;
	}
	public void setMeanres(List<Meanres> meanres){
		this.meanres = meanres;
	}
 	public List<Outcomes> getOutcomes(){
		return this.outcomes;
	}
	public void setOutcomes(List<Outcomes> outcomes){
		this.outcomes = outcomes;
	}
 	public Number getProb_draw(){
		return this.prob_draw;
	}
	public void setProb_draw(Number prob_draw){
		this.prob_draw = prob_draw;
	}
 	public Number getProba(){
		return this.proba;
	}
	public void setProba(Number proba){
		this.proba = proba;
	}
 	public Number getProbb(){
		return this.probb;
	}
	public void setProbb(Number probb){
		this.probb = probb;
	}
 	public String getResource_uri(){
		return this.resource_uri;
	}
	public void setResource_uri(String resource_uri){
		this.resource_uri = resource_uri;
	}
 	public Number getSca(){
		return this.sca;
	}
	public void setSca(Number sca){
		this.sca = sca;
	}
 	public Number getScb(){
		return this.scb;
	}
	public void setScb(Number scb){
		this.scb = scb;
	}
}
