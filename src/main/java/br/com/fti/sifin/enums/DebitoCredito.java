package br.com.fti.sifin.enums;

/****************************************************************************
 * Enum DébitoCrédito
 * 
 * @author Bob-Odin - 22/03/2017
 ****************************************************************************/
public enum DebitoCredito {
	
	DEBITO("Pagamento",-1.0),	
	CREDITO("Recebimento",1.0);

	private String descricao;
	private Double multiplicador;

	DebitoCredito(String descricao, Double multiplicador) {
		this.descricao = descricao;
		this.multiplicador = multiplicador;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public Double getMultiplicador(){		
		return multiplicador;
	}
	
}
