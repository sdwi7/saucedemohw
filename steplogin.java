package stepbystep;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class steplogin {

    WebDriver driver;

    public steplogin() {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() {
        driver.get("http://www.saucedemo.com");
    }

    @When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_enter_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("^I click the login button$")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();
    }

    @Then("^I should be on the products page$")
    public void i_should_be_on_the_products_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        // Close the browser after a successful login
        driver.quit();
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws InterruptedException {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorElement.isDisplayed());

        driver.quit();
        Thread.sleep(5000);
    }
}
