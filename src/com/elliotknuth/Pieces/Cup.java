package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class Cup extends Piece {

	public Cup(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.CUP;
		weight = 1.0;
	}
}
