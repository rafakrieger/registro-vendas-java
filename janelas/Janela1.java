package br.com.rafael.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Janela1 extends JFrame {

	public static void main(String[] args) {

		Janela1 objJ = new Janela1();
		JMenuBar barraMenu = new JMenuBar();
		JMenu cadastro = new JMenu("Cadastro");
		JMenuItem cadastroCliente = new JMenuItem("Cliente");
		JMenuItem cadastroVendas = new JMenuItem("Vendas");

		cadastroCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new JanelaCliente();

			}
		});

		cadastroVendas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaVendas();

			}
		});

		objJ.setTitle("Controle de Estoque");
		objJ.setLayout(null);
		objJ.setSize(500, 500);
		objJ.setLocationRelativeTo(null);
		objJ.setDefaultCloseOperation(EXIT_ON_CLOSE);

		barraMenu.add(cadastro);
		cadastro.add(cadastroCliente);
		cadastro.add(cadastroVendas);

		objJ.setJMenuBar(barraMenu);

		objJ.setVisible(true);

	}

}
