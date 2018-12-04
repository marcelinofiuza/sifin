package br.com.fti.sifin.enums;

import java.io.Serializable;

/****************************************************************************
 * Classe controle para resgates de enums
 * 
 * @author: Bob-Odin - 22/03/2017
 ****************************************************************************/

public class ControleEnums implements Serializable {

	private static final long serialVersionUID = 1L;

	/****************************************************************************
	 * -- Lista de opções de enums
	 ****************************************************************************/

	public Febraban[] getFebraban() {
		return Febraban.values();
	}

	public Estado[] getEstados() {
		return Estado.values();
	}

	public AnaliticaSintetica[] getTiposConta() {
		return AnaliticaSintetica.values();
	}

	public AtivaItativa[] getStatusConta() {
		return AtivaItativa.values();
	}

	public Natureza[] getNaturezas() {
		return Natureza.values();
	}

	public RamoAtividade[] getRamosAtividade() {
		return RamoAtividade.values();
	}

	public DebitoCredito[] getDebitoCredito() {
		return DebitoCredito.values();
	}

	public OrigemLcto[] getOrigemLcto() {
		return OrigemLcto.values();
	}

	public DiasMes[] getDiasMes() {
		return DiasMes.values();
	}

	public LayoutCnab[] getLayoutCnab() {
		return LayoutCnab.values();
	}

	public StatusRetorno[] getStatusRetorno() {
		return StatusRetorno.values();
	}
}
