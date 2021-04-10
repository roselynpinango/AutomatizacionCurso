package Edit.EducacionIt;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {	
	@Test
	public void lab1_E1() {
		// 1. Indicar dónde está el ChromeDriver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		
		// 2. Instanciar el Driver segun el navegador a utilizar
		WebDriver driver = new ChromeDriver();
		
		// 3. Abrir el navegador en la pagina de Selenium
		driver.get("https://www.selenium.dev");
		
		// 4. Cerrar el navegador
		driver.close();
	}
	
	@Test
	public void lab1_E2() {
		// 1. Indicar dónde está el GeckoDriver
		System.setProperty("webdriver.gecko.driver", "..\\EducacionIt\\Drivers\\geckodriver.exe");
		
		// 2. Instanciar el Driver segun el navegador a utilizar
		WebDriver driver = new FirefoxDriver();
		
		// 3. Abrir el navegador en la pagina de Selenium
		driver.get("https://www.selenium.dev");
		
		// 4. Maximizar la ventana
		driver.manage().window().maximize();
		
		// 5. Cerrar el navegador
		driver.close();
	}
	
	@Test
	public void lab1_E3() {
		// 1. Indicar dónde está el ChromeDriver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		
		// 2. Instanciar el Driver segun el navegador a utilizar
		WebDriver driver = new ChromeDriver();
		
		// 3. Abrir el navegador en la pagina de Selenium
		driver.get("https://www.selenium.dev");
		
		// 4. Identificar el campo de texto y enviarle un valor
		WebElement txtSearch = driver.findElement(By.id("gsc-i-id1"));
		txtSearch.sendKeys("python");
		
		// 5. Simular el presionar la tecla ENTER
		txtSearch.sendKeys(Keys.ENTER);
		
		// 6. Cerrar el navegador
		driver.close();
	}
}
