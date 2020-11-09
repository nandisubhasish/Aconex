package com.selenium.testcases;

import org.testng.annotations.Test;

import com.selenium.base.BaseTest;

public class DummyTestA extends BaseTest{
	
	@Test(priority=1)
	public void testA1() {
		
	}
	
	@Test(priority=2,dependsOnMethods = {"testA1"})
	public void testA2() {
		
	}
	
	@Test(priority=3,dependsOnMethods = {"testA1","testA2"})
	public void testA3() {
		
	}

}
