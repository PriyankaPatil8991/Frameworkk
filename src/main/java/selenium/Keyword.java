package selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	public static void openBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Cons.driver = new ChromeDriver();
			System.out.println("Opening browser " + browsername);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Cons.driver = new FirefoxDriver();
			System.out.println("Opening browser " + browsername);
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Cons.driver = new InternetExplorerDriver();
			System.out.println("Opening browser " + browsername);
		case "Safari":
		default:
			System.out.println("Invalid browsername " + browsername);
			break;
		}
	}
	public static WebElement getWebElement(String locatortype, String locatorvalue) {
		WebElement element = null;
		switch (locatortype) {
		case "XPATH":
			element = Cons.driver.findElement(By.xpath(locatorvalue));
			break;
		case "CSS":
			element = Cons.driver.findElement(By.cssSelector(locatorvalue));
			break;
		case "ID":
			element = Cons.driver.findElement(By.id(locatorvalue));
			break;
		case "PARTIAL_LINKTEXT":
			element = Cons.driver.findElement(By.partialLinkText(locatorvalue));
			break;
		case "LINKTEXT":
			element = Cons.driver.findElement(By.linkText(locatorvalue));
			break;
		case "CLASSNAME":
			element = Cons.driver.findElement(By.className(locatorvalue));
		default:
			System.err.println("Invalid locator type " + locatortype
					+ ("Expected CSS,XPATH,PARTIAL_LINKTEXT,LINKTEXT,CLASS_NAME,ID"));
			break;

		}
		return element;
	}
	public static void openURL(String URL) {
		Cons.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Cons.driver.get("https://eagercrow.com/Home");

	}


	public static void enterText(String locatortype, String locatorvalue, String textToEnter) {
		Cons.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		getWebElement(locatortype, locatorvalue).sendKeys(textToEnter);
	}

	public static void clickonElement(String locatortype, String locatorvalue) {
		getWebElement(locatortype, locatorvalue).click();
	}
	public static void maximizeBrowser() {
		Cons.driver.manage().window().maximize();
	}
	public static void windowHandles(String webElement) {
		String parent_window = Cons.driver.getWindowHandle();
		System.out.println("before switch title is " + Cons.driver.getTitle());
		Set<String> s = Cons.driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (parent_window.equals(childwindow)) {
				Cons.driver.switchTo().window(childwindow);
				System.out.println(Cons.driver.getTitle());
				Cons.driver.findElement(By.xpath(webElement)).click();

			}
		}
	}
	public static void addTocart(String element) {
		Cons.driver.findElement(By.xpath(element));		
	}
	public static void scrollBar() {
		JavascriptExecutor js=(JavascriptExecutor)Cons.driver;
		js.executeScript("windowScrollBy(0,200)");
	}
	public static void actionoperation(String action) {
		Actions action1 = new Actions(Cons.driver);
	    action1.moveToElement(Cons.driver.findElement(By.xpath(action))).click();
	    action1.build().perform();
	}



	public static void closeBrowser() {
		Cons.driver.close();
	}

	public static void closeAllbrowser() {
		Cons.driver.quit();
	}
}
