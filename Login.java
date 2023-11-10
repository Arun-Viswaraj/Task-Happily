import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Login {
	WebDriver driver;
	
	
  @Test(priority=1)
  public void f() throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	WebElement loginopt=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/button[1]")));
	Thread.sleep(5000);
	loginopt.click();
	WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginEmail")));
	email.sendKeys("happileetechuser@mailinator.com");
	WebElement getotp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/button[2]")));
	getotp.click();
	
  }
  @Test(priority=2)
  public void mailotp() throws InterruptedException {
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.navigate().to("https://www.mailinator.com/");
	  driver.manage().window().maximize();
	  WebElement search=driver.findElement(By.id("search"));
	  search.sendKeys("happileetechuser@mailinator.com");
	  Thread.sleep(4000);
	  Actions action=new Actions(driver);
	  action.moveToElement(search);
	  action.keyDown(Keys.ENTER);
	  System.out.println(driver.getTitle());
	  WebElement go=driver.findElement(By.xpath("/html/body/div[1]/header[1]/div[1]/div/div/div[1]/div/button"));
	  go.click();
	  Thread.sleep(4000);
	  WebElement findotp=driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[3]/div/div[4]/div/div/table/tbody/tr[1]/td[3]"));
	  findotp.click();
	  Thread.sleep(4000);
	 
	  driver.switchTo().frame(driver.findElement(By.id("html_msg_body")));
	  WebElement otpelemnt=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr/td/div/p/strong"));
	  String otpp=otpelemnt.getText();
	  Set<String> window1=driver.getWindowHandles();
	  List<String> list=new ArrayList<String>(window1);
	  driver.switchTo().window(list.get(0));
	  WebElement otpfield=driver.findElement(By.xpath("/html/body/div/div/main/div/div/div/div[2]/div[2]/div[2]/div/input[1]"));
	  otpfield.sendKeys(otpp);
	  WebElement submitotp=driver.findElement(By.xpath("/html/body/div/div/main/div/div/div/div[2]/div[2]/div[2]/button[1]"));
	  submitotp.click();
	  
	  
	 // Thread.sleep(4000);
	  
	  
	  
  }
	  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\OneDrive\\Desktop\\Testing_files\\chromedriver_win32");
	  driver=new ChromeDriver();
	  driver.get("https://stage.happilee.io/login");
  }

  @AfterTest
  public void afterTest() {
  }

}
