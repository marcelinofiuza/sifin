package br.com.fti.sifin.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fti.sifin.algamoney.model.Lancamento;
import br.com.fti.sifin.algamoney.repository.lancamento.LancamentoRepositoryQuery;


public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
