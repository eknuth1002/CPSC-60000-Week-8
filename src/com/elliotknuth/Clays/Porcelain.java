package com.elliotknuth.Clays;

import com.elliotknuth.Enums.ClayEnums;

public class Porcelain extends Clay {
	public Porcelain() {
		type = ClayEnums.PORCELAIN;
	}

	@Override
	public double getCostPerLb() {
		return 1.18;
	}

}
