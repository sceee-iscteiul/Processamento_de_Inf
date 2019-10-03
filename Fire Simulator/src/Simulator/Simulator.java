package Simulator;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
	
	
	public Simulator() {
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
	
	String geraTemperatura() {
		double u = Math.random();
		double t= 10*u+30;
		 DecimalFormat formatador = new DecimalFormat("0.00");
		 return formatador.format(t);
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		 ImageMatrixGUI.getInstance().setStatusMessage("temperatura: "+geraTemperatura()+"º"+"         vento 50km/h ");
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
