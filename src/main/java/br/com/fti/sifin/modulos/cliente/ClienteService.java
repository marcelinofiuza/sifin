package br.com.fti.sifin.modulos.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fti.sifin.entidades.empresa.Cliente;

/*******************************************************************************
 * Classe Serviço Regras de negócio do Cliente Desenvolvido por :
 * 
 * @author Bob-Odin - 08/09/2018
 *******************************************************************************/
@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	
	/****************************************************************************
	 * Retornar uma lista de clientes filtrando filtroCliente
	 ****************************************************************************/	
	public List<Cliente> Listar(ClienteFilter filtroCliente) {
		return clienteRepository.filtrar(filtroCliente);
	}
	
}
