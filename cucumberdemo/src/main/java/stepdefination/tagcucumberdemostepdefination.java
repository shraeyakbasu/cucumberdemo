package stepdefination;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class tagcucumberdemostepdefination
{
	WebDriver driver;
	
	@Given("^when user is on gmail login page$")
	public void when_user_is_on_gmail_login_page() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
	}

	@Then("^user provide valid gmail user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provide_valid_gmail_user_id_and_password(String userid, String password) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement signinlink=driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[2]"));
		js.executeScript("arguments[0].click()", signinlink);
		Set<String> windowhandles=driver.getWindowHandles();
		ArrayList<String> al=new ArrayList<String>(windowhandles);
		driver.switchTo().window(al.get(1));
	    driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(userid);
	    driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	    
	}

	@And("^user click on gmail login button$")
	public void user_click_on_gmail_login_button() 
	{
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		
	}

	@Then("^when user is on gmail home page he logout$")
	public void when_user_is_on_gmail_home_page_he_logout() 
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
	}

	@And("^quit the gmail browser$")
	public void quit_the_gmail_browser() 
	{
	    driver.quit();
	    
	}

	@Given("^when user is on yahoo login page$")
	public void when_user_is_on_yahoo_login_page() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/");
	   
	}

	@Then("^user provide valid yahoo user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provide_valid_yahoo_user_id_and_password(String username, String password) 
	{
	    driver.findElement(By.id("login-username")).sendKeys(username);
	    driver.findElement(By.id("login-signin")).click();
	    driver.findElement(By.id("login-passwd")).sendKeys(password);
	}

	@And("^user click on yahoo login button$")
	public void user_click_on_yahoo_login_button() 
	{
		driver.findElement(By.id("login-signin")).click();
	}

	@Then("^when user is on yahoo home page he logout$")
	public void when_user_is_on_yahoo_home_page_he_logout() 
	{
		System.out.println(driver.getTitle());
	    WebElement logoutlink=driver.findElement(By.xpath("(//div[contains(text(),'shraeyak')])[1]"));
	    WebElement signoutlink=driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
	    Actions act=new Actions(driver);
		act.moveToElement(logoutlink);
		act.moveToElement(signoutlink).click();
    }

	@And("^quit the yahoo browser$")
	public void quit_the_yahoo_browser() 
	{
	    driver.quit();
	    
	}

	@Given("^when user is on amazon login page$")
	public void when_user_is_on_amazon_login_page() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	    
	}

	@Then("^user provide valid amazon user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provide_valid_amazon_user_id_and_password(String username, String password) 
	{
	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   WebElement element =driver.findElement(By.xpath("//span[@class='nav-line-2 nav-short-width']"));
		js.executeScript("arguments[0].click()", element);
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(username);
	   driver.findElement(By.xpath("//input[@id='continue']")).click();
	   driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
	   
	}

	@And("^user click on yahoo amazon button$")
	public void user_click_on_yahoo_amazon_button() 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement signinbutton=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		js.executeScript("arguments[0].click()", signinbutton);
	}

	@Then("^when user is on amazon home page he logout$")
	public void when_user_is_on_amazon_home_page_he_logout() 
	{
		WebElement target=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement destination=driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]"));
		Actions act=new Actions(driver);
	    act.moveToElement(target);
	    act.moveToElement(destination).click();
		
	}

	@And("^quit the amazon browser$")
	public void quit_the_amazon_browser() 
	{
	    
	   driver.quit();
	}

	@Given("^when user is on flipkart login page$")
	public void when_user_is_on_flipkart_login_page() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	    
	}
	
	@Then("^user provide valid flipkart user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provide_valid_flipkart_user_id_and_password(String username, String password) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement loginlink=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		js.executeScript("arguments[0].click()", loginlink);
	   driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(username);
	   driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(password);
	   WebElement flipkartloginbutton=driver.findElement(By.xpath("(//span[contains(text(),'Login')])[2]"));
	   js.executeScript("arguments[0].click()", flipkartloginbutton); 
	    
	}

	@Then("^when user is on flipkart home page he logout$")
	public void when_user_is_on_flipkart_home_page_he_logout() 
	{
		String actualtitle=driver.getTitle();
	    System.out.println(actualtitle);
		WebElement targetelement=driver.findElement(By.xpath("//div[contains(text(),'shraeyak')]"));
		WebElement destinationelement=driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
	    Actions act=new Actions(driver);
	    act.moveToElement(targetelement);
	    act.moveToElement(destinationelement).click();
	    
	    
	}

	@And("^quit the flipkart browser$")
	public void quit_the_flipkart_browser() 
	{
	    driver.quit();
	}

	@Given("^when user is on gurubanklogin page$")
	public void when_user_is_on_gurubanklogin_page() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get("http://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   
	}

	@Then("^user provide valid gurubank user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provide_valid_gurubank_user_id_and_password(String username, String password) 
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    
	}

	@And("^user click on gurubank login button$")
	public void user_click_on_gurubank_login_button() 
	{
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    
	}

	@Then("^when user is on gurubank home page he logout$")
	public void when_user_is_on_gurubank_home_page_he_logout() 
	{
	    
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
	    
	}

	@And("^quit the gurubank browser$")
	public void quit_the_gurubank_browser() 
	{
	    driver.quit();
	    
	}

	@Given("^when user is on actitime login page$")
	public void when_user_is_on_actitime_login_page() 
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");
	   
	}

	@Then("^user provide valid actitime user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provide_valid_actitime_user_id_and_password(String username, String password) 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
	    
	}

	@And("^user click on actitime login button$")
	public void user_click_on_actitime_login_button() 
	{
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	    
	}

	@Then("^when user is on actitime home page he logout$")
	public void when_user_is_on_actitime_home_page_he_logout() 
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
	   
	}

	@And("^quit the actitime browser$")
	public void quit_the_actitime_browser() 
	{
	    driver.quit();
	    
	}


}
