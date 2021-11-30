package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import class
import br.com.code.ScanPort;
import javax.swing.JTextArea;
import javax.swing.JList;

public class Main {

	private JFrame frmXcrad;
	private JTextField txt_ip;
	private JTextField txt_portas;
	private JList<Object> list_Result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmXcrad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmXcrad = new JFrame();
		frmXcrad.setTitle("XCRA");
		frmXcrad.getContentPane().setBackground(new Color(192, 192, 192));
		frmXcrad.setResizable(false);
		frmXcrad.setBounds(100, 100, 424, 368);
		frmXcrad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXcrad.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("IP ");
		lblNewLabel.setBounds(10, 36, 46, 14);
		frmXcrad.getContentPane().add(lblNewLabel);

		DefaultListModel model = new DefaultListModel();

		JButton btt_scan = new JButton("Scan");
		btt_scan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				list_Result.setModel(model);

					String ip_label = txt_ip.getText();
					String portas_Array[] = txt_portas.getText().split(",");
					for (int porta = 0; porta < portas_Array.length; porta++) {
						
						
						int convertPort = Integer.parseInt(portas_Array[porta]);
						if (ScanPort.ScanPortasAbertas(ip_label, convertPort, 200)) {
							String resolve_ip = ScanPort.resolverNomeToIp(ip_label.replaceAll("/", "").replace(":","").replaceAll("http", ""));
							model.addElement("IP: " + resolve_ip + " Porta: " + convertPort + " Aberta");
							list_Result.setModel(model);
							try {
								Thread.currentThread().sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}

			}
		});
		btt_scan.setBounds(329, 32, 67, 23);
		frmXcrad.getContentPane().add(btt_scan);

		txt_ip = new JTextField();
		txt_ip.setBounds(119, 33, 208, 20);
		frmXcrad.getContentPane().add(txt_ip);
		txt_ip.setColumns(10);

		JLabel lblXcra = new JLabel("xcra : Vr 0");
		lblXcra.setBounds(10, 11, 67, 14);
		frmXcrad.getContentPane().add(lblXcra);

		JLabel lblPorta = new JLabel("Porta / Portas");
		lblPorta.setBounds(10, 61, 67, 14);
		frmXcrad.getContentPane().add(lblPorta);

		txt_portas = new JTextField();
		txt_portas.setBounds(119, 58, 208, 20);
		frmXcrad.getContentPane().add(txt_portas);
		txt_portas.setColumns(10);

		JLabel lblIpScan = new JLabel("IP : 192.168.0.1");
		lblIpScan.setBounds(10, 287, 134, 14);
		frmXcrad.getContentPane().add(lblIpScan);

		JLabel lblPortaPortas = new JLabel("Porta / Portas :   80 / 21,25,80 ");
		lblPortaPortas.setBounds(10, 304, 261, 14);
		frmXcrad.getContentPane().add(lblPortaPortas);

		list_Result = new JList();
		list_Result.setBounds(10, 86, 386, 161);
		frmXcrad.getContentPane().add(list_Result);
		
		JLabel lblExemplo = new JLabel("Exemplo");
		lblExemplo.setBounds(10, 262, 67, 14);
		frmXcrad.getContentPane().add(lblExemplo);
	}
}
