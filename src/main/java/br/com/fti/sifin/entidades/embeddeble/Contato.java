package br.com.fti.sifin.entidades.embeddeble;

import javax.persistence.Column;
import javax.persistence.Embeddable;



/****************************************************************************
 * Entidade Contato @Embeddable de cadastros diversos Desenvolvido por :
 * 
 * @author Bob-Odin - 01/02/2017
 ****************************************************************************/
@Embeddable
public class Contato {

	@Column(length = 50)
	private String nomeContato;

	@Column(length = 100)
	private String email;

	@Column(length = 15)
	private String telefone;

	@Column(length = 5)
	private String ramal;

	@Column(length = 15)
	private String celular;

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
