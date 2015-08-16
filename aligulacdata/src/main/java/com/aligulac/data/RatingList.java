
package com.aligulac.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RatingList{
   	
    private Meta meta;

   	@SerializedName("objects")
   	private List<Rating> ratings;

 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}
 	public List<Rating> getObjects(){
		return this.ratings;
	}
	public void setObjects(List<Rating> objects){
		this.ratings = objects;
	}
}
