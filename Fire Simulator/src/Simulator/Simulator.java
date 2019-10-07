package Simulator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;


public class Simulator implements Observer {

	private static Simulator INSTANCE;
	private static final int max_x=10;
	private static final int max_y=10;
	private List<FireSimulatorObject> objects = new ArrayList<FireSimulatorObject>();
	
	
	private Simulator() {
		INSTANCE=this;
		ImageMatrixGUI.setSize(max_x, max_y);
		load();
	}
	
	private void load() {
		for(int i =0; i<max_y; i++) {
			for(int j =0; j<max_x-1; j++) {
				objects.add(new Sky(new Point2D(i,j)));
				
			}
		}
		
		for(int x = 0; x<max_x; x++) {
			objects.add(new Land(new Point2D(x, max_y-1)));
			
		}
		objects.add(new Rain(new Point2D((int)(Math.random()*max_x),0)));
		 objects.add(new Rain(new Point2D((int)(Math.random()*max_x),0)));
		
		
		for(FireSimulatorObject o:objects) {
		ImageMatrixGUI.getInstance().addImage(o);
		}
	}
	
	public void addFireSimulatorObject(FireSimulatorObject f) {
		this.objects.add(f);
		ImageMatrixGUI.getInstance().addImage(f);
	}
	
	public static Simulator getInstance() {
		return INSTANCE;	
	}
	
	public void removeFireSimulatorObject(FireSimulatorObject o) {
		objects.remove(o);
		ImageMatrixGUI.getInstance().removeImage(o);
		
		
	}
	
	String geraTemperatura() {
		double u = Math.random();
		double t= 10*u+30;
		 DecimalFormat formatador = new DecimalFormat("0.00");
		 return formatador.format(t);
	}
	
	public Interactable getInteractableAt(Point2D p) {
		for(FireSimulatorObject o : objects) {
			if(o instanceof Interactable && o.getPosition().equals(p)) {
			return ((Interactable)o);
			}
			
		}
		return null;
	}
	
	public void updateFireSimulatorObject() {
		List<Updatable> up = new ArrayList<>();
		for(FireSimulatorObject o: objects) {;
			if(o instanceof Updatable)
				up.add((Updatable) o);
		}
		for(Updatable a : up)
			a.update();
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(((int)arg1) == 2) {
			updateFireSimulatorObject();
		 addFireSimulatorObject(new Rain(new Point2D((int)(Math.random()*max_x),0)));
		 addFireSimulatorObject(new Rain(new Point2D((int)(Math.random()*max_x),0)));
		}
		else {
		 ImageMatrixGUI.getInstance().setStatusMessage("temperatura: "+geraTemperatura()+"º"+"         vento 50km/h ");
		
		}
		
		
		 ImageMatrixGUI.getInstance().update();
	}

	
	private void starSimulator()
	{
		ImageMatrixGUI.getInstance().addObserver(this);
		ImageMatrixGUI.getInstance().go();	
	}
	
	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.starSimulator();
		
	}
}
