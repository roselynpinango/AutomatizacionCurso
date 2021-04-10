package pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import paginas.paginaInicio;
import paginas.paginaLogin;

public class Laboratorio3_E2 {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		// 1. Indicar dónde está el ChromeDriver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
						
		// 2. Instanciar el Driver segun el navegador a utilizar
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void irURL() {
		driver.get("http://automationpractice.com");
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() throws IOException {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Lab3_E2_01_paginaInicio.png"));
		
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicEnSignIn();
		
		paginaLogin login = new paginaLogin(driver);
		login.llenarFormulario("correo9999@correo.com", "ABCDqwerty");
		
		screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Lab3_E2_02_llenarFormulario.png"));
		
		login.clicEnSignIn();
		
		screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Lab3_E2_03_resultadoLogin.png"));
	}

	@AfterClass
	public void finPrueba() {
		System.out.println("Fin Prueba");
	}
	
	@AfterTest
	public void cierreNavegador() {
		driver.close();
	}
	
	@AfterSuite
	public void finSuite() {
		System.out.println("Fin Suite");
	}
	
}
