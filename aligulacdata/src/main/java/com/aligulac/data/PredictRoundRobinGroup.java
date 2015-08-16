
package com.aligulac.data;

import java.util.List;

public class PredictRoundRobinGroup{
   	private List<Matches> matches;
   	private List<Meanres> meanres;
   	private List<Mtable> mtable;
   	private String resource_uri;
   	private List<Table> table;

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
 	public List<Mtable> getMtable(){
		return this.mtable;
	}
	public void setMtable(List<Mtable> mtable){
		this.mtable = mtable;
	}
 	public String getResource_uri(){
		return this.resource_uri;
	}
	public void setResource_uri(String resource_uri){
		this.resource_uri = resource_uri;
	}
 	public List<Table> getTable(){
		return this.table;
	}
	public void setTable(List<Table> table){
		this.table = table;
	}
}
