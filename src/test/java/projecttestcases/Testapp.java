package projecttestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import selenium.Cons;
import selenium.Keyword;

public class Testapp {
	@Test
	public void eagercrowApp() throws InterruptedException {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.eagercrow.com/");
		Keyword.maximizeBrowser();
		Keyword.clickonElement("XPATH", "//a[@class='color0-hov selected']	");
		Thread.sleep(3000);
		Keyword.clickonElement("XPATH", "//a[text()='Sign In']");
	}

	@Test
	public void signIn() throws InterruptedException {
		Keyword.windowHandles("//*[@id=\"firebaseui-auth-container\"]/div/div/form/ul/li[1]/button");
		Keyword.enterText("XPATH", "//input[@class='mdl-textfield__input firebaseui-input firebaseui-id-email']",
				"piyunish91@gmail.com");
		Keyword.clickonElement("XPATH", "//button[@type='submit']");
		// Keyword.enterText("XPATH", "//input[@class='mdl-textfield__input
		// firebaseui-input firebaseui-id-name']",
		// "Piyu Patil");
		Keyword.enterText("XPATH", "//*[@id=\"firebaseui-auth-container\"]/div/form/div[2]/div[3]/input",
				"nishikant.patil");
		Keyword.clickonElement("XPATH", "//button[@type='submit']");
		System.out.println("login is successful");
	}

	@Test
	public void addtoCart() {
		Keyword.windowHandles("");
	}
}
