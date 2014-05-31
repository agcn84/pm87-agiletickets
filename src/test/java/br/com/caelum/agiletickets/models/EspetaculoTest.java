package br.com.caelum.agiletickets.models;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Locale;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}
	
	@Test
	public void verificaQuantidadeEspetaculoSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais20Dias = agora.plusDays(20);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMais20Dias.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(3, sessoes.size());
		
		
	}
	
	@Test
	public void verificaQuantidadeEspetaculoDiaria() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais30Dias = agora.plusDays(30);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMais30Dias.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(31, sessoes.size());
		
		
	}
	
	@Test
	public void verificaInicioDeEspetaculoIgualFimEspetaculo() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais20Dias = agora.plusDays(20);
		LocalDate inicio = agoraMais20Dias.toLocalDate();
		LocalDate fim = agoraMais20Dias.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(1, sessoes.size());
		
		
	}
	
	@Test
	public void verificaFimEspetaculoEmUmaDataSemSessao() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais5Dias = agora.plusDays(5);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMais5Dias.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(1, sessoes.size());
		
		
	}
	
	@Test
	public void verificaHorarioEspetaculo() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraPlus1Mes = agora.plusDays(10);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraPlus1Mes.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(agora.toLocalTime().toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR"))), 
				((Sessao)sessoes.get(5)).getHora());
		
		
	}
	
	@Test
	public void verificarDataFimAnteriorInicioEspetaculo() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMenos20Dias = agora.minusDays(20);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMenos20Dias.toLocalDate();
		LocalTime horario = new LocalTime(12);
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(0, sessoes.size());
		
	}
	
	@Test
	public void verificarACriacaoDeSessoes() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais20Dias = agora.plusDays(20);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMais20Dias.toLocalDate();
		LocalTime horario = new LocalTime(12);
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		LocalDate diaSessao = inicio; 
		
		for(int i = 0; i<sessoes.size(); i++){
			Sessao sessao = sessoes.get(i);
			
			Assert.assertEquals(diaSessao.toString(DateTimeFormat.shortDate().withLocale(new Locale("pt", "BR")))
					, sessao.getDia());
			Assert.assertEquals(horario.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")))
					, sessao.getHora());
			diaSessao = diaSessao.plusDays(Periodicidade.SEMANAL.numeroDias());
		}
		Assert.assertEquals(3, sessoes.size());
		
	}
	
	@Test
	public void verificaQuantidadeEspetaculoQuinzena() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais40Dias = agora.plusDays(40);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMais40Dias.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.QUINZENAL);
		
		Assert.assertEquals(3, sessoes.size());
		
		
	}
	
	@Test
	public void verificaQuantidadeEspetaculoMensal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime agora = new DateTime();
		DateTime agoraMais40Dias = agora.plusDays(40);
		LocalDate inicio = agora.toLocalDate();
		LocalDate fim = agoraMais40Dias.toLocalDate();
		LocalTime horario = agora.toLocalTime();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.MENSAL);
		
		Assert.assertEquals(2, sessoes.size()); 
		//Assert.assertEquals(3, sessoes.size());
		
		
	}
	
	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
}
