package cartstep;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class stepaddcart {
    WebDriver driver;

    public stepaddcart() {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Given("^I am already logged in to my account with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_am_already_logged_in_to_my_account_with_username_and_password(String username, String password) {
        driver.get("http://www.saucedemo.com");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Then("^I should be on the products page$")
    public void i_should_be_on_the_products_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("^I select a product with the name \"([^\"]*)\"$")
    public void i_select_a_product_with_the_name(String productName) {
        WebElement product = driver.findElement(By.cssSelector("*[data-test='add-to-cart-sauce-labs-backpack']"));
        product.click();
    }

    @And("^I add it to the cart$")
    public void i_add_it_to_the_cart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        addToCartButton.click();
    }

    @Then("^The product \"([^\"]*)\" should be visible in the cart$")
    public void the_product_should_be_visible_in_the_cart(String productName) {
        WebElement cartProduct = driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='" + productName + "']"));
        Assert.assertNotNull(cartProduct);
    }

    @Then("^I should see an error message indicating the product doesn't exist$")
    public void i_should_see_an_error_message_indicating_the_product_does_not_exist() {
        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

}
