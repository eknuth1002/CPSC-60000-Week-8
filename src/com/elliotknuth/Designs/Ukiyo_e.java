package com.elliotknuth.Designs;

import com.elliotknuth.Glazes.Glaze;

public class Ukiyo_e extends Design {
	private Design design;
	private Glaze glaze;
	private double cost;
	
	public Ukiyo_e(Design design) {
		this.design = design;
	}
	
	@Override
	public String getDescription() {
		return (design != null ? design.getDescription() + ", " : "") + "a minimalist scene of nature in Japan";
	}
	@Override
	public double getCostPerOz() {
		return design.getCostPerOz() + glaze.getCostPerOz();
	}
}
