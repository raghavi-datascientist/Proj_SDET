package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Steps {
	WebDriver driver;
	
	@Given("Login application present")
	public void login_application_present() {
		System.setProperty("webdriver.chrome.driver", "C:\\For Drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://elearningm1.upskills.in/index.php");
	}
	
	@When("enter valid username {string}")
	public void enter_valid_username(String string) {
	    driver.findElement(By.xpath("//input[@id='login']")).sendKeys(string);
	}
	
	@When("enter valid password {string}")
	public void enter_valid_password(String string) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(string);
	}
	
	@When("click on Login validButton")
	public void click_on_login_valid_button() {
	    driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
	    
	}
	
	@Then("I should see email as {string}")
	public void i_should_see_email_as(String string) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='count_message_li']/following-sibling::li/a")).click();
		Thread.sleep(2000);
	    String Actual=driver.findElement(By.xpath("//div[@class='text-center']/p")).getText();
	    Assert.assertEquals(Actual,string); 	    
	    
	}
	
	@Then("click on Inbox")
	public void click_on_inbox() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='Inbox']")).click();
	}
	
	@Then("click on Compose Message")
	public void click_on_compose_message() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@title='Compose message']")).click();
	}
	
	@Then("enter value for Send to as {string}")
	public void enter_value_for_send_to_as(String string) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
	    
	}
	
	@Then("enter Subject as {string}")
	public void enter_subject_as(String string) {
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys(string);	    
	}
	
	@Then("enter Message as {string}")
	public void enter_message_as(String string) throws InterruptedException {
		Thread.sleep(6000);		
		WebElement frameElement=driver.findElement(By.xpath("//*[@id='cke_1_contents']/iframe"));
	    driver.switchTo().frame(frameElement);
	    WebElement editable = driver.switchTo().activeElement();
	    editable.sendKeys(string);
	   driver.switchTo().defaultContent();	   
	}
	
	
	
	@Then("click on send button")
	public void click_on_send_button() throws InterruptedException {
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
		
	}
	
	@Then("I should see acknowledgement as {string}")
	public void i_should_see_acknowledgement_as(String string) throws InterruptedException {
		Thread.sleep(2000);	
	    String Actual=driver.findElement(By.xpath("//*[contains(text(), 'The message has been sent')]")).getText();		
	    Assert.assertEquals(Actual,string);
	    
	}
	
	@Then("close the driver")
	public void close_the_driver() {
		driver.quit();
	}	

}
