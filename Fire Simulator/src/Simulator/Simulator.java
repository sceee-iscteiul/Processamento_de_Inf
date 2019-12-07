package Simulator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;
import pt.iul.ista.poo.utils.Vector2D;

public class Simulator implements Observer {

	private static Simulator INSTANCE;
	private static final int max_x = 10;
	private static final int max_y = 10;
	private static final int LIMIAR_TEMPERATURA_FOGO = 20;
	private List<FireSimulatorObject> objects = new ArrayList<FireSimulatorObject>();
	private static int time_controller = 0; // Control of tick
	private Season season;
	private double temperatura;
	private double vento;
	private double humidade;
	private double precipitacao;
	private double pluviosidade;

	private Simulator() {
		INSTANCE = this;
		ImageMatrixGUI.setSize(max_x, max_y);
		load();
		season = Season.INVERNO;
		updateRandomVariable();
	}

	private void load() {
		for (int i = 0; i < max_y; i++) {
			for (int j = 0; j < max_x - 1; j++) {
				objects.add(new Sky(new Point2D(i, j)));

			}
		}

		for (int x = 0; x < max_x; x++) {
			objects.add(new Land(new Point2D(x, max_y - 1)));

		}
		objects.add(new Rain(new Point2D((int) (Math.random() * max_x), 0)));
		objects.add(new Rain(new Point2D((int) (Math.random() * max_x), 0)));
		objects.add(new Rain(new Point2D((int) (Math.random() * max_x), 0)));
		objects.add(new Rain(new Point2D((int) (Math.random() * max_x), 0)));

		for (FireSimulatorObject o : objects) {
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

	public Interactable getInteractableAt(Point2D p) {
		for (FireSimulatorObject o : objects) {
			if (o instanceof Interactable && o.getPosition().equals(p)) {
				return ((Interactable) o);
			}

		}
		return null;
	}

	// Update fire Simulators Objects only updateble objects
	public void updateFireSimulatorObject() {
		List<Updatable> up = new ArrayList<>();
		for (FireSimulatorObject o : objects) {
			;
			if (o instanceof Updatable)
				up.add((Updatable) o);
		}
		for (Updatable a : up)
			a.update();
	}

	public void updateRandomVariable() {
		Map<String, Double> random_vraiable = RandomVariable.updateRandomVariable(season);
		temperatura = random_vraiable.get(RandomVariable.TEMPERATURA);
		vento = random_vraiable.get(RandomVariable.VENTO);
		humidade = random_vraiable.get(RandomVariable.HUMIDADE);
		precipitacao = random_vraiable.get(RandomVariable.PRECIPITACAO);
		pluviosidade = random_vraiable.get(RandomVariable.PLUVIOSIDADE);
	}

	public void rain() {
		if (precipitacao == 1) {
			for (int i = 0; i < pluviosidade; i++) {
				addFireSimulatorObject(new Rain(new Point2D((int) (Math.random() * max_x), 0)));
			}
		}
	}

	public void start_fire(Land land) {
		if (precipitacao == 0 && temperatura > LIMIAR_TEMPERATURA_FOGO && humidade < 80) {
			// Land land = (Land) (getInteractableAt(new Point2D((int) (Math.random() *
			// max_x), max_y - 1)));
			land.setFire();
		}
	}

	public void spread_fire(Land land) {
		if (precipitacao == 0 && vento > 10) {
			Point2D p = land.getPosition();
			p.plus(new Vector2D(RandomVariable.right_left(), 0));
			if (ImageMatrixGUI.getInstance().isWithinBounds(p)) {
				Land land1 = (Land) (getInteractableAt(p));
				land1.setFire();
			}
		}
	}
	
	public void fire() {
		 Land land = (Land) (getInteractableAt(new Point2D((int) (Math.random() * max_x), max_y - 1)));
		 if(!land.isOnFire()) {
			 start_fire(land);
		 }
		 else
			 spread_fire(land);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		time_controller++;
		// Actualizar os Objectos que actualizam em meio segundo
		updateFireSimulatorObject();
		rain();
		fire();
		ImageMatrixGUI.getInstance().setStatusMessage("temperatura: " + temperatura + "º" + "   vento: " + vento
				+ "   humidade: " + humidade + "   estação: " + season + "   prec:" + precipitacao);
		if (time_controller % 20 == 0) {
			// actualiza variaveis aleatórias
			System.out.println("actualiza variaveis aleatórias " + time_controller);
			updateRandomVariable();
		}
		if (time_controller % 80 == 0) {
			// codigo para actualizar estação do ano
			season = Season.updateSeason(season);
		}

		ImageMatrixGUI.getInstance().update();
		if (time_controller > 80)
			time_controller = 0;

	}

	private void starSimulator() {
		ImageMatrixGUI.getInstance().addObserver(this);
		ImageMatrixGUI.getInstance().go();
	}

	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.starSimulator();

	}
}
