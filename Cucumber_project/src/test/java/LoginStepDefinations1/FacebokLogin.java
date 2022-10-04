package LoginStepDefinations1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebokLogin {
	WebDriver driver;
	@Given("i should launch the browser")
	public void i_should_launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
//subrat kumar
	@Given("Enter validate the URL")
	public void enter_validate_the_url() {
		driver.get("https://www.facebook.com/");
	}//subrat ku sahu389

	@When("Enter the validate username and password")
	public void enter_the_validate_username_and_password() {
		driver.findElement(By.id("email")).sendKeys("+919178867176");
		driver.findElement(By.id("pass")).sendKeys("Be@12luc");
	}
	@When("Enter the validate username {string} and {string}")
	public void enter_the_validate_username_and(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@When("CLick on the login button")
	public void c_lick_on_the_login_button() {
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}


	@When("Click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("Verify the homepage")
	public void verify_the_homepage() {
		String actualTitle=driver.getTitle().trim();
		System.out.println("actualTitle");
		Assert.assertTrue(actualTitle.contains(""));
		driver.quit();
		
	}


}
