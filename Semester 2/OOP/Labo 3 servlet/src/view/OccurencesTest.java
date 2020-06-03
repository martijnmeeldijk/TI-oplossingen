package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OccurencesTest {
	
	// verander de url naar jouw url naam
	private static final String url = "http://localhost:8080/";
	private WebDriver driver;
	
	@Before
	public void setUp () {
//		 Voor Windows (vergeet "\" niet te escapen met een tweede "\")
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
//		 Voor mac: 
		 System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void test_Count_papa_a_geeft_2 () {
		driver.get(url+"Occurences?woord=papa&letter=a");
		String antwoord = driver.findElement(By.id("antwoord")).getText();
		assertEquals("Het antwoord is: 2 keer.", antwoord);
	}
	
	@Test
	public void test_Count_tennis_s_geeft_1 () {
		driver.get(url+"Occurences?woord=tennis&letter=s");
		String antwoord = driver.findElement(By.id("antwoord")).getText();
		assertEquals("Het antwoord is: 1 keer.", antwoord);
	}

	@Test
	public void test_Count_mama_p_geeft_0 () {
		driver.get(url+"Occurences?woord=mama&letter=p");
		String antwoord = driver.findElement(By.id("antwoord")).getText();
		assertEquals("Het antwoord is: 0 keer.", antwoord);
	}
	
	@Test
	public void test_Count_Acradabra_a_geeft_4 () {
		driver.get(url+"Occurences?woord=Acradabra&letter=a");
		String antwoord = driver.findElement(By.id("antwoord")).getText();
		assertEquals("Het antwoord is: 3 keer.", antwoord);
	}

	@After
	public void tearDown () {
		driver.quit();
	}

}
