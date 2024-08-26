package Testjunit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class Form {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://only-testing-blog.blogspot.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testForm() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl);
    try {
      assertEquals("Form", driver.findElement(By.linkText("Form")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Form")).click();
    driver.findElement(By.name("FirstName")).clear();
    driver.findElement(By.name("FirstName")).sendKeys("First");
    driver.findElement(By.name("LastName")).clear();
    driver.findElement(By.name("LastName")).sendKeys("Last");
    driver.findElement(By.name("EmailID")).clear();
    driver.findElement(By.name("EmailID")).sendKeys("first@email.com");
    driver.findElement(By.name("MobNo")).clear();
    driver.findElement(By.name("MobNo")).sendKeys("4075555555");
    driver.findElement(By.name("Company")).clear();
    driver.findElement(By.name("Company")).sendKeys("Test");
    assertEquals("Only Testing: Form", driver.getTitle());
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    //assertEquals("Your Form Is Submitted", closeAlertAndGetItsText());
  }

  private Object closeAlertAndGetItsText() {
	// TODO Auto-generated method stub
	return null;
}

@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}