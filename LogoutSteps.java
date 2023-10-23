package steplogout;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LogoutSteps {
    WebDriver driver;

    public LogoutSteps() {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Code to navigate to the login page is already correct
        driver.get("http://www.saucedemo.com");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click login button
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();
    }

    @And("^I click the login button$")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();
    }

    @Then("I should be on the products page")
    public void i_should_be_on_the_products_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("I click on the menu bar")
    public void i_click_on_the_menu_bar() {
        // Code to click on the menu bar
        WebElement menuButton = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        menuButton.click();
    }

    @And("I click logout button")
    public void i_click_logout_button() {
        // Logout button has an ID "logout_sidebar_link"
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }

    @Then("I should be logged out")
    public void i_should_be_logged_out() {
        // Add code to verify that the user is logged out
        // For example, you can check if the login page is displayed again
        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
