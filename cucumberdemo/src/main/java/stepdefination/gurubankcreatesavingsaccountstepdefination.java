package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class gurubankcreatesavingsaccountstepdefination 
{
	WebDriver driver;
	
	@Given("^when user is on gurubank login page$")
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

	@Then("^user enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_valid_username_and_password(String userid, String password) 
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userid);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@And("^he clicks on gurubank login button$")
	public void he_clicks_on_gurubank_login_button() 
	{
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^when user is on gurubank homepage$")
	public void when_user_is_on_gurubank_homepage() 
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
	}

	@Then("^he clicks on new account link$")
	public void he_clicks_on_new_account_link() 
	{
	    driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
	    String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
	}

	@And("^he enters all valid details$")
	public void he_enters_all_valid_details() 
	{
	    driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("49403");
	    WebElement accounttypedropdown=driver.findElement(By.xpath("//select[@name='selaccount']"));
	    Select sel=new Select(accounttypedropdown);
	    sel.selectByValue("Savings");
	    
	    driver.findElement(By.xpath("//input[@name='inideposit']")).sendKeys("5000");
	}

	@And("^clicks on submit button$")
	public void clicks_on_submit_button() throws InterruptedException 
	{
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
	   Thread.sleep(4000);
	   WebElement accid=driver.findElement(By.xpath("(//tr)[5]"));
	   System.out.println(accid.getText());
	}

	@Then("^logout from the application and quit the browser$")
	public void logout_from_the_application_and_quit_the_browser() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
	    driver.quit();
	}


}
