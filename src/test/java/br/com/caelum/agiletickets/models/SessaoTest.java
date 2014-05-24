package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {
	
	Sessao s = new Sessao();
	
	@Before 
	public void	variavelSessao () {
		s= new Sessao();
	}
	

	@Test
	public void deveVender5ingressosSeHa10vagas() throws Exception {
		s.setTotalIngressos(10);
		
		Assert.assertTrue(s.podeReservar(5));sessao
	}

	
	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		s.setTotalIngressos(2);
		Assert.assertFalse(s.podeReservar(3));
	}

	@Test
	public void deveVenderIngressosDoTotalDisponivel (){
		s.setTotalIngressos(2);
		Assert.assertTrue(s.podeReservar(2));
	}
	
}
