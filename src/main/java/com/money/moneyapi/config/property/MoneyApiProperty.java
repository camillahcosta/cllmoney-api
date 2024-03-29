package com.money.moneyapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("money")
public class MoneyApiProperty {
	
	private final Seguranca seguranca = new Seguranca();
	
	private String originPermitida = "http://localhost:8000";
	
	public Seguranca getSeguranca() {
		return seguranca;
	}
	
	
	public String getOriginPermitida() {
		return originPermitida;
	}


	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}


	public class Seguranca{
			
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
	}
	

}
