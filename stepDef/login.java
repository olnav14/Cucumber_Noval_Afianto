package KasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User masuk ke halaman login")
    public void halaman_login_swag_labs(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }
    @When("User mamasukan username valid")
    public void input_username_valid(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @When("User mamasukan username unvalid")
    public void input_username_unvalid(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
    }
    @And("User memasukan password valid")
    public void input_password_valid(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @And("User memasukan password unvalid")
    public void input_password_unvalid(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce12");
    }
    @And("User klik Login")
    public void klik_login(){
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User berhasil Login")
    public void login_succes(){
        String Login = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(Login, "Swag Labs");
    }
    @Then("User gagal Login")
    public void failed_succes(){
        String failedrespon = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        System.out.println(failedrespon);
        Assert.assertEquals(failedrespon, "Epic sadface: Username and password do not match any user in this service");
    }
}
