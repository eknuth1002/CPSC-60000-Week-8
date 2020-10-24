package com.elliotknuth.Clays;

import com.elliotknuth.Enums.ClayEnums;

public class SedonaRed extends Clay {
	public SedonaRed() {
		type = ClayEnums.SEDONA_RED;
	}
	
	@Override
	public double getCostPerLb() {
		return 1.18;
	}

}
