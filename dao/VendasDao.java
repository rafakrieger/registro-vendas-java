package br.com.rafael.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.rafael.conexao.Conexao;
import br.com.rafael.interfaces.IVendas;
import br.com.rafael.model.Cliente;
import br.com.rafael.model.Vendas;

public class VendasDao extends Conexao implements IVendas{
	
	Connection con;
	ResultSet rs;
	Statement stm;
	PreparedStatement pstmt;

	@Override
	public void inserirVendas(Vendas objv) throws Exception {
		con = this.conectar();
		String sqlI = "Insert into vendas (valor1,valor2,valor3,id_cliente) values (?,?,?,?)";
		pstmt = con.prepareStatement(sqlI);
		pstmt.setDouble(1, objv.getValor1());
		pstmt.setDouble(2, objv.getValor2());
		pstmt.setDouble(3, objv.getValor3());
		pstmt.setInt(4, objv.getIdCliente().getId());
		pstmt.execute();
		con.close();
		
	}

	@Override
	public List<Vendas> listaTodos() throws Exception {
		con = this.conectar();
		List<Vendas> lista = new ArrayList<Vendas>();
		Vendas ivendas;
		Cliente objCliente = new Cliente();
		String sql = "SELECT * FROM vendas,clientes WHERE vendas.id_cliente = clientes.id";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			ivendas = new Vendas();
			ivendas.setId(rs.getInt("id"));
			ivendas.setValor1(rs.getDouble("valor1"));
			ivendas.setValor2(rs.getDouble("valor2"));
			ivendas.setValor3(rs.getDouble("valor3"));
			objCliente.setId(rs.getInt("id_cliente"));
			ivendas.setIdCliente(objCliente);
			lista.add(ivendas);
		}
		return lista;
	}

	@Override
	public void excluirVendas(int id) throws Exception {
		con = this.conectar();
		String sqlI = "delete from vendas where id = ?";
		pstmt = con.prepareStatement(sqlI);
		pstmt.setInt(1, id);
		pstmt.execute();
		con.close();
		
	}

	@Override
	public void atualizarVendas(Vendas objv) throws Exception {
		con = this.conectar();
		String sqlI = "update vendas set valor1 = ?, valor2 = ?, valor3 = ?, id_cliente = ? where id = ?";
		pstmt = con.prepareStatement(sqlI);
		pstmt.setDouble(1, objv.getValor1());
		pstmt.setDouble(2, objv.getValor2());
		pstmt.setDouble(3, objv.getValor3());
		pstmt.setInt(4, objv.getIdCliente().getId());
		pstmt.execute();
		con.close();
		
	}

	@Override
	public Vendas retornaVendas(int id) throws Exception {
		con = this.conectar();
		Vendas v = null;
		Cliente objCliente = new Cliente();
		String sql = "select * from vendas where id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			v = new Vendas();
			v.setId(rs.getInt("id"));
			v.setValor1(rs.getDouble("valor1"));
			v.setValor2(rs.getDouble("valor2"));
			v.setValor3(rs.getDouble("valor3"));
			objCliente.setId(rs.getInt("id_cliente"));
			v.setIdCliente(objCliente);
		}
		return v;
	}
	
	

}
