package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaInicio {	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	public paginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clicEnSignIn() {
		lnkSignIn.click();
	}
}
