package com.elliotknuth.Pieces;

import com.elliotknuth.Enums;
import com.elliotknuth.Enums.PieceEnums;
import com.elliotknuth.Clays.Clay;
import com.elliotknuth.Designs.Design;
import com.elliotknuth.Factories.PotteryFactory;
import com.elliotknuth.Glazes.Glaze;
import com.sun.prism.impl.BaseMesh.FaceMembers;

public abstract class Piece {
	PotteryFactory factory = null;
	Enums.PieceEnums type = null;
	Clay clay = null;
	Design design = null;
	Glaze overglaze = null;
	double weight = 0.0;
	
	public Enums.PieceEnums getType() {
		return type;
	}
	
	public String getClayDescription() {
		return clay.getDescription();
	}
	
	public void setClay(Clay clay) {
		this.clay = clay;
	}
	
	public Clay getClay() {
		try {
			return clay.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public double getCost() {
		double cost = 0.0;
		if (clay != null){
			cost += clay.getCostPerLb() * weight;
		}
		if (design != null) {
			cost += ((design.getCostPerOz() * weight) / 2);
		}
		if (overglaze != null) {
			cost += overglaze.getCostPerOz() * weight;
		}
		
		return cost;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public Design getDesign() {
		return design;
	}
	
	public void setDesign(Design design) {
		this.design = design;
	}
	
	public String getDesignDescription() {
		return design.getDescription();
	}
	
	public Glaze getOverglaze() {
		return overglaze;
	}
	
	public Glaze setOverglaze(Glaze overglaze) {
		return this.overglaze = overglaze;
	}
	
	public String getStyle() {
		return factory.getStyle();
	}

	public boolean isBuilt() {
		return clay != null;
	}	
}
