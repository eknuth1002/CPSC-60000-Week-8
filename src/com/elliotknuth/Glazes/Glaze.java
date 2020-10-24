package com.elliotknuth.Glazes;

import com.elliotknuth.Pieces.Piece;

public abstract class Glaze {
	double costPerOz;
	
	public abstract String getDescription();
	
	public double getCostPerOz() {
		return costPerOz;
	}
}
