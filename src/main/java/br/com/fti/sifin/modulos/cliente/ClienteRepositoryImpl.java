package br.com.fti.sifin.modulos.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.fti.sifin.entidades.empresa.Cliente;
import br.com.fti.sifin.entidades.empresa.Cliente_;

@Component
public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<Cliente> filtrar(ClienteFilter filtroCliente) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		
		Root<Cliente> root = criteria.from(Cliente.class);
		

		// Criar Restrições
		Predicate[] predicates = criarRestricoes(filtroCliente, builder, root);
		criteria.where(predicates);		
		
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		return query.getResultList();
		
	}


	private Predicate[] criarRestricoes(ClienteFilter filtroCliente, CriteriaBuilder builder, Root<Cliente> root) {
		
		
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filtroCliente.getRazaoSocial())) {
			predicates.add(builder.like(builder.lower(root.get(Cliente_.razaoSocial)),
					"%" + filtroCliente.getRazaoSocial().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filtroCliente.getFantasia())) {
			predicates.add(builder.like(builder.lower(root.get(Cliente_.fantasia)),
					"%" + filtroCliente.getFantasia().toLowerCase() + "%"));
		}		
		
		if (!StringUtils.isEmpty(filtroCliente.getUnidade())) {
			predicates.add(builder.equal(root.get(Cliente_.unidade), filtroCliente.getUnidade()));
		}

		if (!StringUtils.isEmpty(filtroCliente.getCnpj())) {
			predicates.add(builder.equal(root.get(Cliente_.cnpj), filtroCliente.getCnpj()));
		}		

		if (!StringUtils.isEmpty(filtroCliente.getCpf())) {
			predicates.add(builder.equal(root.get(Cliente_.cpf), filtroCliente.getCpf()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);		
		
	}

}
