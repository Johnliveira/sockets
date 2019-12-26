package br.com.caelum.utils;

import java.io.InputStream;
import java.util.Scanner;

public class Recebedor implements Runnable {

	private InputStream servidor;
	
	public Recebedor(InputStream servidor) {
		super();
		this.servidor = servidor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner imprime = new Scanner(servidor);
		while (imprime.hasNextLine()) {
			System.out.println(imprime.nextLine());
		}
		imprime.close();
	}

}
