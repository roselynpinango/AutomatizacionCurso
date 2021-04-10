package pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio3 {
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
		driver.get("http://automationpractice.com/index.php?controller=authentication#account-creation");
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void registroUsuario() throws IOException {
		/*Ingresar correo */
		WebElement email = driver.findElement(By.id("email_create"));
		email.sendKeys("correo27320@prueba.com");
		
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\01_ingreso_del_correo.png"));
		
		/*Enviar correo */
		WebElement btnCreateAnAccount = driver.findElement(By.id("SubmitCreate"));
		btnCreateAnAccount.click();
		
		/*WebElement titulo = driver.findElement(By.xpath("//h1[contains(text(),'Authentication')]"));
		
		Assert.assertNotEquals(titulo.getText(), "AUTHENTICATION");*/
		
		/*Formulario*/	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
		
		WebElement radio2 = driver.findElement(By.id("id_gender2"));
		radio2.click(); 
		
		WebElement Firstname = driver.findElement(By.cssSelector("#customer_firstname"));
		Firstname.sendKeys("Andreina");
		
		WebElement Lastname = driver.findElement(By.cssSelector("#customer_lastname"));
		Lastname.sendKeys("Castro");
			
		WebElement Password = driver.findElement(By.id("passwd"));
		Password.sendKeys("123456");
		
		Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		day.selectByValue("18");
		
		Select months 	= new Select (driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByValue("6");
		
		Select years = new Select (driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByValue("1990");
		
			
		WebElement check1 = driver.findElement(By.cssSelector("#newsletter"));
		check1.click();
		
		WebElement check2 = driver.findElement(By.cssSelector("#optin"));
		check2.click();
				
		WebElement Company = driver.findElement(By.cssSelector("#company"));
		Company.sendKeys("Movistar");
		
		WebElement Adrees1 = driver.findElement(By.xpath("//input[@id='address1']"));
		Adrees1.sendKeys("Avenida Paseo Colón");
		
		WebElement Adrees2 = driver.findElement(By.xpath("//input[@id='address2']"));
		Adrees2.sendKeys("3467, Piso 10 - B");
		
		WebElement City = driver.findElement(By.cssSelector("#city"));
		City.sendKeys("Miami");
		
		
		Select state = new Select (driver.findElement(By.cssSelector("#id_state")));
		state.selectByValue("10");
		
		WebElement Postcode = driver.findElement(By.id("postcode"));
		Postcode.sendKeys("33215");
		
		Select country = new Select (driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByValue("21");
		
		WebElement TextOther = driver.findElement(By.id("other"));
		TextOther.sendKeys("Esto es una prueba automatizada");
		 
		WebElement PhoneHaouse = driver.findElement(By.id("phone"));
		PhoneHaouse.sendKeys("(001)-123-45678");
		
		WebElement Mobile = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
		Mobile.sendKeys("(001)-789-45678");

		WebElement AdressAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		AdressAlias.clear();
			
		AdressAlias.sendKeys("Trabajo");
		
		screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\02_formulario_lleno.png"));
		
		WebElement btnSubmitAccount = driver.findElement(By.cssSelector("#submitAccount"));
		btnSubmitAccount.click();
		
		screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\03_resultado_del_registro.png"));

		String resultadoEsperado = "http://automationpractice.com/index.php?controller=my-account";
		String resultadoObtenido = driver.getCurrentUrl();
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
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
