package KasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User masuk ke halaman login_1")
    public void halaman_login_swag_labs() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }
        @When("User mamasukan username valid_1")
        public void input_username_valid(){
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
        }
    @And("User memasukan password valid_1")
    public void input_password_valid(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @And("User klik Login_1")
    public void klik_login(){
        driver.findElement(By.id("login-button")).click();
    }
    @And("User berhasil Login_1")
    public void login_succes(){
        String Login = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(Login, "Swag Labs");
    }
    @And("User klik add to cart")
    public void klik_addtocart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    @And("User berhasil add to cart")
    public void berhasil_addtocart(){
        String Sauce= driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(Sauce, "Remove");
    }
    @Then("Cart menampilkan jumlah barang")
    public void jumlah_cart_bertambah(){
        String Sauce= driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(Sauce, "1");
    }
}
