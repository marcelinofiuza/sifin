package br.com.fti.sifin.modulos.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fti.sifin.entidades.global.Usuario;

/****************************************************************************
 * Classe Repositório da entidade Usuário Desenvolvido por:
 * 
 * @author Bob-Odin - 30/01/2017
 ****************************************************************************/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/****************************************************************************
	 * Retornar o usuario pela Credencial
	 ****************************************************************************/
	public Optional<Usuario> findByCredencial(String credencial);

	/****************************************************************************
	 * Deleta pela credencial
	 ****************************************************************************/	
	public void deleteByCredencial(String credencial);
	
}
