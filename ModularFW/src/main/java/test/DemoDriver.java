package test;

import commonLibs.implementation.DriverControl;

public class DemoDriver {

	public static void main(String[] args) throws Exception {
		try {
		DriverControl cmnDriver = new DriverControl ("chrome");
		cmnDriver.setPageLoadTimeout(20);
		cmnDriver.setElementDetectionTimeout(5);
		cmnDriver.navigateToFirstURL("http://qatechhub.com");
		System.out.println(cmnDriver.getTitle());
		System.out.println(cmnDriver.getCurrentUrl());
		System.out.println(cmnDriver.getPageSource());
		cmnDriver.closeAllBrowsers();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
}
