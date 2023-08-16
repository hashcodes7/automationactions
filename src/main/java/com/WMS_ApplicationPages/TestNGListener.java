package com.WMS_ApplicationPages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Test_Rail.Test_Rail_Actions;




public abstract class TestNGListener implements ITestListener{
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	
	public void onTestStart(ITestResult result)
	{
		System.out.println(ANSI_BLUE + "Starting test:"+ result.getName()+ANSI_RESET);
	}
	
	

	public void onTestSuccess(ITestResult result)
	{
		System.out.println(ANSI_GREEN + "Test run success for: "+ result.getName()+ " in "+ (result.getEndMillis() - result.getStartMillis())/100 + " Seconds"+ ANSI_RESET);
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println(ANSI_RED + "Test run failed for: "+ result.getName()+ " in "+ (result.getStartMillis() - result.getEndMillis())+ ANSI_RESET);
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println(ANSI_YELLOW + "Execution ended:"+context.getName()+ ANSI_RESET);
	}
}
