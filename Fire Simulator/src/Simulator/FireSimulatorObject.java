package Simulator;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;

public abstract class FireSimulatorObject implements ImageTile{
	private Point2D position;
	
	public FireSimulatorObject(Point2D position) {
		this.position = position;
	}
	
	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	@Override
	public Point2D getPosition() {
		return position;
	}
	
	@Override
	public int getLayer() {
		return 0;
	}
	
	public void setPosition(Point2D position) {
		this.position= position;	
	}
}
