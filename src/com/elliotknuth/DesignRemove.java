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

public class DesignRemove implements PotteryCommand {
	Design prevRemovedDesign = null;
	
	@Override
	public void execute(Piece piece, PotteryFactory factory) {
		ArrayList<Design> designs = new ArrayList<>();
		Design d = piece.getDesign();
		while (d != null) {
			designs.add(d);
			d = d.getNextDesign();
		}
		System.out.println("Please select the design ytou wish to remove");
		for (int i = 0; i < designs.size(); i++) {
			System.out.println("(" + (i + 1) + ") " + designs.get(i).getDescription());
		}
		System.out.println("(C) Cancel");
		Scanner reader = new Scanner(System.in);
		String input = null;
		while (input == null) {
			input = String.valueOf(reader.next().charAt(0));
			if (input.toLowerCase().equals("c")) {
				return;
			}
			try {
				int i = Integer.valueOf(input);
				if (i > 0 && i <= designs.size()) {
					prevRemovedDesign = designs.remove(i);
					
					d = null;
					for (i = designs.size() - 1; i >= 0; i--) {
						if (designs.get(i).getClass().isInstance(Filigree.class)) {
							d = new Filigree(d);
						}
						else if (designs.get(i).getClass().isInstance(Geometeric.class)) {
							d = new Geometeric(d);
						}
						else if (designs.get(i).getClass().isInstance(Hunting.class)) {
							d = new Hunting(d);
						}
						else if (designs.get(i).getClass().isInstance(Ukiyo_e.class)) {
							d = new Ukiyo_e(d);
						}
					}
					piece.setDesign(d);
					prevRemovedDesign.setNextDesign(null);
				}
				else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid imput.  Please try again.");
				input = null;
			}
		}
		reader.close();
	}

	@Override
	public void undo(Piece piece) {
		if (prevRemovedDesign != null) {
			Design d = null;
			Design currDesign = piece.getDesign();
			if (prevRemovedDesign.getClass().isInstance(Filigree.class)) {
				 d = new Filigree(currDesign);
			}
			else if (prevRemovedDesign.getClass().isInstance(Geometeric.class)) {
				d = new Geometeric(currDesign);
			}
			else if (prevRemovedDesign.getClass().isInstance(Hunting.class)) {
				d = new Hunting(currDesign);
			}
			else if (prevRemovedDesign.getClass().isInstance(Ukiyo_e.class)) {
				d = new Ukiyo_e(currDesign);
			}
			piece.setDesign(d);
			prevRemovedDesign = null;
		}
	}

	@Override
	public String getDescription() {
		return "Remove a Design";
	}

}
