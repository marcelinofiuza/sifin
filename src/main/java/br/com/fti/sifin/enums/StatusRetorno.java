package br.com.fti.sifin.enums;

/****************************************************************************
 * Enum StatusRetornoBoleto para situação do Boleto
 * 
 * @author Bob-Odin - 12/05/2017
 ****************************************************************************/
public enum StatusRetorno {

	OK("Ok"), 
	ERRO("Erro"), 
	ALERTA("Alerta");

	private String descricao;

	private StatusRetorno(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
