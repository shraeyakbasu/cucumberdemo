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

public class actitimeloginstepdefination 
{
	WebDriver driver;

	@Given("^user is already on login page$")
	public void userisonloginpage()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");
	}
	
	@When("^title of the page is actiTIME -  Login$")
	public void titleofpage()
	{
		String expectedtitle="actiTIME -  Login";
		String actualtitle=driver.getTitle();
		if(actualtitle.equalsIgnoreCase(expectedtitle))
		{
			System.out.println("title got matched");
		}
		
	}
	
	@Then("^enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_and(String username, String password) 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
	}
	
	
	@And("^click on the login button$")
	public void loginbuttonclick()
	{
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	}
	
	@When("^title of the page is actiTIME -  Enter Time-Track$")
	public void hometitlecheck()
	{
		String expectedtitle="actiTIME -  Enter Time-Track";
		String actualtitle=driver.getTitle();
		if(actualtitle.equalsIgnoreCase(expectedtitle))
		{
			System.out.println("title got matched");
		}
	}
	
	@Then("^click on logout link$")
	public void logoutclick()
	{
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
	}
	
	/*
	 * @And("^quit the browser$") public void quitbrowser() { driver.quit(); }
	 */
	
	
	
	
}
