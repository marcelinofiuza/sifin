package br.com.fti.sifin.restconverter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.fti.sifin.enums.Role;

@Component
public class ConverterRole implements Converter<String, Role> {

	@Override
	public Role convert(String source) {		
		return Role.class.getEnumConstants()[Integer.valueOf(source)];
	}

}
