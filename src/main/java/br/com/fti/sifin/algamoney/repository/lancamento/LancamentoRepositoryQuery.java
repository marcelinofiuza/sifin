package br.com.fti.sifin.algamoney.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fti.sifin.algamoney.model.Lancamento;
import br.com.fti.sifin.algamoney.repository.filter.LancamentoFilter;
import br.com.fti.sifin.algamoney.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
