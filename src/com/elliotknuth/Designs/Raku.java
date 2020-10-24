package com.elliotknuth.Designs;

import com.elliotknuth.Glazes.Glaze;

public class Raku extends Design {
	private Design design;
	private Glaze glaze;
	private double cost;
	
	public Raku(Design design) {
		this.design = design;
	}
	public void setGlaze(Glaze glaze) {
		this.glaze = glaze;
	}
	@Override
	public String getDescription() {
		return (design != null ? design.getDescription() + ", " : "") + "organic material burned into the surface";
	}
	@Override
	public double getCostPerOz() {
		return design.getCostPerOz() + glaze.getCostPerOz();
	}
}
