package br.com.fti.sifin.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("sifin")
public class SifinApiProperty {

	private Seguranca seguranca = new Seguranca();
	private String origemPermitida = "http://localhost:4200";;

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	// Segurança
	public static class Seguranca {
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

}
