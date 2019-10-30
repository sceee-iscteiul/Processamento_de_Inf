package Simulator;

import pt.iul.ista.poo.utils.Point2D;

public class Land extends FireSimulatorObject implements Interactable, Updatable{

	public Land(Point2D position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact(FireSimulatorObject o) {
		if(o instanceof Rain) {
		//	System.out.println("land interact with rain");
		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
