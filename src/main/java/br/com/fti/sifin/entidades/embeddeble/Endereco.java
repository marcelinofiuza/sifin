package br.com.fti.sifin.entidades.embeddeble;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import br.com.fti.sifin.enums.Estado;

/****************************************************************************
 * Entidade Endereço @Embeddable para complemento de cadastros diversos
 * 
 * @author Bob-Odin - 01/02/2017 /
 ****************************************************************************/
@Embeddable
public class Endereco {

	@Column(length = 9)
	private String cep;

	@Column(length = 15)
	private String tipoLogradouro;

	@Column(length = 50)
	private String logradouro;

	@Column(length = 10)
	private String numero;

	@Column(length = 20)
	private String complemento;

	@Column(length = 40)
	private String bairro;

	@Column(length = 40)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(length = 2)
	private Estado uf;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	@Transient
	public String getEnderecoCompleto() {
		try {
			return getTipoLogradouro().trim() + " " + 
					getLogradouro().trim() + ", " + 
					getNumero().trim() + ", " + 
					getComplemento().trim();

		} catch (Exception e) {
			return "";
		}
	}
}
