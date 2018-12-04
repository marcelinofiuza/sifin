package br.com.fti.sifin.servicos;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.fti.sifin.entidades.global.Usuario;
import br.com.fti.sifin.repositorio.global.RepUsuario;

/*******************************************************************************
 * Classe Serviço Regras de negócio da Empresa Desenvolvido por :
 * 
 * @author Bob-Odin - 23/05/2018
 *******************************************************************************/
@Service
public class ServicoUsuario {

	@Autowired
	RepUsuario repUsuario;

	/****************************************************************************
	 * Listar todos os registros
	 ****************************************************************************/
	public List<Usuario> listar() {
		return repUsuario.findAll();
	}

	/****************************************************************************
	 * Buscar pelo ID
	 ****************************************************************************/
	public Usuario buscar(Long idUsuario) {
		Optional<Usuario> usuario = repUsuario.findById(idUsuario);		
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}

	public Usuario buscar(String credencial) {
		Optional<Usuario> usuario = repUsuario.findByCredencial(credencial);		
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}
	/****************************************************************************
	 * Validar e salvar
	 ****************************************************************************/	
	public Usuario salvar(@Valid Usuario usuario) {
		return repUsuario.save(usuario);			
	}

	/****************************************************************************
	 * Validar e excluir
	 ****************************************************************************/	
	public void excluir(Long idUsuario) {
		repUsuario.deleteById(idUsuario);;		
	}


}
