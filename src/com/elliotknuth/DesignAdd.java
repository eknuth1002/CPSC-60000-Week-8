package com.elliotknuth;

import java.util.ArrayList;
import java.util.Scanner;

import com.elliotknuth.Designs.Design;
import com.elliotknuth.Designs.Filigree;
import com.elliotknuth.Designs.Geometeric;
import com.elliotknuth.Designs.Hunting;
import com.elliotknuth.Designs.Ukiyo_e;
import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Pieces.Piece;

public class DesignAdd implements PotteryCommand {
	Design prevAddedDesign = null;

	@Override
	public void execute(Piece piece, PotteryFactory factory) {
		//Add Design Choices
		String input = null;
		Scanner reader = new Scanner(System.in);
		System.out.println("Please cloose one of the following designs:");
		factory.getDesigns();
		System.out.println("(C) Cancel");
		while (input == null) {
			input = String.valueOf(reader.next().charAt(0));
			if (input.toLowerCase().equals('c')) {
				return;
			}
			
			switch (input.toLowerCase()) {
				case "g":
					prevAddedDesign = new Geometeric(null);
					piece.setDesign(new Geometeric(piece.getDesign()));
					break;
				case "h":
					prevAddedDesign = new Hunting(null);
					piece.setDesign(new Hunting(piece.getDesign()));
					break;
				default:
					input = null;
			}
		}
		reader.close();
	}

	@Override
	public void undo(Piece piece) {
		ArrayList<Design> designs = new ArrayList<>();
		Design d = piece.getDesign();
		while (d != null) {
			designs.add(d);
			d = d.getNextDesign();
		}
		for (int i = 0; i < designs.size(); i++) {
			if (designs.get(i).getClass() == prevAddedDesign.getClass()) {
				designs.remove(i);
				prevAddedDesign = null;
				break;
			}
		}
		Design t = null;
		for (int i = designs.size() - 1; i >= 0; i--) {
			if (designs.get(i).getClass().isInstance(Filigree.class)) {
				t = new Filigree(t);
			}
			else if (designs.get(i).getClass().isInstance(Geometeric.class)) {
				t = new Geometeric(t);
			}
			else if (designs.get(i).getClass().isInstance(Hunting.class)) {
				t = new Hunting(t);
			}
			else if (designs.get(i).getClass().isInstance(Ukiyo_e.class)) {
				t = new Ukiyo_e(t);
			}
		}
	}

	@Override
	public String getDescription() {
		return "Add a design";
	}

}
