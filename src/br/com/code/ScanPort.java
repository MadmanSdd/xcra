package br.com.code;

import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public abstract class ScanPort {

	public static boolean ScanPortasAbertas(String ip, int porta, int timeout) {
	    try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(ip, porta), timeout);
			socket.close();
			return true;
	    } catch (Exception ex) {
	    	ex.printStackTrace();// pilhas de erro
	    	return false;
	    }
	}
}
