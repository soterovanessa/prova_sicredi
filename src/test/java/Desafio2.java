import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

    public class Desafio2 {

        private String path = "C:\\Users\\Vanessa\\driver\\chromedriver.exe";
        @Test
        public void testInformacoesUsuario() {

            System.setProperty("webdriver.chrome.driver", path);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            //Clicar no select e escolher o Bootstrap V4 Theme
            WebElement selectElement = driver.findElement(By.id("switch-version-select"));
            Select selectObject = new Select(selectElement);
            selectObject.selectByValue("/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


            driver.findElement(By.linkText("Add Record")).click();
            driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
            driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
            driver.findElement(By.id("field-contactFirstName")).sendKeys("Vanessa");
            driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
            driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
            driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
            driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
            driver.findElement(By.id("field-state")).sendKeys("RS");
            driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
            driver.findElement(By.id("field-country")).sendKeys("Brasil");
            driver.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys("Fixter,1");
            driver.findElement(By.id("field-creditLimit")).sendKeys("200");



            driver.findElement(By.id("save-and-go-back-button")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

          //Colocar um refresh
           driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4/success/502");
           //driver.navigate().refresh();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

            //Escrevendo no campo pesquisa "Teste Sicredi"
           driver.findElement(By.xpath("//input[@class='form-control searchable-input floatL']")).sendKeys("Teste Sicredi");

            //Clicando no checkbox
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement check = driver.findElement(By.className("select-row"));
            check.click();

            //Clicando no botão delete do canto superior
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement delete = driver.findElement(By.xpath("//a[@class='btn btn-outline-dark delete-selected-button']"));
            delete.click();

            //Aperece o alerta

            //Validar mensagem do alerta
            WebElement messageAlert = driver.findElement(By.className("alert-delete-multiple-one"));
            String textMessageAlert = messageAlert.getText();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            assertEquals("Are you sure that you want to delete this 1 item?",textMessageAlert);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


            //Clicar no botão delete do alerta
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//button[@class='btn btn-danger delete-multiple-confirmation-button']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Validar mensagem de alerta de confirmação - Não consegui validar

          /*  WebElement alertMessage = driver.findElement(By.className("alert alert-success growl-animated animated bounceInDown"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String alertMessageText = alertMessage.getText();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            assertEquals("Your data has been successfully deleted from the database.",alertMessageText);*/

            driver.quit();
        }
    }