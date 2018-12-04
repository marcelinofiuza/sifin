package br.com.fti.sifin.repositorio.query;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fti.sifin.entidades.empresa.Cliente;
import br.com.fti.sifin.repositorio.filtro.FiltroCliente;

@Component
public interface ClienteRepositoryQuery {

	public List<Cliente> filtrar(FiltroCliente filtroCliente);
	
}
