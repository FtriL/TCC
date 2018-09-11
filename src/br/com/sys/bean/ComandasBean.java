package br.com.sys.bean;

public class ComandasBean {
	private int idComanda;
	private int idMesa;
	private int idProduto;
	private int quantidadeComanda;
	private double valorUnidadeComanda;
	private double valorTotalComanda;
	private String emitidaComanda;
	public String getEmitidaComanda() {
		return emitidaComanda;
	}
	public void setEmitidaComanda(String emitidaComanda) {
		this.emitidaComanda = emitidaComanda;
	}
	public int getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidadeComanda() {
		return quantidadeComanda;
	}
	public void setQuantidadeComanda(int quantidadeComanda) {
		this.quantidadeComanda = quantidadeComanda;
	}
	public double getValorUnidadeComanda() {
		return valorUnidadeComanda;
	}
	public void setValorUnidadeComanda(double valorUnidadeComanda) {
		this.valorUnidadeComanda = valorUnidadeComanda;
	}
	public double getValorTotalComanda() {
		return valorTotalComanda;
	}
	public void setValorTotalComanda(double valorTotalComanda) {
		this.valorTotalComanda = valorTotalComanda;
	}
	
}
