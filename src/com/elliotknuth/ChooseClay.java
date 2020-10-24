package com.elliotknuth;

import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Pieces.Piece;

public class ChooseClay implements PotteryCommand {

	@Override
	public void execute(Piece piece, PotteryFactory factory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo(Piece piece) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		return "Choose a clay";
	}

}
