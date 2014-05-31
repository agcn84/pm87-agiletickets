package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

import org.joda.time.DateTime;

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
	},
	QUINZENAL {
		@Override
		public int numeroDias() {
			return 14;
		}
	},
	MENSAL {
		@Override
		public int numeroDias() {
			int numeroDiasMes = new DateTime().getDayOfMonth();
			return numeroDiasMes;
		}
	};

	public abstract int numeroDias();

}
