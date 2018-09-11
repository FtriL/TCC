package br.com.sys.bean;

public class PedidosBean {
	private int idPedido;
	private double valorPedido;
	private int idCondicao;
	private int idGarcom;
	private String data;
	private String hora;
	private int fechadoPedido;

	public int getFechadoPedido() {
		return fechadoPedido;
	}
	public void setFechadoPedido(int fechadoPedido) {
		this.fechadoPedido = fechadoPedido;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public int getIdCondicao() {
		return idCondicao;
	}
	public void setIdCondicao(int idCondicao) {
		this.idCondicao = idCondicao;
	}
	public int getIdGarcom() {
		return idGarcom;
	}
	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	

}
