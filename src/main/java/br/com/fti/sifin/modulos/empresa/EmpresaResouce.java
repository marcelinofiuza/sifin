package br.com.fti.sifin.modulos.empresa;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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

import br.com.fti.sifin.configuration.SifinApiProperty;
import br.com.fti.sifin.entidades.global.Empresa;
import br.com.fti.sifin.eventos.RecursoCriadoEvent;

@RestController
@RequestMapping("empresa")
public class EmpresaResouce {

	/****************************************************************************
	 * Classes e Variaveis
	 ****************************************************************************/	
	@Autowired
	private EmpresaService servicoEmpresa;
	@Autowired
	private ApplicationEventPublisher publisher;
	@Autowired
	private SifinApiProperty sifinApiProperty;
	
	
	/****************************************************************************
	 * Listar dados
	 ****************************************************************************/	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LER_EMPRESA')")
	public List<Empresa> listar() {
		return servicoEmpresa.listar();
	}
	
	/****************************************************************************
	 * Buscar pelo código
	 ****************************************************************************/		
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_LER_EMPRESA')")
	public ResponseEntity<Empresa> buscarPeloId(@PathVariable Long id){
		Empresa empresa = servicoEmpresa.buscar(id);
		return ResponseEntity.ok(empresa);		
	}
	
	/****************************************************************************
	 * Criar novo registro
	 ****************************************************************************/		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_SALVAR_EMPRESA')")
	public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa, HttpServletResponse response){		
		Empresa empresaSalva = servicoEmpresa.salvar(empresa);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getIdEmpresa().toString()));
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
	}

	/****************************************************************************
	 * Excluir registro
	 ****************************************************************************/		
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_EXCLUIR_EMPRESA')")
	public void remover(@PathVariable Long id) {
		servicoEmpresa.excluir(id);
	}	

	/****************************************************************************
	 * Alterar Registro
	 ****************************************************************************/
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SALVAR_EMPRESA')")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @Valid @RequestBody Empresa empresa){		
		Empresa empresaExistente = servicoEmpresa.buscar(id);
	    BeanUtils.copyProperties(empresa, empresaExistente, "idEmpresa");
	    servicoEmpresa.salvar(empresaExistente);
		return ResponseEntity.ok(empresaExistente);		
	}	
	
	/****************************************************************************
	 * Setar empresa ativa
	 ****************************************************************************/
	@PostMapping("/setempresa")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void setarEmpresa(@Valid @RequestBody Empresa empresa, HttpServletRequest request, HttpServletResponse response){		
		Cookie cookie = new Cookie("empresaWork", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(sifinApiProperty.getSeguranca().isEnableHttps());
		cookie.setPath(request.getContextPath() + "/setempresa");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		response.setStatus(HttpStatus.NO_CONTENT.value());				
	}	
}
