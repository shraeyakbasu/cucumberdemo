package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class actitimecreatecustomerstepdefination
{
	WebDriver driver;
	
	@Given("^as user is on login page$")
	public void as_user_is_on_login_page() 
	{
	   
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://demo.actitime.com/login.do");
	}

	@When("^title of page is actiTIME -  Login$")
	public void title_of_page_is_actiTIME_Login() 
	{
	    String actualtitle=driver.getTitle();
	    System.out.println(actualtitle);
	}

	@Then("^user enters valid username and password$")
	public void user_enters_valid_username_and_password() 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() 
	{
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	}

	@When("^title of page is actiTIME -  Enter Time-Track$")
	public void title_of_page_is_actiTIME_Enter_Time_Track() 
	{
	  String actualtitle= driver.getTitle();
	  System.out.println(actualtitle);
	}

	@Then("^click on tasks link$")
	public void click_on_tasks_link() 
	{
	    driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
	}

	@When("^title of page is actiTIME -  Task List$")
	public void title_of_page_is_actiTIME_Task_List() 
	{
		String actualtitle= driver.getTitle();
		System.out.println(actualtitle);
	}

	@Then("^click on add new button and click on new customer link$")
	public void click_on_add_new_button_and_click_on_new_customer_link()
	{
	    driver.findElement(By.xpath("//div[contains(text(),'Add New')]")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'+ New Customer')]")).click();
	}

	@Then("^enter valid customer name and description$")
	public void enter_valid_customer_name_and_description() 
	{
	    driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys("pyspiders");
	    driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("educational institute");
	    
	}

	@Then("^click on create customer button$")
	public void click_on_create_customer_button() 
	{
	   driver.findElement(By.xpath("//div[contains(text(),'Create Customer')]")).click();
	}
	
	@And("^logout from application$")
	public void logout_from_application()
	{
		
		driver.quit();
	}



}
