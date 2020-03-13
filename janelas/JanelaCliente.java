package br.com.rafael.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.rafael.dao.ClienteDao;
import br.com.rafael.model.Cliente;

public class JanelaCliente extends JFrame {

	JLabel lCod;
	JLabel lNome;
	JLabel lTel;
	JLabel lCpf;

	JTextField tCod;
	JTextField tTel;
	JTextField tNome;
	JTextField tCpf;

	JButton botaoSalvar;
	JButton botaoConsultar;
	JButton botaoExcluir;
	JButton botaoAtualizar;
	JButton botaoLimpar;

	public JanelaCliente() {

		lCod = new JLabel("Código");
		lCod.setBounds(5, 5, 100, 30);
		tCod = new JTextField();
		tCod.setBounds(70, 5, 300, 25);

		lNome = new JLabel("Nome");
		lNome.setBounds(5, 40, 100, 30);
		tNome = new JTextField();
		tNome.setBounds(70, 40, 300, 25);

		lTel = new JLabel("Telefone");
		lTel.setBounds(5, 75, 100, 30);
		tTel = new JTextField();
		tTel.setBounds(70, 75, 300, 25);

		lCpf = new JLabel("CPF");
		lCpf.setBounds(5, 110, 100, 30);
		tCpf = new JTextField();
		tCpf.setBounds(70, 110, 300, 25);

		this.add(lCod);
		this.add(lNome);
		this.add(lTel);
		this.add(lCpf);

		this.add(tCod);
		this.add(tNome);
		this.add(tTel);
		this.add(tCpf);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(5, 140, 200, 40);
		this.add(botaoSalvar);

		botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(220, 140, 200, 40);
		this.add(botaoConsultar);

		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(5, 200, 200, 40);
		this.add(botaoExcluir);

		botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.setBounds(220, 200, 200, 40);
		this.add(botaoAtualizar);

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(5, 250, 200, 40);
		this.add(botaoLimpar);

		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cliente objCliente = new Cliente();

				objCliente.setNome(tNome.getText());
				objCliente.setTelefone(tTel.getText());
				objCliente.setCpf(tCpf.getText());

				ClienteDao clienteDao = new ClienteDao();
				try {
					clienteDao.inserirCliente(objCliente);
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
					tNome.setText("");
					tTel.setText("");
					tCpf.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cliente objCliente = new Cliente();
				ClienteDao clienteDao = new ClienteDao();

				try {

					if (tCod.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio");

					} else {

						int id = Integer.parseInt(tCod.getText());
						objCliente = clienteDao.retornaCliente(id);

						if (objCliente != null) {
							tCod.setText("" + objCliente.getId());
							tNome.setText(objCliente.getNome());
							tTel.setText(objCliente.getTelefone());
							tCpf.setText(objCliente.getCpf());
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
				ClienteDao clienteDao = new ClienteDao();
				try {
					int id = Integer.parseInt(tCod.getText());
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente?");
					if (confirmar == 0) {
						clienteDao.excluirCliente(id);
						JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
						tCod.setText("");
						tNome.setText("");
						tTel.setText("");
						tCpf.setText("");
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
				tNome.setText("");
				tTel.setText("");
				tCpf.setText("");

			}
		});
		
		botaoAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente objCliente = new Cliente();

				objCliente.setId(Integer.parseInt(tCod.getText()));
				objCliente.setNome(tNome.getText());
				objCliente.setTelefone(tTel.getText());
				objCliente.setCpf(tCpf.getText());
				
				ClienteDao clienteDao = new ClienteDao();
				
				try {
					clienteDao.atualizarCliente(objCliente);
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
					tCod.setText("");
					tNome.setText("");
					tTel.setText("");
					tCpf.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});

		this.setTitle("Cadastro de Cliente");
		this.setSize(450, 350);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
