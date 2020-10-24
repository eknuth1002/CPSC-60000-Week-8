package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class LargeBowl extends Piece {

	public LargeBowl(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.LARGE_BOWL;
		weight = 5.0;
	}
}
