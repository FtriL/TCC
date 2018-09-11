package br.com.sys.bean;

public class MesasBean {

	private int idMesa;
	private String usoMesa;
	private int idCliente;
	private String comandaPendente;
	private double valorMesa;
	public double getValorMesa() {
		return valorMesa;
	}
	public void setValorMesa(double valorMesa) {
		this.valorMesa = valorMesa;
	}

	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public String getUsoMesa() {
		return usoMesa;
	}
	public void setUsoMesa(String usoMesa) {
		this.usoMesa = usoMesa;
	}
	public String getComandaPendente() {
		return comandaPendente;
	}
	public void setComandaPendente(String comandaPendente) {
		this.comandaPendente = comandaPendente;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	

}
