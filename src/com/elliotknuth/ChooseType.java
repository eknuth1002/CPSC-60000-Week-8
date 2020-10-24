package com.elliotknuth;

import java.util.Scanner;

import com.elliotknuth.Clays.SedonaRed;
import com.elliotknuth.Clays.TerraCota;
import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Pieces.Cup;
import com.elliotknuth.Pieces.LargeBowl;
import com.elliotknuth.Pieces.LargePlate;
import com.elliotknuth.Pieces.Mug;
import com.elliotknuth.Pieces.Piece;
import com.elliotknuth.Pieces.SmallBowl;
import com.elliotknuth.Pieces.SmallPlate;
import com.elliotknuth.Pieces.Teapot;

public class ChooseType implements PotteryCommand {
	Piece prevPiece = null;
	@Override
	public void execute(Piece piece, PotteryFactory factory) {
		System.out.println("Please cloose one of the following clays:");
		System.out.println("(1) Cup");
		System.out.println("(2) Mug");
		System.out.println("(3) Small Bowl");
		System.out.println("(4) Large Bowl");
		System.out.println("(5) Small Plate");
		System.out.println("(6) Large Plate");
		System.out.println("(7) Teapot");
		
		String input = null;
		Scanner reader = new Scanner(System.in);
		
		while (input == null) {
			input = String.valueOf(reader.next().charAt(0));
			
			switch (input) {
				case "1":
					prevPiece = piece;
					piece = new Cup(factory);
					break;
				case "2":
					prevPiece = piece;
					piece = new LargeBowl(factory);
					break;
				case "3":
					prevPiece = piece;
					piece = new LargePlate(factory);
				case "4":
					prevPiece = piece;
					piece = new Mug(factory);
					break;
				case "5":
					prevPiece = piece;
					piece = new SmallBowl(factory);
					break;
				case "6":
					prevPiece = piece;
					piece = new SmallPlate(factory);
					break;
				case "7":
					prevPiece = piece;
					piece = new Teapot(factory);
					break;
				default:
					System.out.println("Invalid selection.  Please try again.");
					input = null;
			}
		}
		
		piece.setClay(prevPiece.getClay());
		piece.setOverglaze(prevPiece.getOverglaze());
		piece.setDesign(prevPiece.getDesign());
		reader.close();
	}

	@Override
	public void undo(Piece piece) {
		if (prevPiece != null) {
			piece = prevPiece;
		}
	}

	@Override
	public String getDescription() {
		return "Choose a type";
	}

}
