package br.com.fti.sifin.enums;

/****************************************************************************
 * Enum Natureza de Roles de Perfil
 * 
 * @author Bob-Odin - 31/01/2017
 ****************************************************************************/
public enum Role {
	
	ADMIN("Administrador"),
	USUARIO("Usuario");
	
	private String descricao;

	private Role(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}	
}
