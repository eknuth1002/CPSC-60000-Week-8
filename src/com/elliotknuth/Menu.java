package com.elliotknuth;

import java.util.Scanner;

import com.elliotknuth.Enums.Menus;
import com.elliotknuth.Factories.AmericanPotteryFactory;
import com.elliotknuth.Factories.EnglishPotteryFactory;
import com.elliotknuth.Factories.JapanesePotteryFactory;
import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Pieces.Piece;

public class Menu {
	private Cart cart;
	
	private Menu() { }
	
	public Menu(Cart cart) {
		this.cart = cart;
	}
	
	public String printMenuAndGetInput(Enums.Menus menu) {
		print(menu);
		return getInput(menu);
	}
	
	private void print(Enums.Menus menu) {
		switch (menu) {
		case MAIN:
			printMainMenu();
			break;
		case ORDERING:
			printOrderMenu();
			break;
		case CART:
			printCartMenu();
		}
	}
	
	private void printMainMenu() {
		System.out.println("Welcome to the pottery shack.");
		if (cart.size() > 0) {
			System.out.println("Your cart has:");
			cart.goToFirst();
			while (cart.hasNext()) {
				Piece piece = cart.getNext();
				System.out.println(piece.getType() + "in the " + piece.getStyle() + " style with " + piece.getDesignDescription() + 
						" on " + piece.getClayDescription() + " clay " +
						piece.getOverglaze() != null ? "and a " + piece.getOverglaze().getDescription() + " overglaze" : "");
			}
		}
		System.out.println("Please choose one of the following options.");
		System.out.println("(1) Order a new piece");
		if (cart.size() > 0) {
			System.out.println("(2) Purchase items in cart");
		}
		System.out.println("(E) Exit the ordering system");
	}
	
	private void printOrderMenu() {
		System.out.println("Please select the style of the piece you wish to order.");
		System.out.println("(1) American");
		System.out.println("(2) English");
		System.out.println("(3) Japanese");
		System.out.println("(R) Return the main menu");
	}
	
	private void printCartMenu() {
		System.out.println("You are now in your shopping cart");
		StringBuilder pieceDesc = new StringBuilder();
		if (cart.size() > 0) {
			System.out.println("Your cart has:");
			cart.goToFirst();
			while (cart.hasNext()) {
				Piece piece = cart.getNext();
				pieceDesc.setLength(0);
				pieceDesc.append(piece.getType());
				if (piece.getDesignDescription() != "") {
					pieceDesc.append(" with " + piece.getDesignDescription());
				}
				if (piece.getOverglaze() != null) {
					pieceDesc.append("and a " + piece.getOverglaze() + " overglaze");
				}
				System.out.println(pieceDesc.toString());
			}
		}
		else {
			System.out.println("Your cart is currently empty");
		}
		System.out.println("Please choose one of the following options.");
		
		if (cart.size() > 0) {
			System.out.println("(1) Place your order");
			System.out.println("(2) Clear your cart");
		}
		System.out.println("(R) Return the main menu");
	}
	
	private String getInput(Enums.Menus menu) {
		Scanner reader = new Scanner(System.in);
		String input = "";
		
		
		boolean properInput = false;
		while (!properInput) 
		{
			input = String.valueOf(reader.next().charAt(0));
			if (input.equalsIgnoreCase("E")) {
				break;
			}
			
			switch (menu) {
				case MAIN:
					properInput = isValidMainMenuInput(input);
					break;
				case CART:
					properInput = isValidCartMenuInput(input);
					break;
				case ORDERING:
					properInput = isValidOrderMenuInput(input);
					break;	
			}
		}
		reader.close();
		return input;
	}
	
	private boolean isValidMainMenuInput(String input) {
		switch (input)  {
			case "1":
			case "2":
			case "E":
				return true;
			default:
				System.out.println("I'm sorry.  You did not enter a valid response.  Please try again.");
				return false;
		}
	}
	
	private boolean isValidOrderMenuInput(String input) {
		switch (input)  {
			case "1":
			case "2":
			case "3":
			case "R":
				return true;
			default:
				System.out.println("I'm sorry.  You did not enter a valid response.  Please try again.");
				return false;
		}
	}
	
	private boolean isValidCartMenuInput(String input) {
		switch (input)  {
			case "R":
				return true;
			default:
				System.out.println("I'm sorry.  You did not enter a valid response.  Please try again.");
				return false;
		}
	}
	
	public Menus processMainMenuInput(String input) {
		switch (input) {
			case "1":
				return Enums.Menus.ORDERING;
			default:
				return Menus.CART; 
		}
	}
	
	public Menus processOrderMenuInput(String input) {
		PotteryFactory factory;
		switch (input) {
			case "1":
				factory = new AmericanPotteryFactory();
				break;
			case "2":
				factory = new EnglishPotteryFactory();
				break;
			case "3":
				factory = new JapanesePotteryFactory();
				break;
			default:
				return Menus.MAIN;
		}
		
		Piece piece = factory.designPiece();
		if (piece.isBuilt()) {
			cart.addPiece(piece);
		}
		return Menus.ORDERING;
	}
	
	public Menus processCartMenuInput(String input) {
		switch (input) {
			case "1":
				System.out.println("You're order has been placed and a delivery confirmation number will be sent upon shipping.");
			case "2":
				cart.clearCart();
		}
		
		return Menus.MAIN;
	}
}
