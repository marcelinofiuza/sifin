package br.com.fti.sifin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import br.com.fti.sifin.restconverter.ConverterRole;

@Configuration
public class ConverterConfiguration extends RepositoryRestConfigurerAdapter {

	@Autowired
	public ConverterRole converterRole;
	
	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
		conversionService.addConverter(converterRole);
		super.configureConversionService(conversionService);
	}
	
}
