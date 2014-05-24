package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
				return sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			} else {
				return sessao.getPreco();
			}
		}
	}, SHOW {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
				return sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			} else {
				return sessao.getPreco();
			}
		}
	}, TEATRO {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			return sessao.getPreco();
		}
	}, BALLET {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			BigDecimal preco;
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
			return preco;
		}
	}, ORQUESTRA {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			BigDecimal preco;
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
			return preco;
		}
	};
	
	public abstract BigDecimal calcula(Sessao sessao);
	
}
