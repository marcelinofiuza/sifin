package br.com.fti.sifin.modulos.cliente;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fti.sifin.entidades.empresa.Cliente;

@Component
public interface ClienteRepositoryQuery {

	public List<Cliente> filtrar(ClienteFilter filtroCliente);
	
}
