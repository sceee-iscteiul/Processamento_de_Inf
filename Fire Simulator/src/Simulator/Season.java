package Simulator;

public enum Season {
	INVERNO(1),PRIMAVERA(2),VERAO(3),OUTONO(4);
	
	private final int n;
	
	Season(int n){
		this.n=n;
	}
	
	public int getN() {
		return n;
	}
	
	public static Season getRandomSeason() {
		double U = Math.random();
		if(U < 0.10)
			return INVERNO;
		else if(U < 0.20 && U> 0.10)
			return PRIMAVERA;
		else if(U >0.20 && U <0.70)
			return VERAO;
		else
			return Season.OUTONO;
	}
	
	public static Season updateSeason(Season season) {
		switch (season) {
		case INVERNO:
			return Season.PRIMAVERA;
		case PRIMAVERA:
			return Season.VERAO;
		case VERAO:
			return OUTONO;
		case OUTONO:
			return INVERNO;
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
		}
	}
	
}
