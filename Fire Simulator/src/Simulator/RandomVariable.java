package Simulator;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomVariable {

	static DecimalFormat format = new DecimalFormat("#.###"); 
	
	public static final String HUMIDADE = "HUMIDADE";
	public static final String VENTO = "VENTO";
	public static final String TEMPERATURA= "TEMPERATURA";
	public static final String PRECIPITACAO = "PRECIPITACAO";
	public static final String PLUVIOSIDADE = "PLUVIOSIDADE";

	//Humidade Inverno
	public static double humidadeInverno(){
		double U = Math.random();
		double H;
		double limit = 0.6666666667;
		if(U <= limit) 
			H= 40 + Math.sqrt(1600 - 2400*(limit -U));
		else
			H=30*U + 60;
		return H;
	}

	// Humidade Primavera
	public static double humidadePrimavera() {
		return 30*Math.random() +50;
	}

	//Humidade Verão
	public static double humidadeVerao() {
		double U = Math.random();
		double L= 4.444444444;
		return 70 - Math.sqrt(4900 - 900*(L+U));
	}

	//Humidade Outono
	public static double humidadeOutono() {
		double U = Math.random();
		double L= 2.77777778;
		return 50 + Math.sqrt(2500 -900*(L -U));
	}

	//Temperatura Inverno
	public static double temperaturaInverno() {
		double U = Math.random();
		return 13*U+2;
	}

	// Temperatura Primavera

	public static double temperaturaPrimavera() {
		double U = Math.random();
		double limite = 0.1764705882;
		if( U <= limite) {
			double L = 0.4901960784;
			return 10 + Math.sqrt(100 - 204*(L-U));
		}
		else {
			return 17*U +13;
		}
	}

	//Temperatura outono
	public static double temperaturaOutono() {
		double U = Math.random();
		double limite = 0.470588235;
		double L;
		if(U < limite ) {
			L= 0.352941176;
			return 17*(L +U);
		}
		else {
			L=0.673202614;
			return 32-Math.sqrt(1024-612*(L + U));
		}
	}

	// temperatura verão
	
	public static double temperaturaVerao() {
		double U1 = Math.random();
		double limit1 = 0.00134;
		double limit2 = 0.99732;
		if(U1 < limit1)
			return 14;
		else if(U1>= limit1 && U1 <= limit2) {
			double U2 = Math.random();
			return Math.sqrt(-2*Math.log(U1))*Math.cos(2*Math.PI*U2)*5 +30;
		}
		else
			return  44;
	}



	// Vento Inverno

	public static double ventoInverno() {
		double U =  Math.random();
		return 20*U;
	}

	// vento Verão

	public static double ventoVerao() {
		double U =  Math.random();
		return 25 - Math.sqrt(625 - 625*U);
	}

	// Vento Outono

	public static double ventoOutono() {
		double U =  Math.random();
		double limit1 =0.3125; // 5/16 =0.3125
		double limit2 = 0.6875; // 11/16 = 0.6875
		double L;
		if(U <= limit1) {
			L= 0.05; //1/20 = 0.05
			return 10 + Math.sqrt(100-2000*(L-U));
		}
		else if(U <= limit2 && U>=limit1) {
			L=0.5625;
			return 40*(L +U);
		}
		else {
			L = 1.8125;
			return 75-Math.sqrt(5625 - 2000*(L + U));
		}
	}
	
		// Vento primavera
	public static double ventoPrimavera() {
		double U = Math.random();
		double limit = 0.4; // 2/5 =0.4
		double v;
		if(U  <= limit) {
			v=12.500000*U;
			return v;
		}
		else {
			double L = 0.066666666;
			v= 20 - Math.sqrt(400 - 375*(L + U));
			return v;
		}
		
			
	}
	
	// Precipitação Inverno
	
	public static int precipitacaoInverno() {
		double U = Math.random();
		if(U<0.2)
			return 0;
		return 1;
	}
	// Precipitação primavera
	public static int precipitacaoPrimavera() {
		double U = Math.random();
		if(U <= 0.5)
			return 0;
		return 1;
	}
	
	// Precipitação verão
	public static int precipitacaoVerao() {
		double U = Math.random();
		if(U <= 0.8)
			return 0;
		return 1;
	}
	
	// Precipitação Outono
	public static int precipitacaoOutono() {
		double U = Math.random();
		if(U <= 0.4)
			return 0;
		return 1;
	}
	
	
	// Pluviosidade Inverno
	
	public static int pluviosidadeInverno() {
		double U = Math.random();
		if(U <= 0.1)
			return 4;
		else if(U > 0.1 && U <=0.2)
			return 6;
		else if(U > 0.2 && U <=0.4)
			return 8;
		return 10;
	}
	
	
	public static int pluviosidadePrimavera() {
		double U = Math.random();
		if(U <= 0.1)
			return 2;
		else if(U > 0.1 && U <=0.6)
			return 4;
		else if(U > 0.6 && U <=0.8)
			return 6;
		else if(U > 0.8 && U <=0.9)
			return 8;
		return 10;
	}
	
	public static int pluviosidadeVerao() {
		double U = Math.random();
		if(U <= 0.5)
			return 2;
		else if(U > 0.5 && U <=0.8)
			return 4;
		else if(U > 0.8 && U <=0.9)
			return 6;
		else if(U > 0.9 && U <=0.97)
			return 8;
		return 10;
	}
	
	public  static int pluviosidadeOutono() {
		double U = Math.random();
		if(U <= 0.05)
			return 2;
		else if(U > 0.05 && U <=0.35)
			return 4;
		else if(U > 0.35 && U <=0.75)
			return 6;
		else if(U > 0.75 && U <=0.95)
			return 8;
		return 10;
	}
	
	private static double geraTemperatura(Season season) {
		switch (season) {
		case INVERNO:
			return temperaturaInverno();
		case PRIMAVERA:
			return temperaturaPrimavera();
		case VERAO:
			return temperaturaVerao();
		case OUTONO:
			return temperaturaOutono();
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid season for the temperature");
		}
	}
	
	private static double geraVento(Season season) {
		switch (season) {
		case INVERNO:
			return ventoInverno();
		case PRIMAVERA:
			return ventoPrimavera();
		case VERAO:
			return ventoVerao();
		case OUTONO:
			return ventoOutono();
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid season for the temperature");
		}
	}
	
	private static double geraPluviosidade(Season season) {
		switch (season) {
		case INVERNO:
			return pluviosidadeInverno();
		case PRIMAVERA:
			return pluviosidadePrimavera();
		case VERAO:
			return pluviosidadeVerao();
		case OUTONO:
			return pluviosidadeOutono();
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid season for the temperature");
		}
	}
	
	private static double geraPrecipitacao(Season season) {
		switch (season) {
		case INVERNO:
			return precipitacaoInverno();
		case PRIMAVERA:
			return precipitacaoPrimavera();
		case VERAO:
			return precipitacaoVerao();
		case OUTONO:
			return precipitacaoOutono();
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid season for the temperature");
		}
	}
	
	
	private static double geraHumidade(Season season) {
		switch (season) {
		case INVERNO:
			return humidadeInverno();
		case PRIMAVERA:
			return humidadePrimavera();
		case VERAO:
			return humidadeVerao();
		case OUTONO:
			return humidadeOutono();
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid season for the temperature");
		}
	}
	
	public static int right_left() {
		double U = Math.random();
		if(U <0.5)
			return 1;
		else return -1;
	}
	
	
	public static Map<String, Double> updateRandomVariable(Season season){
		Map<String, Double> resul = new HashMap<String, Double>();
		resul.put(HUMIDADE, Double.parseDouble(format.format(geraHumidade(season)).replace(',', '.')));
		resul.put(VENTO, Double.parseDouble(format.format(geraVento(season)).replace(',', '.')));
		resul.put(PLUVIOSIDADE, Double.parseDouble(format.format(geraPluviosidade(season)).replace(',', '.')));
		resul.put(TEMPERATURA, Double.parseDouble(format.format(geraTemperatura(season)).replace(',', '.')));
		resul.put(PRECIPITACAO, Double.parseDouble(format.format(geraPrecipitacao(season)).replace(',', '.')));
		return resul;
	}
	
	
}
