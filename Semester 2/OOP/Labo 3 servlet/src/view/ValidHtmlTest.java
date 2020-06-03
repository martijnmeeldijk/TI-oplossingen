package view;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidHtmlTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		// vul hier JOUW pad naar chromedriver in
		// Voor Windows (vergeet "\" niet te escapen met een tweede "\")
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
		// Voor mac: 
		 System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
	}
	
	@After
	public void clean() {
//		driver.quit();
	}

	@Test // Voer deze test uit als je je project opgeladen hebt
	public void isValidHtml() {
		driver.get("https://validator.w3.org/#validate_by_uri+with_options");
		WebElement invulveld = driver.findElement(By.id("uri"));
		// verander naamVanJeEigenSite naar de juiste naam
		invulveld.sendKeys("http://java.cyclone2.khleuven.be:38034/r0298778%5Feigensite/");
		
		Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
		dropdown.selectByValue("HTML5");
		
		WebElement button = driver.findElement(By.cssSelector(".submit_button"));
		button.click();

		WebElement pass = driver.findElement(By.cssSelector("p.success"));
		assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
		
		
		
		
	}
	

}
