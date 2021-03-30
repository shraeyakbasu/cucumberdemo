package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class facebookloginstepdefination 
{

	public WebDriver driver;
	
	@Given("^user is on facebook login page$")
	public void user_is_on_facebook_login_page() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Then("^user enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_username_and_password(String username, String password) 
	{
	   driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
	   driver.findElement(By.id("pass")).sendKeys(password);
	   
	}
	
	@Then("^click on facebook login button$")
	public void click_on_facebook_login_button() 
	{
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	

	@When("^user is on facebook home page$")
	public void user_is_on_home_page() throws InterruptedException 
	{
		Thread.sleep(3000);
	    String actualtitle=driver.getTitle();
	    System.out.println(actualtitle);
	}
	
	@Then("^click upon facebook logout link$")
	public void click_on_logout_link() throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement logoutdropdown=driver.findElement(By.xpath("(//div[@data-visualcompletion='ignore'])[9]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click()", logoutdropdown);
	    WebElement logoutlink=driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
	    js.executeScript("arguments[0].click()", logoutlink);
	}

	@Then("^close the facebook browser$")
	public void close_the_browser()
	{
	    driver.quit();
	}


}
