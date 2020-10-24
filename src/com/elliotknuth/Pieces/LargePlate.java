package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class LargePlate extends Piece {

	public LargePlate(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.LARGE_PLATE;
		weight = 4.0;
	}
}
