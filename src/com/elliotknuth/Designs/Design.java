package com.elliotknuth.Designs;

import com.elliotknuth.Glazes.Glaze;

public abstract class Design {
	protected Design design;
	protected Glaze glaze;
	protected double cost;
	
	public Design getNextDesign() {
		return design;
	}
	
	public void setNextDesign(Design design) {
		this.design = design;
	}
	
	public abstract String getDescription();
	
	public abstract double getCostPerOz();
}
