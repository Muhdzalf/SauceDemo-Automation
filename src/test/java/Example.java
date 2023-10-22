import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    @Test
    public void login_valid_credentials(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup(); // for setup chrome as test browser

        driver = new ChromeDriver(); // set driver variable as chromeDriver class/object

        driver.manage().window().maximize(); // max windows size
        driver.get(baseUrl); // open test browser
        driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        String appTitle = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        
//        driver.close();
    }
}
