package Simulator;

import pt.iul.ista.poo.utils.Point2D;

public class Rain extends FireSimulatorObject implements Updatable   {

	public Rain(Point2D position) {
		super(position);
	}

	@Override
	public void update() {
		if(!(Simulator.getInstance().getInteractableAt(getPosition()) instanceof Land))
				setPosition(new Point2D(getPosition().getX(), getPosition().getY()+1));
		else {
		Simulator.getInstance().getInteractableAt(getPosition()).interact(this);
		Simulator.getInstance().removeFireSimulatorObject(this);	
		}
	}
	
	

}
