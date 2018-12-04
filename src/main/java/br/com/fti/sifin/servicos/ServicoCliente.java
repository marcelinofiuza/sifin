package br.com.fti.sifin.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fti.sifin.entidades.empresa.Cliente;
import br.com.fti.sifin.repositorio.empresa.ClienteRepository;
import br.com.fti.sifin.repositorio.filtro.FiltroCliente;

/*******************************************************************************
 * Classe Serviço Regras de negócio do Cliente Desenvolvido por :
 * 
 * @author Bob-Odin - 08/09/2018
 *******************************************************************************/
@Service
public class ServicoCliente {

	@Autowired
	ClienteRepository clienteRepository;
	
	
	/****************************************************************************
	 * Retornar uma lista de clientes filtrando filtroCliente
	 ****************************************************************************/	
	public List<Cliente> Listar(FiltroCliente filtroCliente) {
		return clienteRepository.filtrar(filtroCliente);
	}
	
}
