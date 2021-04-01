package stepdefination;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class gurubankcreatecurrentaccountstepdefination 
{
	WebDriver driver;
	
	@Given("^when user is on gurubank login page to create current account$")
	public void when_user_is_on_gurubank_login_page()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get("http://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Then("^he enters username and password$")
	public void he_enters_username_and_password(DataTable credentials) 
	{
	    for(Map<String,String> data:credentials.asMaps(String.class, String.class))
	    {
	       driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(data.get("userid"));
	 	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
	    }
	}

	@And("^he clicks on login button$")
	public void he_clicks_on_login_button() 
	{
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@When("^user is on gurubank home page$")
	public void user_is_on_gurubank_home_page() 
	{
	    
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
	}
	
	@Then("^user clicks on new account link$")
	public void he_clicks_on_new_account_link()
	{
		 driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		    
	}

	@When("^user is on gurubank add new account page$")
	public void user_is_on_gurubank_add_new_account_page() 
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
	    
	}

	@Then("^he enters valid details and click on submit$")
	public void he_enters_valid_details(DataTable credentials) throws InterruptedException 
	{
	    for(Map<String,String> data :credentials.asMaps(String.class, String.class))
	    {
	    	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(data.get("customerid"));
	    	 driver.findElement(By.xpath("//input[@name='inideposit']")).sendKeys(data.get("initialdeposit"));
	    	 WebElement accounttypedropdown=driver.findElement(By.xpath("//select[@name='selaccount']"));
	 	    Select sel=new Select(accounttypedropdown);
	 	    sel.selectByValue("Current");
	 	   driver.findElement(By.xpath("//input[@type='submit']")).click();
		   Thread.sleep(3000);
		   WebElement accid=driver.findElement(By.xpath("(//tr)[5]"));
		   System.out.println(accid.getText());
		   driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		   
	     }
	    
	}
	

	@And("^logout and quit the browser$")
	public void logout_and_quit_the_browser() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
	    driver.quit();
	}



}
