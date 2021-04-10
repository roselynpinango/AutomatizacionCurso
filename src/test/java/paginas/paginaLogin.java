package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaLogin {
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnSignIn;
	
	public paginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void llenarFormulario(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
	}
	
	public void clicEnSignIn() {
		btnSignIn.click();
	}
}
