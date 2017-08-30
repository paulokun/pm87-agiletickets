package br.com.caelum.agiletickets.acceptance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EspetaculoTest {
	private static WebDriver browser;
	
	// @Before // executa antes do inicio do teste
	@BeforeClass // executa uma vez so no inicio de tudo
	public static void antesDoTeste() {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		browser = new FirefoxDriver();
	}
	
	// @After // executa depois do fim do teste
	@AfterClass // executa uma vez so no fim de tudo
	public static void depoisDoTeste() {
		browser.close();
	}
	
	
	
}
