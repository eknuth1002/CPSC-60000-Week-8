package com.elliotknuth.Factories;

import java.util.ArrayList;
import java.util.Scanner;

import com.elliotknuth.Create;
import com.elliotknuth.Enums;
import com.elliotknuth.PotteryCommand;
import com.elliotknuth.Enums.LocationEnums;
import com.elliotknuth.Pieces.Cup;
import com.elliotknuth.Pieces.LargeBowl;
import com.elliotknuth.Pieces.LargePlate;
import com.elliotknuth.Pieces.Mug;
import com.elliotknuth.Pieces.Piece;
import com.elliotknuth.Pieces.SmallBowl;
import com.elliotknuth.Pieces.SmallPlate;
import com.elliotknuth.Pieces.Teapot;

public abstract class PotteryFactory {
	Enums.LocationEnums region;
	ArrayList<PotteryCommand> commandList = new ArrayList<>();	
	public LocationEnums getRegion() { return region; }
	private Piece piece = null;
	private String styleDescription;
	
	public abstract Piece designPiece();
	
	public String getInput() {
		Scanner reader = new Scanner(System.in);
		String input = "";
		
		boolean properInput = false;
		while (!properInput) 
		{
			input = String.valueOf(reader.next().charAt(0));
			if (input.equalsIgnoreCase("R")) {
				System.out.println("\n");
				piece.setClay(null);
				break;
			}
			
			try {
				int choice = Integer.valueOf(input);
				if (choice < 0 || choice > (commandList.size() - 1)) {
					throw new NumberFormatException(); 
				}
				else {
					properInput = true;
					reader.close();
				}
			} catch (NumberFormatException e) {
				System.out.println("You have entered an invalid choice.  Please try again");
			}
		}
		return input;
	}
	

	
	public String getStyle() {
		return styleDescription;
	}
	public void printFactoryHeader() {
		System.out.println("You are now designing a piece in the style of " + getRegion());
		System.out.println(styleDescription);
	}
	
	public void printFactoryMenu() {
		for (int i = 0; i < commandList.size(); i++) {
			//skip Create command if the piece is null
			if (commandList.get(i).getClass() == Create.class && piece.isBuilt()) {
				System.out.println("("+ i +") " + commandList.get(i).getDescription());
				continue;
			}
			System.out.println("("+ i +") " + commandList.get(i).getDescription());
		}
		System.out.println("(R) Return the main menu");
	}

	public abstract ArrayList<Enums.Designs> getDesigns();
}
