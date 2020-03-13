package br.com.rafael.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.rafael.conexao.Conexao;
import br.com.rafael.interfaces.ICliente;
import br.com.rafael.model.Cliente;

public class ClienteDao extends Conexao implements ICliente {

	Connection con;
	ResultSet rs;
	Statement stm;
	PreparedStatement pstmt;

	public ClienteDao() {

	}

	@Override
	public void inserirCliente(Cliente objc) throws Exception {
		con = this.conectar();
		String sqlI = "Insert into clientes (nome,telefone,cpf) values (?,?,?)";
		pstmt = con.prepareStatement(sqlI);
		pstmt.setString(1, objc.getNome());
		pstmt.setString(2, objc.getTelefone());
		pstmt.setString(3, objc.getCpf());
		pstmt.execute();
		con.close();
	}

	@Override
	public List<Cliente> listaTodos() throws Exception {
		con = this.conectar();
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente iclient;
		String sql = "select * from clientes";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			iclient = new Cliente();
			iclient.setId(rs.getInt("id"));
			iclient.setNome(rs.getString("nome"));
			iclient.setTelefone(rs.getString("telefone"));
			iclient.setCpf(rs.getString("cpf"));
			lista.add(iclient);
		}
		return lista;
	}

	@Override
	public void excluirCliente(int id) throws Exception {
		con = this.conectar();
		String sqlI = "delete from clientes where id = ?";
		pstmt = con.prepareStatement(sqlI);
		pstmt.setInt(1, id);
		pstmt.execute();
		con.close();

	}

	@Override
	public void atualizarCliente(Cliente objc) throws Exception {
		con = this.conectar();
		String sqlI = "update clientes set nome = ?, telefone = ?, cpf = ? where id = ?";
		pstmt = con.prepareStatement(sqlI);
		pstmt.setString(1, objc.getNome());
		pstmt.setString(2, objc.getTelefone());
		pstmt.setString(3, objc.getCpf());
		pstmt.setInt(4, objc.getId());
		pstmt.execute();
		con.close();

	}

	@Override
	public Cliente retornaCliente(int id) throws Exception {
		con = this.conectar();
		Cliente c = null;
		String sql = "select * from clientes where id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setTelefone(rs.getString("telefone"));
			c.setCpf(rs.getString("cpf"));
		}
		return c;
	}

}
