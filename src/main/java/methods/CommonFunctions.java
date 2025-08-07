package methods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import environment.DriverUtils;

public class CommonFunctions implements BaseTest{
	
	private WebElement element = null ;
	
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public CommonFunctions() {
		driver = DriverUtils.getDefaultDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public void navigateTo(String link) {
		
		driver.get(link);
	}
	
	public void navigateBackAndForward(String direction)
	{
		if (direction.equals("back"))
			driver.navigate().back();
		else
			driver.navigate().forward();
	}
	
	
	public void closeDriver()
	{
		driver.close();
	}
	
	public void clickByElement(WebElement ele)
	{
		element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.click();
	}
	
	public void enterTextByElement(WebElement ele , String enterText)
	{
		element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.sendKeys(enterText);
	}
	
	public String getTextByElement(WebElement ele)
	{
		element = wait.until(ExpectedConditions.visibilityOf(ele));
		return element.getText();
	}
	
	

}
