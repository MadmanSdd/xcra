package br.com.code;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public abstract class ScanPort {

	public static boolean ScanPortasAbertas(String ip, int porta, int timeout) {
	    try {
			Socket socket = new Socket();
			String ip_limpo = ip.replaceAll("/", "").replace(":","").replaceAll("http", "");
			socket.connect(new InetSocketAddress(resolverNomeToIp(ip_limpo), porta), timeout);
			socket.close();
			return true;
	    } catch (Exception ex) {
	    	ex.printStackTrace();// pilhas de erro
	    	return false;
	    }
	}
	
	public static String resolverNomeToIp(String ip) {
		InetAddress address;
		try {
			address = InetAddress.getByName(ip);
			String ip_scan =  address.getHostAddress();
			return ip_scan;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
