package br.com.fti.sifin.entidades.empresa;

import br.com.fti.sifin.entidades.embeddeble.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ extends br.com.fti.sifin.tenancy.ZEmpresa_ {

	public static volatile SingularAttribute<Cliente, String> fantasia;
	public static volatile SingularAttribute<Cliente, Long> idCliente;
	public static volatile SingularAttribute<Cliente, Endereco> endereco;
	public static volatile ListAttribute<Cliente, ClienteContatos> contatos;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, Conta> conta;
	public static volatile SingularAttribute<Cliente, String> insMunicipal;
	public static volatile SingularAttribute<Cliente, String> insEstadual;
	public static volatile SingularAttribute<Cliente, String> unidade;
	public static volatile SingularAttribute<Cliente, String> cnpj;
	public static volatile SingularAttribute<Cliente, String> razaoSocial;

}

