package com.elliotknuth.Pieces;

import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.PotteryFactory;

public class Teapot extends Piece {

	public Teapot(PotteryFactory factory) {
		this.factory = factory;
		type = PieceEnums.TEAPOT;
		weight = 5.5;
	}
}
