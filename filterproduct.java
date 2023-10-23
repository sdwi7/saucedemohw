package stepfilter;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;

public class filterproduct {
    WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string} and log in")
    public void i_enter_username_and_password_and_log_in(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @And("I should be logged in and in the product page")
    public void i_should_be_logged_in_and_in_the_product_page() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("I apply a filter for {string}")
    public void i_apply_a_filter_for(String filterOption) {
        WebElement filterSelect = driver.findElement(By.cssSelector("*[data-test='product_sort_container']"));
        filterSelect.click();
        WebElement option = driver.findElement(By.xpath("//div[@class='product_sort_container']/select/option[text()='" + filterOption + "']"));
        option.click();
    }

    @Then("I should see the filtered products list")
    public void i_should_see_the_filtered_products_list() throws InterruptedException {
        // Add verification logic here
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
