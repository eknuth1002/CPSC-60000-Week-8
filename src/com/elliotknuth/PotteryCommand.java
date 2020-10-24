package com.elliotknuth;

import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Pieces.Piece;

public interface PotteryCommand {
	public void execute(Piece piece, PotteryFactory factory);
	public void undo(Piece piece);
	public abstract String getDescription();
}
