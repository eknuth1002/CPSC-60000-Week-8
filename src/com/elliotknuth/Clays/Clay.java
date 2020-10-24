package com.elliotknuth.Clays;

import com.elliotknuth.Enums;

public abstract class Clay {
	protected Enums.ClayEnums type;
	
	public String getDescription() {
		return type.toString();
	}

	public abstract double getCostPerLb();
}
