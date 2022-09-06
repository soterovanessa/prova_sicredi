import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


    public class Desafio1 {

        private String path = "C:\\Users\\Vanessa\\driver\\chromedriver.exe";

        @Test
        public void testAdicionarInformacoesUsuario () {
            System.setProperty("webdriver.chrome.driver", path);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

            //Clicar no select e escolher o Bootstrap V4 Theme
            WebElement selectElement = driver.findElement(By.id("switch-version-select"));
            Select selectObject = new Select(selectElement);
            selectObject.selectByValue("/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Clicar no botao 'addRecord'
            driver.findElement(By.linkText("Add Record")).click();


            //Digitar no campo CustomerName o texto 'Teste Sicredi'
            driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");

            //Digitar no campo ContactLastName o texto 'Teste'
            driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");

            //Digitar no campo ContactFirstName o texto 'Vanessa'
            driver.findElement(By.id("field-contactFirstName")).sendKeys("Vanessa");

            //Digitar no campo Fone o texto ' 51 9999-9999'
            driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");

            //Digitar no campo AddressLine1 o texto ' Av Assis Brasil, 3970'
            driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");

            //Digitar no campo AddressLine2 o texto ' Torre D'
            driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");

            //Digitar no campo City o texto 'Porto Alegre'
            driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");

            //Digitar no campo State o texto 'RS'
            driver.findElement(By.id("field-state")).sendKeys("RS");

            //Digitar no campo PostalCode o texto '91000-000'
            driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");

            //Digitar no campo  Country o texto 'Brasil'
            driver.findElement(By.id("field-country")).sendKeys("Brasil");

            //Digitar no campo  SalesRepEmployeeNumber o texto 'Fixter'
            driver.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys("Fixter,1");
            //Obsr: No texto não está aparecendo

            //Digitar no campo  CreditLimit o texto '200'
            driver.findElement(By.id("field-creditLimit")).sendKeys("200");

            //Clicar em Save
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("form-button-save")).click();


            // Validar a mensagem “Your data has been successfully stored into the database. EditCustomeror Go backtolist”
           WebElement elementDiv = driver.findElement(By.id("report-success"));
           WebElement elementP = driver.findElement(By.tagName("p"));
           String textoElementP = elementP.getText();
           assertEquals("Your data has been successfully stored into the database. or", textoElementP);

            driver.quit();

        }
    }

