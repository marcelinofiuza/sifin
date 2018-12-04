package br.com.fti.sifin.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("sifin")
public class SifinApiProperty {

	private final Seguranca seguranca = new Seguranca();
	private final OrigemPermitida origemPermitida = new OrigemPermitida();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public OrigemPermitida getOrigemPermitida() {
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

	// Origem de acesso
	public static class OrigemPermitida {
		private String endereco;

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

	}

}
