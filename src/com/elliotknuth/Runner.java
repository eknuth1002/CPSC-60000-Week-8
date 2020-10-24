package com.elliotknuth;

import com.elliotknuth.Enums.Menus;
import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Factories.EnglishPotteryFactory;
import com.elliotknuth.Factories.JapanesePotteryFactory;
import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Pieces.Piece;

public class Runner {

	public static void main(String[] args) {
		Enums.Menus currentMenu = Menus.MAIN;
		Cart cart = new Cart();
		Menu menus = new Menu(cart);
		String input = "";
		while (!input.equalsIgnoreCase("E")) {
			input = menus.printMenuAndGetInput(currentMenu);
			
			if (input.equalsIgnoreCase("E")) {
				System.out.println("Thank you for using our ordering system.  Goodbye.");
				break;
			}
			
			switch(currentMenu) {
				case MAIN:
					currentMenu = menus.processMainMenuInput(input);
					break;
				case CART:
					currentMenu = menus.processCartMenuInput(input);
					break;
				case ORDERING:
					currentMenu = menus.processOrderMenuInput(input);
					break;
			}

//			PotteryFactory japanesePF = new JapanesePotteryFactory();
//			PotteryFactory englishPF = new EnglishPotteryFactory();
//			
//			Piece japanesePiece = japanesePF.orderPiece(PieceEnums.CUP);
//			
//			System.out.println("");
//			Piece englishPiece = englishPF.orderPiece(PieceEnums.TEAPOT);
		}
	}
}