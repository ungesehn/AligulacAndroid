
package com.aligulac.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeriodList{
   	private Meta meta;

   	@SerializedName("objects")
   	private List<Period> periods;

 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}
 	public List<Period> getObjects(){
		return this.periods;
	}
	public void setObjects(List<Period> objects){
		this.periods = objects;
	}
}
