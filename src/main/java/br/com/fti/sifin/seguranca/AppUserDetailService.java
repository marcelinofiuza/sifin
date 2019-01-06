package br.com.fti.sifin.seguranca;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fti.sifin.entidades.global.Usuario;
import br.com.fti.sifin.modulos.usuario.RepUsuario;

@Service
public class AppUserDetailService implements UserDetailsService {

	@Autowired
	RepUsuario repUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {		
		
		Optional<Usuario> usuarioOptional = repUsuario.findByCredencial(email);		
		
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha incorretos"));		
		
		return new UsuarioSistema(usuario); 
		
	}

}
