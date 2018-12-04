package br.com.fti.sifin.recurso;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fti.sifin.entidades.global.Usuario;
import br.com.fti.sifin.eventos.RecursoCriadoEvent;
import br.com.fti.sifin.servicos.ServicoUsuario;

@RestController
@RequestMapping("usuario")
public class RecursoUsuario {

	
	/****************************************************************************
	 * Classes e Variaveis
	 ****************************************************************************/		
	@Autowired
	ServicoUsuario servicoUsuario;
	
	@Autowired
	private ApplicationEventPublisher publisher;	
		
	/****************************************************************************
	 * Listar dados
	 ****************************************************************************/	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LER_USUARIO')")
	public List<Usuario> listar() {
		return servicoUsuario.listar();
	}
		
	/****************************************************************************
	 * Buscar pelo codigo
	 ****************************************************************************/		
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_LER_USUARIO')")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id){
		Usuario usuario = servicoUsuario.buscar(id);
		return ResponseEntity.ok(usuario);		
	}
	
	/****************************************************************************
	 * Criar novo registro
	 ****************************************************************************/		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_SALVAR_USUARIO')")
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response){		
		Usuario usuarioSalvo = servicoUsuario.salvar(usuario);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getIdUsuario().toString()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	/****************************************************************************
	 * Alterar Registro
	 ****************************************************************************/
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SALVAR_USUARIO')")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario){		
		Usuario usuarioExistente = servicoUsuario.buscar(id);
	    BeanUtils.copyProperties(usuario, usuarioExistente, "idUsuario", "credencial");
	    servicoUsuario.salvar(usuarioExistente);
		return ResponseEntity.ok(usuarioExistente);		
	}		
	
	/****************************************************************************
	 * Excluir registro
	 ****************************************************************************/		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_EXCLUIR_USUARIO')")
	public void remover(@PathVariable Long id) {
		servicoUsuario.excluir(id);
	}		
	
}
