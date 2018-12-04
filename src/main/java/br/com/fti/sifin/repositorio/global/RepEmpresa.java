package br.com.fti.sifin.repositorio.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fti.sifin.entidades.global.Empresa;

/****************************************************************************
 * Classe Repositório da entidade Empresa Desenvolvido por :
 * 
 * @author Bob-Odin - 01/02/2017
 ****************************************************************************/
@Repository
public interface RepEmpresa extends JpaRepository<Empresa, Long> {


}
