package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class Mug extends Piece {

	public Mug(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.MUG;
		weight = 3.0;
	}
}
