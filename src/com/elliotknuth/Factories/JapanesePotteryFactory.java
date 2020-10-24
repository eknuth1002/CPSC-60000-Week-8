package com.elliotknuth.Factories;

import com.elliotknuth.Enums.LocationEnums;
import com.elliotknuth.Pieces.Piece;
import com.elliotknuth.ChooseClay;
import com.elliotknuth.ChooseFiringTechnique;
import com.elliotknuth.Create;
import com.elliotknuth.DesignAdd;
import com.elliotknuth.DesignRemove;
import com.elliotknuth.GlazeAdd;
import com.elliotknuth.GlazeRemove;

public final class JapanesePotteryFactory extends PotteryFactory {
	private Piece piece = null;
	final String styleDescription = 
			"";
	
	public JapanesePotteryFactory() {
		region = LocationEnums.JAPAN;
		commandList.add(new ChooseClay());
		commandList.add(new DesignAdd());
		commandList.add(new DesignRemove());
		commandList.add(new GlazeAdd());
		commandList.add(new GlazeRemove());
		commandList.add(new ChooseFiringTechnique());
		commandList.add(new Create());
	}

	@Override
	public Piece designPiece() {
		printFactoryHeader();
		String input = "";
		Piece newPiece;
		while (!input.equalsIgnoreCase("R") && !input.equalsIgnoreCase(String.valueOf(commandList.size() - 1))) {
			printFactoryMenu();
			input = getInput();
			processInput(input);
		}
		return piece;
	}

	@Override
	public void processInput(String input) {
		switch (Integer.valueOf(input)) {
			case 1:
				//Add clay choices
				break;
			case 2:
				//Add Design Choices
				break;
			case 3:
				//list Designs on piece to remove
				String[] designs = piece.getDesignDescription().split(", ");
				break;
			case 4:
				break;
			case 5:
				piece.setOverglaze(null);
				break;
			case 6:
				getFiringTechnique();
		}
	}

	private void getFiringTechnique() {
		// TODO Auto-generated method stub
		
	}
}
