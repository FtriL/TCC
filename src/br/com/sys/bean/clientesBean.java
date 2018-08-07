package br.com.sys.bean;

public class clientesBean {
	private int idCliente;
	private String nomeCliente;
	private int idEndereco;
	private String telefone;
	private String cpf;
	private int pontuacaoFidelidade;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getPontuacaoFidelidade() {
		return pontuacaoFidelidade;
	}
	public void setPontuacaoFidelidade(int pontuacaoFidelidade) {
		this.pontuacaoFidelidade = pontuacaoFidelidade;
	}

}
