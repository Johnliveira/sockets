package br.com.caelum.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

		//----------------------------------------
		
		String arquivo = "";

		LinkedList<String> conversor = new LinkedList<>();

		InputStream is = new FileInputStream("recebido.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		File arquivoLeitura = new File("recebido.txt");
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
		
		OutputStream os = new FileOutputStream("recebido.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		PrintStream stream = new PrintStream("recebido.txt");
		
		bw.write(arquivo);
		
		System.out.println(arquivo);
		
		//------------------------------------
		
		stream.println(arquivo);
		
		while (entrada.hasNextLine()) {
			stream.println(entrada.nextLine());
		}
		
		entrada.close();
		is.close();
		isr.close();
		br.close();
		scanner.close();
		os.close();
		osw.close();
		br.close();
		stream.close();
		
		return entrada;
	}
}
