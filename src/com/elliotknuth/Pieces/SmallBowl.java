package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class SmallBowl extends Piece {

	public SmallBowl(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.SMALL_BOWL;
		weight = 2.5;
	}
}
