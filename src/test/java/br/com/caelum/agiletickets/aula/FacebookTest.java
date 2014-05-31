package br.com.caelum.agiletickets.aula;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.Submit;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class FacebookTest {
	

	@Test
	public void testName() throws Exception {
		FirefoxDriver browser = new FirefoxDriver();
		browser.get("http://www.facebook.com");
		
		browser.findElement(By.id("email")).sendKeys("abcd@abcd.com.br");
		browser.findElement(By.id("pass")).sendKeys("123");
		browser.findElement(By.id("login_form")).submit();
		
		String mensagem  = browser.findElementByClassName("fsl").getText();
		//System.out.println(mensagem);
		Assert.assertEquals("Incorrect Email", mensagem);
		
		browser.close();
		
	}
}
