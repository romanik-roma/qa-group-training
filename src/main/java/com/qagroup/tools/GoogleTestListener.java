package com.qagroup.tools;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class GoogleTestListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		// super.onTestFailure(tr);
		IWebAppTest instance = (IWebAppTest) tr.getInstance();
		instance.getTestedInstance().takeScreenshot("Failure screenshot!");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		// super.onTestFailure(tr);
		IWebAppTest instance = (IWebAppTest) tr.getInstance();
		instance.getTestedInstance().takeScreenshot("Success Screenshot!");
	}

}
