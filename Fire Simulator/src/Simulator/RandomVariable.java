package Simulator;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomVariable {

	static DecimalFormat format = new DecimalFormat("#.#####"); 

	//Humidade Inverno
	public static String humidadeInverno(){
		double U = Math.random();
		double H;
		double limit = 0.6666666667;
		if(U <= limit) 
			H= 40 + Math.sqrt(1600 - 2400*(limit -U));
		else
			H=10*U + 80;
		return format.format(H);
	}

	// Humidade Primavera
	public static String humidadePrimavera() {
		return format.format(30*Math.random() +50);
	}

	//Humidade Verão
	public static String humidadeVerao() {
		double U = Math.random();
		double L= 4.444444444;
		return format.format(70 - Math.sqrt(4900 - 900*(L+U)));
	}

	//Humidade Outono
	public static String humidadeOutono() {
		double U = Math.random();
		double L= 2.77777778;
		return format.format(50 + Math.sqrt(2500 -900*(L -U)));
	}

	//Temperatura Inverno
	public static String temperaturaInverno() {
		double U = Math.random();
		return format.format(13*U+2);
	}

	// Temperatura Primavera

	public static String temperaturaPrimavera() {
		double U = Math.random();
		double limite = 0.1764705882;
		if( U <= limite) {
			double L = 0.4901960784;
			return format.format(10 + Math.sqrt(100 - 204*(L-U)));
		}
		else {
			return format.format(17*U +13);
		}
	}

	//Temperatura outono
	public static String temperaturaOutono() {
		double U = Math.random();
		double limite = 0.470588235;
		double L;
		if(U < limite ) {
			L= 0.352941176;
			return format.format(17*(L +U));
		}
		else {
			L=0.673202614;
			return format.format(32-Math.sqrt(1024-612*(L + U)));
		}
	}

	// temperatura verão
	
	public static String temperaturaVerao() {
		double U1 = Math.random();
		double limit1 = 0.00134;
		double limit2 = 0.99732;
		if(U1 < limit1)
			return format.format(14);
		else if(U1>= limit1 && U1 <= limit2) {
			double U2 = Math.random();
			return format.format(Math.sqrt(-2*Math.log(U1))*Math.cos(2*Math.PI*U2)*10 +30);
		}
		else
			return  format.format(44);
	}



	// Vento Inverno

	public static String ventoInverno() {
		double U =  Math.random();
		return format.format(20*U);
	}

	// vento Verão

	public static String ventoVerao() {
		double U =  Math.random();
		return format.format(25 - Math.sqrt(625 - 625*U));
	}

	// Vento Outono

	public static String ventoOutono() {
		double U =  Math.random();
		double limit1 =0.3125; // 5/16 =0.3125
		double limit2 = 0.6875; // 11/16 = 0.6875
		double L;
		if(U <= limit1) {
			L= 0.05; //1/20 = 0.05
			return format.format(10 + Math.sqrt(100-2000*(L-U)));
		}
		else if(U <= limit2 && U>=limit1) {
			L=0.5625;
			return format.format(40*(L +U));
		}
		else {
			L = 1.8125;
			return format.format(75-Math.sqrt(5625 - 2000*(L + U)));
		}
	}
	
		// Vento primavera
	public static String ventoPrimavera() {
		double U = Math.random();
		double limit = 0.4; // 2/5 =0.4
		double v;
		if(U  <= limit) {
			v=12.500000*U;
			return format.format(v);
		}
		else {
			double L = 0.066666666;
			v= 20 - Math.sqrt(400 - 375*(L + U));
			return format.format(v);
		}
		
			
	}
	
	// Precipitação Inverno
	
	public static String precipitacaoInverno() {
		double U = Math.random();
		if(U<0.2)
			return format.format(0);
		return format.format(1);
	}
	// Precipitação primavera
	public static String precipitacaoPrimavera() {
		double U = Math.random();
		if(U <= 0.5)
			return format.format(0);
		return format.format(1);
	}
	
	// Precipitação verão
	public static String precipitacaoVerao() {
		double U = Math.random();
		if(U <= 0.8)
			return format.format(0);
		return format.format(1);
	}
	
	// Precipitação Outono
	public static String precipitacaoOutono() {
		double U = Math.random();
		if(U <= 0.4)
			return format.format(0);
		return format.format(1);
	}
	
	
	// Pluviosidade Inverno
	
	public static String pluviosidadeInverno() {
		double U = Math.random();
		if(U <= 0.1)
			return format.format(4);
		else if(U > 0.1 && U <=0.2)
			return format.format(6);
		else if(U > 0.2 && U <=0.4)
			return format.format(8);
		return format.format(10);
	}
	
	
	public static String pluviosidadePrimavera() {
		double U = Math.random();
		if(U <= 0.1)
			return format.format(2);
		else if(U > 0.1 && U <=0.6)
			return format.format(4);
		else if(U > 0.6 && U <=0.8)
			return format.format(6);
		else if(U > 0.8 && U <=0.9)
			return format.format(8);
		return format.format(10);
	}
	
	public static String pluviosidadeVerao() {
		double U = Math.random();
		if(U <= 0.5)
			return format.format(2);
		else if(U > 0.5 && U <=0.8)
			return format.format(4);
		else if(U > 0.8 && U <=0.9)
			return format.format(6);
		else if(U > 0.9 && U <=0.97)
			return format.format(8);
		return format.format(10);
	}
	
	public static String pluviosidadeOutono() {
		double U = Math.random();
		if(U <= 0.05)
			return format.format(2);
		else if(U > 0.05 && U <=0.35)
			return format.format(4);
		else if(U > 0.35 && U <=0.75)
			return format.format(6);
		else if(U > 0.75 && U <=0.95)
			return format.format(8);
		return format.format(10);
	}
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		List<String> PI = new ArrayList<>();
	  List<String> PP = new ArrayList<>();
		List<String> PV = new ArrayList<>();
		List<String> PO = new ArrayList<>();
		for(int i =0; i< 1000; i++) {
			PI.add(pluviosidadeInverno());
			PP.add(pluviosidadePrimavera());
			PV.add(pluviosidadeVerao());
			PO.add(pluviosidadeOutono());
		}
		System.out.println(PI);
		System.out.println(PP);
		System.out.println(PV);
		System.out.println(PO);

	/*			FileOutputStream fos = new FileOutputStream("pluviosidade.csv", true);

		PrintWriter pw = new PrintWriter(fos);

		pw.println("pluviosidade Inverno; pluviosidade Primavera; pluviosidade Verão; pluviosidade Outono");
		for(int i =0; i< 1000; i++)
			pw.println(PI.get(i)+ "; "+ PP.get(i) + "; "+ PV.get(i) + "; "+ PO.get(i));

		pw.close();*/

	}
}
