package br.com.caelum.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import br.com.caelum.utils.Separador;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		Socket cliente = servidor.accept();
		System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress());

		Separador separador = new Separador();
		
		Scanner entrada = separador.salva(cliente);
		
		entrada.close();
		servidor.close();
	}
}
