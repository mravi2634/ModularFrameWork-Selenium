package commonLibs.implementation;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlerts;

public class AlertsControl implements IAlerts{

	private WebDriver driver;
	
	public AlertsControl(WebDriver driver) {
		this.driver = driver;
	}
	public void acceptAlert() throws Exception {
		driver.switchTo().alert().accept();
	}

	public void rejectAlert() throws Exception {
		driver.switchTo().alert().dismiss();
	}

	public String getMessageFromAlert() throws Exception {
		return driver.switchTo().alert().getText();
	}

	public boolean isAlertPresent(int timeoutInSeconds) throws Exception {
		return false;
	}

}
