package br.com.fti.sifin.entidades.global;

import br.com.fti.sifin.entidades.embeddeble.Contato;
import br.com.fti.sifin.entidades.embeddeble.Endereco;
import br.com.fti.sifin.enums.RamoAtividade;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresa.class)
public abstract class Empresa_ {

	public static volatile SingularAttribute<Empresa, String> cnae;
	public static volatile SingularAttribute<Empresa, Endereco> endereco;
	public static volatile SingularAttribute<Empresa, String> insEstadual;
	public static volatile SingularAttribute<Empresa, String> cnpj;
	public static volatile SingularAttribute<Empresa, LocalDate> dataAbertura;
	public static volatile SingularAttribute<Empresa, String> fantasia;
	public static volatile SingularAttribute<Empresa, String> naturezaJuridica;
	public static volatile SingularAttribute<Empresa, String> cpf;
	public static volatile SingularAttribute<Empresa, String> insMunicipal;
	public static volatile SingularAttribute<Empresa, Long> idEmpresa;
	public static volatile SingularAttribute<Empresa, String> razaoSocial;
	public static volatile SingularAttribute<Empresa, Contato> contato;
	public static volatile SingularAttribute<Empresa, RamoAtividade> ramoAtividade;

}

