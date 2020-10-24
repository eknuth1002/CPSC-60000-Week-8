package com.elliotknuth.Clays;

import com.elliotknuth.Enums.ClayEnums;

public class TerraCota extends Clay {

	public TerraCota() {
		type = ClayEnums.TERRA_COTA;
	}

	@Override
	public double getCostPerLb() {
		return 1.72;
	}

}
