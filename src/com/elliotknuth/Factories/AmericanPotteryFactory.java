package com.elliotknuth.Factories;

import com.elliotknuth.Enums.Designs;
import com.elliotknuth.Enums.LocationEnums;
import com.elliotknuth.Pieces.Piece;

import java.util.ArrayList;
import java.util.Scanner;

import com.elliotknuth.ChooseClay;
import com.elliotknuth.ChooseType;
import com.elliotknuth.Create;
import com.elliotknuth.DesignAdd;
import com.elliotknuth.DesignRemove;
import com.elliotknuth.Enums;
import com.elliotknuth.Clays.SedonaRed;
import com.elliotknuth.Clays.TerraCota;

public final class AmericanPotteryFactory extends PotteryFactory {
	private Piece piece = null;
	
	final String styleDescription =
			"The style of the Americas is heavily dependant on geometic shapes and unglazed or non-western glazes.\n\n"
			+ "Organic designs (such as animals, and insects) are common motifs found on pieces\n";
	public AmericanPotteryFactory() {
		this.region = LocationEnums.AMERICAS;
		commandList.add(new ChooseType());
		commandList.add(new ChooseClay());
		commandList.add(new DesignAdd());
		commandList.add(new DesignRemove());
		commandList.add(new Create());
	}

	@Override
	public Piece designPiece() {
		printFactoryHeader();
		String input = "";
		while (!input.equalsIgnoreCase("R") && !input.equalsIgnoreCase(String.valueOf(commandList.size() - 1))) {
			printFactoryMenu();
			input = getInput();
			commandList.get(Integer.valueOf(input)).execute(piece, this);
		}
		return piece;
	}

	@Override
	public ArrayList<Enums.Designs> getDesigns() {
		ArrayList<Enums.Designs> designs = new ArrayList<>();
		
		designs.add(Designs.GEOMETERIC);
		designs.add(Designs.HUNTING);
		
		return designs;
	}
}