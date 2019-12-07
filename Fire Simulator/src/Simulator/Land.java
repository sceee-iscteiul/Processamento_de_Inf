package Simulator;

import pt.iul.ista.poo.utils.Point2D;

public class Land extends FireSimulatorObject implements Interactable, Updatable{

	private boolean onFire;
	private static int  LIMIAR_APAGAR_FOGO = 2;
	public Land(Point2D position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact(FireSimulatorObject o) {
		if(o instanceof Rain) { 
			if(LIMIAR_APAGAR_FOGO==0)
				onFire = false;
			else
				LIMIAR_APAGAR_FOGO -=1; 
		}
	}
	
	public boolean isOnFire() {
		LIMIAR_APAGAR_FOGO = 2;
		return onFire;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void setFire() {
		this.onFire = true;
	}
	
	public String getName() {
		if(onFire)
			return "fire";
		else
			return "land";
	}

}
