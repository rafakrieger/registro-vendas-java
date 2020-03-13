package br.com.rafael.interfaces;

import java.util.List;

import br.com.rafael.model.Cliente;

public interface ICliente {

	public void inserirCliente(Cliente objc) throws Exception;

	public List<Cliente> listaTodos() throws Exception;

	public void excluirCliente(int id) throws Exception;

	public void atualizarCliente(Cliente objc) throws Exception;

	public Cliente retornaCliente(int id) throws Exception;

}
