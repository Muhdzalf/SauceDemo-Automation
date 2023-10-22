package swagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.sql.Time;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User access Swag Labs Login page")
    public void loginWebsite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        String loginTitle = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals("Swag Labs", loginTitle);
    }

    @When("User input valid username")
    public void user_input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input valid password")
    public void user_input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User redirected to Swag Labs home page website")
    public void user_redirected_to_swag_labs_home_page_website() {
        String appTitle = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals("Products", appTitle);
        driver.close();
    }

    @And("User input invalid password")
    public void invalid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce123");
    }

    @Then("User get error message")
    public void get_error_message() {
        String errorMsg = "Epic sadface: Username and password do not match any user in this service";
        String error = driver.findElement(By.xpath("//h3[contains(@data-test, 'error')]")).getText();

        Assert.assertEquals(errorMsg, error);
    }

    @And("User still at login page")
    public void still_at_login_page() {
        String loginTitle = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals("Swag Labs", loginTitle);
        driver.close();
    }

    @Then("User at product page")
    public void userAtProductPage() {
        String appTitle = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals("Products", appTitle);
    }

    @And("User click product")
    public void userClickProduct() {
        driver.findElement(By.xpath("//*[@id='item_0_title_link']")).click();
    }

    @Then("User redirected to product detail page")
    public void userRedirectedToProductDetailPage() {
        String productTitle = "Sauce Labs Bike Light";
        String title = driver.findElement(By.xpath("//div[contains(text(), 'Bike Light')]")).getText();
        Assert.assertEquals(productTitle, title);
    }

    @And("User can see product detail")
    public void userCanSeeProductDetail() {
        String desc = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        String productDesc = driver.findElement(By.xpath("//div[contains(text(), 'A red light')]")).getText();
        Assert.assertEquals(desc, productDesc);
        driver.close();
    }

    @And("User select light bike product")
    public void userSelectLightBikeProduct() {
        String productTitle = "Sauce Labs Bike Light";
        String title = driver.findElement(By.xpath("//div[contains(text(), 'Bike Light')]")).getText();
        Assert.assertEquals(productTitle, title);
    }

    @And("User click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart-sauce-labs-bike-light')]")).click();
    }

    @Then("product added to cart")
    public void productAddedToCart() {
        String vBtn = driver.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-bike-light')]")).getText();
        Assert.assertEquals("Remove", vBtn);
    }

    @And("User can see number icon at card logo")
    public void userCanSeeNumberIconAtCardLogo() {
        String numberCart = driver.findElement(By.xpath("//span[contains(@class, 'shopping_cart_badge')]")).getText();
        Assert.assertEquals("1", numberCart);
        driver.close();
    }

    @And("User click remove button")
    public void userClickRemoveButton() {
        driver.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-bike-light')]")).click();
    }

    @Then("Product removed from cart")
    public void productRemovedFromCart() {
        String numberCart = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).getText();
        Assert.assertEquals("", numberCart);
    }

    @And("Number icon removed from cart")
    public void numberIconRemovedFromCart() {
        String numberCart = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).getText();
        Assert.assertEquals("", numberCart);
        driver.close();
    }

    @Then("Button add to cart changed to remove")
    public void buttonAddToCartChangedToRemove() {
        String vBtn = driver.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-bike-light')]")).getText();
        Assert.assertEquals("Remove", vBtn);
        driver.close();
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]")).click();
    }

    @Then("User redirected to cart page")
    public void userRedirectedToCartPage() {
        String cartTitle = driver.findElement(By.xpath("//span[contains(@class, 'title')]")).getText();
        Assert.assertEquals("Your Cart", cartTitle);
    }

    @And("User can see the light bike product in the cart")
    public void userCanSeeTheLightBikeProductInTheCart() {
        String itemName = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name')]")).getText();
        Assert.assertEquals("Sauce Labs Bike Light", itemName);
        driver.close();

    }
}
