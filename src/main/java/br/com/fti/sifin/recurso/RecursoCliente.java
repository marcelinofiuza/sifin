package br.com.fti.sifin.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fti.sifin.entidades.empresa.Cliente;
import br.com.fti.sifin.repositorio.filtro.FiltroCliente;
import br.com.fti.sifin.servicos.ServicoCliente;

@RestController
@RequestMapping("cliente")
public class RecursoCliente {
	
	/****************************************************************************
	 * Classes e Variaveis
	 ****************************************************************************/	
	@Autowired
	private ServicoCliente servicoCliente;
	
	
	/****************************************************************************
	 * Listar dados
	 ****************************************************************************/	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE'")
	public List<Cliente> listar() {
		FiltroCliente filtroCliente = new FiltroCliente();
		return servicoCliente.Listar(filtroCliente);
	}
	
}
