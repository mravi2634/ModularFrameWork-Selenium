package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;

public class DriverControl implements IDriver {
	private WebDriver driver;
	
	private int pageLoadTimeout;
	
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	private int elementDetectionTimeout;
	
	public DriverControl(String browserType) throws Exception {
		
		pageLoadTimeout = 10;
		elementDetectionTimeout = 5;
		
		browserType = browserType.trim();
		
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Ravi/Selenium Softwares/Selenium Drivers/Chrome/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/Ravi/Selenium Softwares/Selenium Drivers/Firefox/geckodriver-v0.21.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser type : " + browserType);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void navigateToFirstURL(String url) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		url = url.trim();
		if(url.isEmpty()){
			throw new Exception("Empty url");
		}
		driver.get(url);
	}

	public String getTitle() throws Exception {
		return driver.getTitle();
	}

	public String getCurrentUrl() throws Exception {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() throws Exception {
		return driver.getPageSource();
	}

	public void navigateToUrl(String url) throws Exception {
		url = url.trim();
		driver.navigate().to(url);
		
	}

	public void navigateForward() throws Exception {
		driver.navigate().forward();
		
	}

	public void navigateBackward() throws Exception {
		driver.navigate().back();
		
	}

	public void refresh() throws Exception {
		driver.navigate().refresh();
		
	}

	public void closeBrowser() throws Exception {
		if(driver!=null) {
			driver.close();
		}
	}

	public void closeAllBrowsers() throws Exception {
		if(driver!=null) {
			driver.quit();
		}
		
	}


}
