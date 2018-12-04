package br.com.fti.sifin.seguranca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.fti.sifin.entidades.global.Permissao;
import br.com.fti.sifin.entidades.global.Usuario;

public class UsuarioSistema implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public UsuarioSistema(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Permissao role : usuario.getPermissoes()) {
			authorities.add(new SimpleGrantedAuthority(role.getDescricao().toUpperCase()));
		}
		return authorities;
	}

	public String getPassword() {
		return usuario.getSenha();
	}

	public String getUsername() {
		return usuario.getCredencial();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return !usuario.isBloqueado();
	}
}
