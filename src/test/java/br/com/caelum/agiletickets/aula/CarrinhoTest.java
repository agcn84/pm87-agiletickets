package br.com.caelum.agiletickets.aula;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CarrinhoTest {

	@Test
	public void verificaMaiorValorComUmProduto() {

		Produto produto = new Produto(20.0);

		Carrinho carrinho = new Carrinho(produto);

		double maiorValor = carrinho.getMaiorValor();

		Assert.assertEquals(20.0, maiorValor, 0.001);

	}
	
	@Test
	public void verificaMaiorValorComVariosProdutos() throws Exception {
		Produto bola = new Produto(10.0);
		Produto boneca = new Produto(30.0);
		
		Carrinho carrinho = new Carrinho(bola);
		carrinho.adiciona(boneca);
		
		double maiorValor = carrinho.getMaiorValor();
		
		Assert.assertEquals(30.0, maiorValor, 0.001);
	}
	
	

}
