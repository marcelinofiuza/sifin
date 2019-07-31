package br.com.fti.sifin.seguranca;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import br.com.fti.sifin.modulos.usuario.UsuarioService;

public class CustonTokenEnhancer  implements TokenEnhancer {

	@Autowired
	UsuarioService servicoUsuario;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UsuarioSistema usuarioSistema;
			
		try {
			
			usuarioSistema = (UsuarioSistema) authentication.getPrincipal();
			Map<String, Object> addInfo = new HashMap<>();
			addInfo.put("nome", usuarioSistema.getUsuario().getNome());
			((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(addInfo);
			
		} catch (Exception e) {
			
		}
		

		return accessToken;
	}
}
