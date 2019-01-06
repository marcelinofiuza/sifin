package br.com.fti.sifin.modulos.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fti.sifin.entidades.empresa.Cliente;

@RestController
@RequestMapping("cliente")
public class ClienteResouce {
	
	/****************************************************************************
	 * Classes e Variaveis
	 ****************************************************************************/	
	@Autowired
	private ClienteService servicoCliente;
	
	
	/****************************************************************************
	 * Listar dados
	 ****************************************************************************/	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE'")
	public List<Cliente> listar() {
		ClienteFilter filtroCliente = new ClienteFilter();
		return servicoCliente.Listar(filtroCliente);
	}
	
}
