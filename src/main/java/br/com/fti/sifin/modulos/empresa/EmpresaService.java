package br.com.fti.sifin.modulos.empresa;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.fti.sifin.entidades.global.Empresa;

/*******************************************************************************
 * Classe Serviço Regras de negócio da Empresa Desenvolvido por :
 * 
 * @author Bob-Odin - 01/02/2017
 *******************************************************************************/
@Service
public class EmpresaService {

	/****************************************************************************
	 * Variaveis e Dependências
	 ****************************************************************************/
	@Autowired
	EmpresaRepository repEmpresa;

	/****************************************************************************
	 * Validar e salvar
	 ****************************************************************************/
	public Empresa salvar(@Valid Empresa Empresa) {
		return repEmpresa.save(Empresa);
	}

	/****************************************************************************
	 * Validar e excluir
	 ****************************************************************************/
	public void excluir(Empresa Empresa) {
		repEmpresa.delete(Empresa);
	}

	/****************************************************************************
	 * Validar e excluir
	 ****************************************************************************/
	public void excluir(Long id) {
		repEmpresa.deleteById(id);
	}
	
	/****************************************************************************
	 * Buscar pelo ID
	 ****************************************************************************/
	public Empresa buscar(Long idEmpresa) {
		Optional<Empresa> empresa = repEmpresa.findById(idEmpresa);
		if (empresa.isPresent()) {
			return empresa.get();
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}

	/****************************************************************************
	 * Listar todos os registros
	 ****************************************************************************/
	public List<Empresa> listar() {
		return repEmpresa.findAll();
	}

}
