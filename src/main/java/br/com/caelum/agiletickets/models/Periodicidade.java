package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum Periodicidade {

	DIARIA {
		@Override
		public int numeroDias() {
			return 1;
		}
	},
	SEMANAL {
		@Override
		public int numeroDias() {
			return 7;
		}
	};

	public abstract int numeroDias();

}
