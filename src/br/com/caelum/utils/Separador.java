package br.com.caelum.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Separador {

	private LineNumberReader linhaLeitura;
	
	public LinkedList<String> carrega() throws IOException {

		LinkedList<String> arquivo = new LinkedList<>();
		
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		File arquivoLeitura = new File("arquivo.txt");
		linhaLeitura = new LineNumberReader(new FileReader(arquivoLeitura));
		linhaLeitura.skip(arquivoLeitura.length());
		int nLinhas = linhaLeitura.getLineNumber();
		
		Scanner scanner = new Scanner(br);
		String linha = "";
		
		for (int i = 0; i < nLinhas; i++) {
			linha += scanner.nextLine();
			arquivo.add(linha);
		}
		
		br.close();
		scanner.close();
		
		return arquivo;
	}
}
