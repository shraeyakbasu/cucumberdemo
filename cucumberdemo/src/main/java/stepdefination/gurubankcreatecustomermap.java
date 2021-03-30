package stepdefination;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class gurubankcreatecustomermap 
{
	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_guru_login_page()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get("http://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@When("^user enter username and password$")
	public void user_enter_username_and_password(DataTable credentials) 
	{
	  for(Map<String,String> data : credentials.asMaps(String.class, String.class))
	  {
	   driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(data.get("userid"));
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
	  } 
	}
	
	@And("^click on login button$")
	public void click_on_guru_login_button()
	{
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	
	@Then("^user is on home page$")
	public void user_is_on_home_page()
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
	}

	@Then("^user click on new customer button$")
	public void user_click_on_new_customer_button() 
	{
	    driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
	}

	@And("^user give valid details and submit$")
	public void user_give_valid_details(DataTable credentials) 
	{
	    for(Map<String,String> data1:credentials.asMaps(String.class, String.class))
	    {
	    	driver.findElement(By.xpath("//input[@name='name']")).sendKeys(data1.get("customername"));
	    	driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(data1.get("dateofbirth"));
	    	driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(data1.get("address"));
	    	driver.findElement(By.xpath("//input[@name='city']")).sendKeys(data1.get("city"));
	    	driver.findElement(By.xpath("//input[@name='state']")).sendKeys(data1.get("state"));
	    	driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(data1.get("pin"));
	    	driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(data1.get("mobilenumber"));
	    	driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(data1.get("email"));
	    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data1.get("password"));
	    	
	    	driver.findElement(By.xpath("//input[@name='sub']")).click();
	    	try {
				Alert alt=driver.switchTo().alert();
				alt.accept();
				} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	    	driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
	    }
	}

	

	@And("^logout from the application$")
	public void logout_from_the_application() 
	{
	    driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}
	
	@And("^quit the browser$")
	public void quit_the_browser()
	{
		driver.quit();
	}



}
