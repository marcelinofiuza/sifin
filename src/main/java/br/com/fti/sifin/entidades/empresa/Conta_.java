package br.com.fti.sifin.entidades.empresa;

import br.com.fti.sifin.enums.AnaliticaSintetica;
import br.com.fti.sifin.enums.AtivaItativa;
import br.com.fti.sifin.enums.Natureza;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ extends br.com.fti.sifin.tenancy.ZEmpresa_ {

	public static volatile ListAttribute<Conta, Conta> subConta;
	public static volatile SingularAttribute<Conta, Long> idConta;
	public static volatile SingularAttribute<Conta, Conta> contaPai;
	public static volatile SingularAttribute<Conta, Integer> chave;
	public static volatile SingularAttribute<Conta, String> reduzida;
	public static volatile SingularAttribute<Conta, Natureza> natureza;
	public static volatile SingularAttribute<Conta, AnaliticaSintetica> tipoConta;
	public static volatile SingularAttribute<Conta, String> descricao;
	public static volatile SingularAttribute<Conta, AtivaItativa> status;

}

