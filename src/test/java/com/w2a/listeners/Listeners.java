package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution of Project Tests started");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String Testname=result.getTestName();
		System.out.println(Testname + "started executing.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Testname=result.getTestName();
		System.out.println(Testname + "got successfully executed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Testname=result.getTestName();
		System.out.println(Testname + "got failed.");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String Testname=result.getTestName();
		System.out.println(Testname + "got skipped.");
		System.out.println(result.getThrowable());
	}
	

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Finished executing Project Test.");
		
	}
	

}
