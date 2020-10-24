package com.elliotknuth.Designs;

import com.elliotknuth.Glazes.Glaze;

public class Hunting extends Design {
	private Design design;
	private Glaze glaze;
	private double cost;
	
	public Hunting(Design design) {
		this.design = design;
	}
	public void setGlaze(Glaze glaze) {
		this.glaze = glaze;
	}
	@Override
	public String getDescription() {
		return (design != null ? design.getDescription() + " with " : "") + "a ring scene depicting hunting in " + glaze.getDescription();
	}
	@Override
	public double getCostPerOz() {
		return design.getCostPerOz() + glaze.getCostPerOz();
	}
}
