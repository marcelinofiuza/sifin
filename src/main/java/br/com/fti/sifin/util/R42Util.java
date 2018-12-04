package br.com.fti.sifin.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.fti.sifin.entidades.global.Empresa;
import br.com.fti.sifin.entidades.global.Usuario;
import br.com.fti.sifin.enums.Estado;

public class R42Util {
	
	/****************************************************************************
	 * Retorna a sessão em aberto
	 * 
	 * @return - HttpSession
	 * 
	 ****************************************************************************/
	public static HttpSession getSessao() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}

	/****************************************************************************
	 * Retorna o usuário logado
	 * 
	 * @return - Usuario
	 * 
	 ****************************************************************************/
	public static Usuario resgataUsuario() {
		HttpSession httpSessao = getSessao();
		Usuario usuario = (Usuario) httpSessao.getAttribute("USUARIO");
		return usuario;
	}

	/****************************************************************************
	 * Retorna a empresa ativa
	 * 
	 * @return - Empresa
	 * 
	 ****************************************************************************/
	public static Empresa resgataEmpresa() {
		
		//TODO: Pegar empresa da memória		
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa((long) 1);
		return empresa;
		
	}

	/****************************************************************************
	 * Seta atributo aliatório
	 * 
	 * @param id
	 *            - Nome do parametro
	 * @param valores
	 *            - Map com valores
	 **************************************************************************/
	public static void setAtributo(String id, Map<String, Object> valores) {
		HttpSession httpSessao = getSessao();
		httpSessao.setAttribute(id, valores);		
	}

	/****************************************************************************
	 * Resgata atributo aliatório
	 * 
	 * @param id
	 *          - Nome do parametro a ser resgatado
	 * @return - 
	 * 			- Mapa dos parametros
	 ****************************************************************************/
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getAtributo(String id) {
		HttpSession httpSessao = getSessao();		
		Map<String, Object> valores = (Map<String, Object>) httpSessao.getAttribute(id);
		httpSessao.removeAttribute(id);
		return valores;
	}

	/****************************************************************************
	 * Valida CPF
	 * 
	 * @param cpf
	 *            - Numero do cpf a ser validado
	 * @param ponto
	 *            - true retorna com ponto, false sem ponto
	 * @return - CPF, null se inválido
	 * 
	 ****************************************************************************/
	public static String validaCPF(String numCpf, boolean ponto) {

		String cpf = numCpf.replace('(', ' ').replace(')', ' ').replaceAll("[ ./-]", "").replace("-", "");

		if (cpf.length() == 11) {
			Integer digito1 = calcularDigito(cpf.substring(0, 9), "CPF");
			Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, "CPF");
			if (cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString())) {
				if (ponto) {
					return pontosCpf(cpf);
				} else {
					return cpf;
				}
			}
		}
		return null;
	}

	/****************************************************************************
	 * Valida CNPJ
	 * 
	 * @param cnpj
	 *            - Numero do cnpj a ser validado
	 * @param ponto
	 *            - true retorna com ponto, false sem ponto
	 * @return - CNPJ, null se inválido
	 * 
	 ****************************************************************************/
	public static String validaCNPJ(String numCnpj, boolean ponto) {

		String cnpj = numCnpj.replace('(', ' ').replace(')', ' ').replaceAll("[ ./-]", "").replace("-", "");

		if (cnpj.length() == 14) {
			Integer digito1 = calcularDigito(cnpj.substring(0, 12), "CNPJ");
			Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, "CNPJ");
			if (cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString())) {
				if (ponto) {
					return pontosCnpj(cnpj);
				} else {
					return cnpj;
				}
			}
		}
		return null;
	}

	/****************************************************************************
	 * Calcula Digito modulo 11 para cpf ou cnpj
	 * 
	 * @param numero
	 *            - Numero a ser calculado o digito
	 * @param tipo
	 *            - tipo de calculo (CPF ou CNPJ) - default (CNPJ)
	 * @return - digito calculado
	 * 
	 ****************************************************************************/
	public static int calcularDigito(String numero, String tipo) {
		int[] peso;
		if (tipo.equalsIgnoreCase("CPF")) {
			int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
			peso = pesoCPF;
		} else {
			int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
			peso = pesoCNPJ;
		}

		int soma = 0;
		for (int indice = numero.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(numero.substring(indice, indice + 1));
			soma += digito * peso[peso.length - numero.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	/****************************************************************************
	 * Remove caracteres
	 * 
	 * @param numero
	 *            - Numero do cpf (123.555.896-65) - Numero do cnpj
	 *            (12.225.896/0001-65) - Numero qualquer (4566.11)
	 * @return - sem ponto (12355589665)
	 * 
	 ****************************************************************************/
	public static String removePontos(final String numero) {
		String newNumero = numero.replace('(', ' ').replace(')', ' ').replaceAll("[ ./-]", "").replace("-", "");
		return newNumero;
	}

	/****************************************************************************
	 * Coloca pontos no CPF
	 * 
	 * @param numero
	 *            - Numero do cpf (12355589665)
	 * @return - CPF com ponto (123.555.896-65)
	 * 
	 ****************************************************************************/
	public static String pontosCpf(final String cpf) {

		String newCpf = removePontos(cpf);

		return newCpf.substring(0, 3) + "." + newCpf.substring(3, 6) + "." + newCpf.substring(6, 9) + "-"
				+ newCpf.substring(9, 11);
	}

	/****************************************************************************
	 * Coloca pontos no CNPJ
	 * 
	 * @param numero
	 *            - Numero do cnpj (12225896000165)
	 * @return - CNPJ com ponto (12.225.896/0001-65)
	 * 
	 ****************************************************************************/
	public static String pontosCnpj(final String cnpj) {

		String newCnpj = removePontos(cnpj);

		return newCnpj.substring(0, 2) + "." + newCnpj.substring(2, 5) + "." + newCnpj.substring(5, 8) + "/"
				+ newCnpj.substring(8, 12) + "-" + newCnpj.substring(12, 14);
	}

//	/****************************************************************************
//	 * Retorna o arquivo DbfReader contido no path c:\temp\dbf
//	 * 
//	 * @param arquivo
//	 *            - "arquivo.dbf"
//	 * @return - DbfReader
//	 * 
//	 ****************************************************************************/
//	public static DbfReader lerDbf(String arquivo) throws Exception {
//
//		// String path = "/src/resources/"+arquivo
//		// ClassLoader classLoader = new MigrarConta().getClass().getClassLoader();
//		// File file = new File(classLoader.getResource(path).getFile());
//
//		Long idEmpresa = resgataEmpresa().getIdEmpresa();
//		String id = String.valueOf(idEmpresa);
//
//		URL url = new ControleMigracao().getClass().getClassLoader().getResource("dbf/" + id + "/" + arquivo);
//		File file = new File(url.getFile());
//
//		try {
//			DbfReader dbfReader = new DbfReader(file);
//			return dbfReader;
//		} catch (Exception e) {
//			throw new Exception("Não foi possível abrir o arquivo " + file.getAbsolutePath());
//		}
//	}

	/****************************************************************************
	 * Converte String em Estado
	 ****************************************************************************/
	public static Estado converteEstado(String uf) throws Exception {
		Estado estado = null;
		if (uf != null && !uf.isEmpty()) {
			try {
				estado = Estado.valueOf(uf);
			} catch (Exception e) {
				throw new Exception("Estado não existente!");
			}
		}
		return estado;
	}

	/****************************************************************************
	 * Converte BigDecimal para String formatado
	 * 
	 * @param moeda
	 *            - Exemplo "R$"
	 ****************************************************************************/
	public static String converteValor(String moeda, BigDecimal bigDecimal) {
		String valor;
		DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
		valor = decFormat.format(bigDecimal);

		if (moeda != null) {
			valor = moeda + " " + valor;
		}

		return valor;
	}

}
