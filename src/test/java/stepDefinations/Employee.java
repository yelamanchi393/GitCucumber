package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Employee {
	WebDriver driver;
	String expectedeid ="";
	String actualeid ="";
	@Given("^User naviget url \"([^\"]*)\" in a browser$")
	public void user_naviget_url_in_a_browser(String url) throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enter username \"([^\"]*)\" and Enter password \"([^\"]*)\"$")
	public void user_enter_username_and_Enter_password(String username, String password) throws Throwable {
	   driver.findElement(By.name("txtUsername")).sendKeys(username);
	   driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click Login button$")
	public void user_click_Login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	}

	@When("^user click pim and add button$")
	public void user_click_pim_and_add_button() throws Throwable {
	    driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	    driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
	}

	@When("^user enter fname\"([^\"]*)\" and mname \"([^\"]*)\" and lname\"([^\"]*)\"$")
	public void user_enter_fname_and_mname_and_lname(String fname, String mname, String lname) throws Throwable {
	    driver.findElement(By.name("firstName")).sendKeys(fname);
	    driver.findElement(By.name("middleName")).sendKeys(mname);
	    driver.findElement(By.name("lastName")).sendKeys(lname);
	}

	@When("^user captures Employee id before saving$")
	public void user_captures_Employee_id_before_saving() throws Throwable {
	   expectedeid = driver.findElement(By.name("employeeId")).getAttribute("value"); 
	}

	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
	   driver.findElement(By.id("btnSave")).click();
	}

	@When("^user capture employee id after save$")
	public void user_capture_employee_id_after_save() throws Throwable {
		actualeid = driver.findElement(By.name("personal[txtEmployeeId]")).getAttribute("value");
	}

	@Then("^user validate employee id$")
	public void user_validate_employee_id() throws Throwable {
	    if(expectedeid.equals(actualeid))
	    {
	    	System.out.println("Employee id matching::"+expectedeid+"    "+actualeid);
	    }
	    else
	    {
	    	System.out.println("Employee id Not matching::"+expectedeid+"    "+actualeid);
	    }
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	    driver.close();
	}


}