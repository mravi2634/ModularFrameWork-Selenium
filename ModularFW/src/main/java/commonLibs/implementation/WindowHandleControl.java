package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindowHandle;

public class WindowHandleControl implements IWindowHandle{
	private WebDriver driver;
	
	public WindowHandleControl(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToChildWindow() throws Exception {
		String childWindow = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(childWindow);
	}

	public void switchToAnyWindow(String windowhandle) throws Exception {
		driver.switchTo().window(windowhandle);	
	}

	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		String childWindow = driver.getWindowHandles().toArray()[childWindowIndex].toString();
				driver.switchTo().window(childWindow);
	}

	public String getWindowHandle() throws Exception {
		return driver.getWindowHandle();	
	}

	public Set<String> getWindowHandles() throws Exception {
		return driver.getWindowHandles();
	}
}
