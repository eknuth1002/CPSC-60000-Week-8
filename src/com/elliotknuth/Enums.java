package com.elliotknuth;

import com.elliotknuth.Designs.Design;
import com.elliotknuth.Designs.Filigree;
import com.elliotknuth.Designs.Geometeric;
import com.elliotknuth.Designs.Hunting;
import com.elliotknuth.Designs.Ukiyo_e;

public class Enums {
	public static enum GlazeEnums {
		CLEAR {
			public String toString() {
				return "Clear";
			}
		}
	}
	
	public static enum Designs {
		FILIGREE {
			public Class getDesignClass() {
				return Filigree.class;
			}
		},
		GEOMETERIC {
			public Class getDesignClass() {
				return Geometeric.class;
			}
		},
		HUNTING {
			public Class getDesignClass() {
				return Hunting.class;
			}
		},
		UKIYO_E {
			public Class getDesignClass() {
		
				return Ukiyo_e.class;
			};
		}
	}
	
	public static enum ClayEnums {
		SEDONA_RED { 
			@Override
			public String toString() {
				return "Sedona Red";
			}
		},
		TERRA_COTA {
			@Override
			public String toString() {
				return "Terra Cota";
			}
		},
		PORCELAIN {
			@Override
			public String toString() {
				return "White Porcelain";
			}
		}
	}

	public static enum PieceEnums {
		CUP {
			public String toString() {
				return "cup";
			}
		},
		MUG {
			public String toString() {
				return "mug";
			}
		},
		SMALL_PLATE {
			public String toString() {
				return "small plate";
			}
		},
		LARGE_PLATE {
			public String toString() {
				return "large plate";
			}
		},
		SMALL_BOWL {
			public String toString() {
				return "small bowl";
			}
		},
		LARGE_BOWL {
			public String toString() {
				return "large bowl";
			}
		},
		TEAPOT {
			public String toString() {
				return "teapot";
			}
		}
	}
	
	public static enum LocationEnums {
		ENGLAND {
			public String toString() {
				return "England";
			}
		},
		JAPAN {
			public String toString() {
				return "Japan";
			}
		},
		AMERICAS {
			public String toString() {
				return "The Americas";
			}
		}
	}
	
	public static enum Menus {
		MAIN, ORDERING, CART;
	}
}