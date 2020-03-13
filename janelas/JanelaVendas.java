package br.com.rafael.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import br.com.rafael.dao.VendasDao;
import br.com.rafael.model.Cliente;
import br.com.rafael.model.Vendas;

public class JanelaVendas extends JFrame {

	JLabel lCod;
	JLabel lValor1;
	JLabel lValor2;
	JLabel lValor3;
	JLabel lIdCliente;

	JTextField tCod;
	JTextField tValor1;
	JTextField tValor2;
	JTextField tValor3;
	JTextField tIdCliente;

	JButton botaoSalvar;
	JButton botaoConsultar;
	JButton botaoExcluir;
	JButton botaoAtualizar;
	JButton botaoLimpar;
	JButton botaoClientes;

	public JanelaVendas() {

		lCod = new JLabel("Código");
		lCod.setBounds(5, 5, 100, 30);
		tCod = new JTextField();
		tCod.setBounds(70, 5, 300, 25);

		lValor1 = new JLabel("Valor 1");
		lValor1.setBounds(5, 40, 100, 30);
		tValor1 = new JTextField();
		tValor1.setBounds(70, 40, 300, 25);

		lValor2 = new JLabel("Valor 2");
		lValor2.setBounds(5, 75, 100, 30);
		tValor2 = new JTextField();
		tValor2.setBounds(70, 75, 300, 25);

		lValor3 = new JLabel("Valor 3");
		lValor3.setBounds(5, 110, 100, 30);
		tValor3 = new JTextField();
		tValor3.setBounds(70, 110, 300, 25);

		lIdCliente = new JLabel("ID Cliente");
		lIdCliente.setBounds(5, 145, 100, 30);
		tIdCliente = new JTextField();
		tIdCliente.setBounds(70, 145, 300, 25);

		this.add(lCod);
		this.add(lValor1);
		this.add(lValor2);
		this.add(lValor3);
		this.add(lIdCliente);

		this.add(tCod);
		this.add(tValor1);
		this.add(tValor2);
		this.add(tValor3);
		this.add(tIdCliente);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(5, 180, 200, 40);
		this.add(botaoSalvar);

		botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(220, 180, 200, 40);
		this.add(botaoConsultar);

		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(5, 240, 200, 40);
		this.add(botaoExcluir);

		botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.setBounds(220, 240, 200, 40);
		this.add(botaoAtualizar);

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(5, 300, 200, 40);
		this.add(botaoLimpar);

		botaoClientes = new JButton("Clientes");
		botaoClientes.setBounds(220, 300, 200, 40);
		this.add(botaoClientes);

		botaoClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {

				VendasDao cliente = new VendasDao();

				try {
					
					JFrame f = new JFrame();
					f.setTitle("Vendas por cliente");
					f.setSize(700, 200);
					f.setVisible(true);
					
					List<Vendas> dados = cliente.listaTodos();
										
					JTable j = new JTable((TableModel) dados);
										
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				

			}
		});

		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Vendas objVendas = new Vendas();
				Cliente objCliente = new Cliente();

				objVendas.setValor1(Double.parseDouble(tValor1.getText()));
				objVendas.setValor2(Double.parseDouble(tValor2.getText()));
				objVendas.setValor3(Double.parseDouble(tValor1.getText()));
				objCliente.setId(Integer.parseInt(tIdCliente.getText()));
				objVendas.setIdCliente(objCliente);

				VendasDao vendasDao = new VendasDao();
				try {
					vendasDao.inserirVendas(objVendas);
					JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso");
					tValor1.setText("");
					tValor2.setText("");
					tValor3.setText("");
					tIdCliente.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Vendas objVendas = new Vendas();
				VendasDao vendasDao = new VendasDao();

				try {

					if (tCod.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio");

					} else {

						int id = Integer.parseInt(tCod.getText());
						objVendas = vendasDao.retornaVendas(id);
						Cliente objCliente = new Cliente();

						if (objVendas != null) {
							tCod.setText("" + objVendas.getId());
							tValor1.setText("" + objVendas.getValor1());
							tValor2.setText("" + objVendas.getValor2());
							tValor3.setText("" + objVendas.getValor3());
							tIdCliente.setText("" + objVendas.getIdCliente());
						} else {
							JOptionPane.showMessageDialog(null, "Consulta inválida");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendasDao vendasDao = new VendasDao();
				try {
					int id = Integer.parseInt(tCod.getText());
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente?");
					if (confirmar == 0) {
						vendasDao.excluirVendas(id);
						JOptionPane.showMessageDialog(null, "Item excluído com sucesso");
						tCod.setText("");
						tValor1.setText("");
						tValor2.setText("");
						tValor3.setText("");
						tIdCliente.setText("");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		botaoLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tCod.setText("");
				tValor1.setText("");
				tValor2.setText("");
				tValor3.setText("");
				tIdCliente.setText("");
			}
		});

		botaoAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Vendas objVendas = new Vendas();
				Cliente objCliente = new Cliente();

				objVendas.setId(Integer.parseInt(tCod.getText()));
				objVendas.setValor1(Double.parseDouble(tValor1.getText()));
				objVendas.setValor2(Double.parseDouble(tValor2.getText()));
				objVendas.setValor3(Double.parseDouble(tValor1.getText()));
				objCliente.setId(Integer.parseInt(tIdCliente.getText()));
				objVendas.setIdCliente(objCliente);

				VendasDao vendasDao = new VendasDao();

				try {
					vendasDao.atualizarVendas(objVendas);
					JOptionPane.showMessageDialog(null, "Item atualizado com sucesso");
					tCod.setText("");
					tValor1.setText("");
					tValor2.setText("");
					tValor3.setText("");
					tIdCliente.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		this.setTitle("Cadastro de Vendas");
		this.setSize(500, 400);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
