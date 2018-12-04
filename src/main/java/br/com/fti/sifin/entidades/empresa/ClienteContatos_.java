package br.com.fti.sifin.entidades.empresa;

import br.com.fti.sifin.entidades.embeddeble.Contato;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClienteContatos.class)
public abstract class ClienteContatos_ extends br.com.fti.sifin.tenancy.ZEmpresa_ {

	public static volatile SingularAttribute<ClienteContatos, Cliente> cliente;
	public static volatile SingularAttribute<ClienteContatos, Long> idContato;
	public static volatile SingularAttribute<ClienteContatos, Contato> contato;

}

