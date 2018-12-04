package br.com.fti.sifin.entidades.global;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.fti.sifin.entidades.embeddeble.Contato;
import br.com.fti.sifin.entidades.embeddeble.Endereco;
import br.com.fti.sifin.enums.RamoAtividade;
import br.com.fti.sifin.util.R42Util;


/****************************************************************************
 * Entidade Empresa Desenvolvido por :
 * 
 * @author Bob-Odin - 01/02/2017 /
 ****************************************************************************/
@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;

	@NotNull
	@Column(length = 80, nullable = false)
	private String razaoSocial;

	@NotNull
	@Column(length = 40, nullable = false)
	private String fantasia;

	@CNPJ
	@Column(length = 18, nullable = true)
	private String cnpj;

	@CPF
	@Column(length = 14, nullable = true)
	private String cpf;

	@Column(length = 15)
	private String insEstadual;

	@Column(length = 15)
	private String insMunicipal;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private RamoAtividade ramoAtividade;

	@Column(length = 9)
	private String cnae;

	@Column(length = 5)
	private String naturezaJuridica;

	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	private LocalDate dataAbertura;

	@Embedded
	private Endereco endereco = new Endereco();

	@Embedded
	private Contato contato = new Contato();

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

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

	public String getCnpj() {
		return cnpj;
	}

	public String getCnpjComPonto() {
		return R42Util.pontosCnpj(cnpj);
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = R42Util.removePontos(cnpj);
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getCpfComPonto() {
		return R42Util.pontosCpf(cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = R42Util.removePontos(cpf);
	}

	public String getInsEstadual() {
		return insEstadual;
	}

	public void setInsEstadual(String insEstadual) {
		this.insEstadual = insEstadual;
	}

	public String getInsMunicipal() {
		return insMunicipal;
	}

	public void setInsMunicipal(String insMunicipal) {
		this.insMunicipal = insMunicipal;
	}

	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Empresa))
			return false;
		Empresa other = (Empresa) obj;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		return true;
	}

}
