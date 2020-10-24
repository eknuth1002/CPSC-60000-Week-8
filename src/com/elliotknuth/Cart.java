package com.elliotknuth;

import java.util.ArrayList;
import java.util.HashMap;
import com.elliotknuth.Pieces.Piece;

public class Cart {
	private HashMap<Piece, Integer> pieces = new HashMap<>();
	private int iterator = 0;

	public HashMap<Piece, Integer> getCart() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		if (!pieces.containsKey(piece)){
			pieces.put(piece, 1);
		}
		else {
			pieces.put(piece, pieces.get(piece) + 1);
		}
	}
	
	public void removePiece(Piece piece) {
		if (pieces.containsKey(piece)) {
			int pieceNum = pieces.get(piece);
			pieceNum -= 1;
			if (pieceNum > 0) {
			pieces.put(piece,  - 1);
			}
			else {
				pieces.remove(piece);
			}
		}
	}
	
	public boolean clearCart() {
		pieces.clear();
		return true;
	}
	public int size() {
		return pieces.size();
	}
	
	public boolean hasNext() {
		return iterator < pieces.size() - 1;
	}
	
	public Piece getNext() {
		if (hasNext()) {
			return (Piece) pieces.keySet().toArray()[iterator++];
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public boolean hasPrev() {
		return iterator > 0;
	}
	
	public Piece getPrev() {
		if (hasPrev()) {
			return (Piece) pieces.keySet().toArray()[iterator--];
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void goToFirst() {
		iterator = 0;
	}
}

