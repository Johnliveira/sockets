package br.com.caelum.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class IpServidor {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ip = new ServerSocket();
		
		ip.getInetAddress();
		System.out.println(InetAddress.getLocalHost());
		
		ip.close();
	}
}
