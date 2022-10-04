package stepdefinations;

import java.util.List;
import java.util.Random;

import io.cucumber. datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizations {
	WebDriver driver;
	@Given("launch the browser")
	public void launch_the_browser() {	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
		
	}

	@Given("Enter  the URL")
	public void enter_the_url() {
		driver.get("http://localhost:8888/");	
		
		
	}

	@Given("In login page enter username and password and click on login button")
	public void in_login_page_enter_username_and_password_and_click_on_login_button() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}

	@When("Click on org link")
	public void click_on_org_link() {
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[.='Organizations']")).click();
		
	}

	@When("CLick on org image")
	public void c_lick_on_org_image() {
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}

	@When("Enter the orgname {string}  and click on indusrty and click on save button")
	public void enter_the_orgname_and_click_on_indusrty_and_click_on_save_button(String orgName) {
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(industryDropdown);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

	@When("Verify organization created and industry")
	public void verify_organization_created_and_industry() {
		String actualOrganizationName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		String ExpectedOrganizationName = "subrat";
		Assert.assertTrue(actualOrganizationName.contains(ExpectedOrganizationName));
		 String actualindustry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		 Assert.assertTrue(actualindustry.contains(actualindustry));		
	}

	@When("Enter OrganizationName {string} and {string} select the industry and click on save button")
	public void enter_organization_name_and_select_the_industry_and_click_on_save_button(String orgName, String email) {
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email);
	WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industry']"));
	Select s = new Select(industryDropdown);
	s.selectByIndex(1);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}
	

@Then("Verify the organization  {string} is created and industry")
public void verify_the_organization_is_created_and_industry(String string) {
	String actualOrganizationName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	String ExpectedOrganizationName = "subrat";
	Assert.assertEquals( ExpectedOrganizationName, actualOrganizationName  );
	 String actualindustry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
	 Assert.assertTrue(actualindustry.contains(actualindustry));
}

@Then("verify eamil {string}")
public void verify_eamil(String string) {
	String actualmail = driver.findElement(By.xpath("//span[@id='dtlview_Email']")).getText();
	Assert.assertTrue(actualmail.contains(actualmail));
	
}

@When("Enter the OrganizationName orgName and email and click on the save button")
public void enter_the_organization_name_org_name_and_email_and_click_on_the_save_button(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.

	int ranNum = new Random().nextInt(100);

	List<List<String>> data = dataTable.asLists();
	String orgName = data.get(1).get(0);
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName+ranNum);
	String emailid = data.get(1).get(1);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailid);
	driver.findElement(By.xpath("//input[@value='  Save")).click();
	


	
}



@Then("verify orgName is created or not")
public void verify_org_name_is_created_or_not(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	List<List<String>> data = dataTable.asLists();
	String orgNames = data.get(1).get(0);
	String actualOrganizationName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	Assert.assertTrue(actualOrganizationName.contains(orgNames));
	
}


}
	
	
