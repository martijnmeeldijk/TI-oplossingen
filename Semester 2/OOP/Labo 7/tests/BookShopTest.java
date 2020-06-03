import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookShopTest {

    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();

    }
    @After
    public void clean() {
       //driver.quit();
    }


    /*@Test
    public void clickSubmit_Gaat_Naar_Overzicht(){

        driver.get("http://localhost:8080/add.jsp");
        WebElement button = driver.findElement(By.id("submit"));
        button.click();

    }*/

    @Test
    public void test_Form() {
        driver.get("http://localhost:8080/bookForm.jsp");

        WebElement titel = driver.findElement(By.id("title"));
        titel.clear();
        titel.sendKeys("Boekje");

        WebElement prijs = driver.findElement(By.id("price"));
        prijs.clear();
        prijs.sendKeys("2");

        WebElement nummer = driver.findElement(By.id("number"));
        nummer.clear();
        nummer.sendKeys("5");

        driver.findElement(By.id("calculate")).click();

        assertEquals("Book", driver.getTitle());

    }

    @Test
    public void test_ding_gaat_naar_form(){
        driver.get("http://localhost:8080/");

        WebElement link = driver.findElement(By.id("form"));
        link.click();

        assertEquals("Book Info", driver.getTitle());
    }

    @Test
    public void lege_form_geeft_error(){
        driver.get("http://localhost:8080/bookForm.jsp");



        driver.findElement(By.id("calculate")).click();

        assertNotEquals("Book", driver.getTitle());
        WebElement paragraph = driver.findElement(By.tagName("p"));

        assertEquals("Vul alle velden in.", paragraph);

    }






    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text)
    {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }


}
