package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class actitimedeletecustomerstepdefination 
{
	WebDriver driver;
	
	
	@Given("^when user is on login page$")
	public void when_user_is_on_login_page() 
	{
		 WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    driver.get("https://demo.actitime.com/login.do");
	    
	}

	@Then("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enter_username_and_password(String username, String password) 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
	    
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() 
	{
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	    
	}

	@Then("^user click on task link$")
	public void user_click_on_task_link() 
	{
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
	    
	}

	@And("^click on addnew button and click on new customer link$")
	public void click_on_addnew_button_and_click_on_new_customer_link() 
	{
		WebElement addnewbutton=driver.findElement(By.xpath("//div[contains(text(),'Add New')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addnewbutton);
	    driver.findElement(By.xpath("//div[contains(text(),'+ New Customer')]")).click();
	    
	}

	@Then("^give customer name \"([^\"]*)\" and description \"([^\"]*)\"$")
	public void give_customer_name_and_description(String customer, String description) 
	{
		 driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(customer);
		 driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(description);
	    
	}
	
	@And("^click on createcustomer button$")
	public void click_on_create_customer_button()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Create Customer')]")).click();
	}

	@Then("^click on quicktoview settings link$")
	public void click_on_quicktoview_settings_link() 
	{
	    
	    driver.findElement(By.xpath("(//div[contains(text(),'qspiders')])[1]//..//..//div[@class='editButton']")).click();
	    
	}

	@And("^then click on action button$")
	public void then_click_on_action_button()
	{
	    WebElement actionbutton=driver.findElement(By.xpath("(//div[@class='actionButton'])[7]"));
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click()", actionbutton);
	    
	    
	    
	}

	@And("^select delete link$")
	public void select_delete_link()  
	{
		WebElement deletelink=driver.findElement(By.xpath("(//div[contains(text(),'Delete')])[2]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", deletelink);
	   
	}

	@Then("^click on delete permanently button$")
	public void click_on_delete_permanently_button()
	{
	    driver.findElement(By.xpath("//span[contains(text(),'Delete permanently')]")).click();
	    
	}

	@And("^logout from site$")
	public void logout_from_site() 
	{
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
		driver.quit();
	    
	}



}
