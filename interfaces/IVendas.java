package br.com.rafael.interfaces;

import java.util.List;

import br.com.rafael.model.Vendas;

public interface IVendas {
	
	public void inserirVendas(Vendas objv) throws Exception;

	public List<Vendas> listaTodos() throws Exception;

	public void excluirVendas(int id) throws Exception;

	public void atualizarVendas(Vendas objv) throws Exception;

	public Vendas retornaVendas(int id) throws Exception;

}
