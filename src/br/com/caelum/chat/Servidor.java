package br.com.caelum.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import br.com.caelum.utils.CapConexao;

public class Servidor implements Runnable {

	private ServerSocket servidor;
	protected LinkedList<PrintStream> lista;

	public Servidor(ServerSocket servidor, LinkedList<PrintStream> lista) {
		super();
		this.servidor = servidor;
		this.lista = lista;
	}

	public void distribuiMensagem(String msg) {
		for (PrintStream cliente : lista) {
			cliente.println(msg);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			servidor = new ServerSocket(12345);

			while (true) {
				Socket cliente = servidor.accept();
				this.lista.add(new PrintStream(cliente.getOutputStream()));
				System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
				CapConexao conexao = new CapConexao(cliente);
				Thread t = new Thread(conexao);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Porta 12345 aberta!");

	}
}
