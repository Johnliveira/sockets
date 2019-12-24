package br.com.caelum.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.caelum.utils.CapConexao;

public class Servidor {

	private static ServerSocket servidor;

	public static void main(String[] args) throws IOException {

		servidor = new ServerSocket(12345);

		System.out.println("Porta 12345 aberta!");

		while (true) {
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
			CapConexao conexao = new CapConexao(cliente);
			Thread t = new Thread(conexao);
			t.start();
		}
	}
}
