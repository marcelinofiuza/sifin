package br.com.fti.sifin.modulos.cliente;

import br.com.fti.sifin.util.R42Util;

public class ClienteFilter {

	private String razaoSocial;

	private String fantasia;

	private String unidade;

	private String cnpj;

	private String cpf;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = R42Util.removePontos(cnpj);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = R42Util.removePontos(cpf);
	}

}
