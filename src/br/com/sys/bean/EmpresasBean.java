package br.com.sys.bean;

public class empresasBean {
	private int idEmpresa;
	private String nomeEmpresa;
	private String cnpj;
	private int idEndereco;
	private int numMesas;
	private int numFuncionarios;
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public int getNumMesas() {
		return numMesas;
	}
	public void setNumMesas(int numMesas) {
		this.numMesas = numMesas;
	}
	public int getNumFuncionarios() {
		return numFuncionarios;
	}
	public void setNumFuncionarios(int numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}
	public int getNumFornecedores() {
		return numFornecedores;
	}
	public void setNumFornecedores(int numFornecedores) {
		this.numFornecedores = numFornecedores;
	}
	private int numFornecedores;
	

}
