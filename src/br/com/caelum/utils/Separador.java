package br.com.caelum.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class Separador {

	private LineNumberReader linhaLeitura;

	public String carrega() throws IOException {

		String arquivo = "";

		LinkedList<String> conversor = new LinkedList<>();

		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		File arquivoLeitura = new File("arquivo.txt");
		linhaLeitura = new LineNumberReader(new FileReader(arquivoLeitura));
		linhaLeitura.skip(arquivoLeitura.length());
		int nLinhas = linhaLeitura.getLineNumber();

		Scanner scanner = new Scanner(br);

		for (int i = 0; i <= nLinhas; i++) {
			conversor.add(scanner.nextLine());
		}

		for (String string : conversor) {
			arquivo += string;
			arquivo += "\n";
		}

		br.close();
		scanner.close();

		return arquivo;
	}

	public Scanner salva(Socket cliente) throws IOException {

		Scanner entrada = new Scanner(cliente.getInputStream());

		PrintStream stream = new PrintStream("recebido.txt");

		while (entrada.hasNextLine()) {
			stream.println(entrada.nextLine());
		}

		stream.close();
		
		return entrada;
	}
}
