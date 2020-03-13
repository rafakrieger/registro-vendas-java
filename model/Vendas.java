package br.com.rafael.model;

import java.io.Serializable;

public class Vendas implements Serializable {

	private int id;
	private Double valor1;
	private Double valor2;
	private Double valor3;
	private Cliente idCliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValor1() {
		return valor1;
	}

	public void setValor1(Double valor1) {
		this.valor1 = valor1;
	}

	public Double getValor2() {
		return valor2;
	}

	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}

	public Double getValor3() {
		return valor3;
	}

	public void setValor3(Double valor3) {
		this.valor3 = valor3;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Vendas [id=" + id + ", valor1=" + valor1 + ", valor2=" + valor2 + ", valor3=" + valor3 + ", idCliente="
				+ idCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((valor1 == null) ? 0 : valor1.hashCode());
		result = prime * result + ((valor2 == null) ? 0 : valor2.hashCode());
		result = prime * result + ((valor3 == null) ? 0 : valor3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendas other = (Vendas) obj;
		if (id != other.id)
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (valor1 == null) {
			if (other.valor1 != null)
				return false;
		} else if (!valor1.equals(other.valor1))
			return false;
		if (valor2 == null) {
			if (other.valor2 != null)
				return false;
		} else if (!valor2.equals(other.valor2))
			return false;
		if (valor3 == null) {
			if (other.valor3 != null)
				return false;
		} else if (!valor3.equals(other.valor3))
			return false;
		return true;
	}

	
	
}
