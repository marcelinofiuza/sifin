package br.com.fti.sifin.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fti.sifin.algamoney.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
