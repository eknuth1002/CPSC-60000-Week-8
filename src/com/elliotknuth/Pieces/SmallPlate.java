package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class SmallPlate extends Piece {

	public SmallPlate(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.SMALL_PLATE;
		weight = 2.0;
	}
}
