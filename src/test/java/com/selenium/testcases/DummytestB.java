package com.selenium.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.selenium.base.BaseTest;

public class DummytestB extends BaseTest {

	@Test
	public void testB() {

		openBrowser("browser");
		navigate("appurl");
		typeInto("xpath_LoginName", "value_LoginName1");
		typeInto("xpath_Password", "value_Password1");
		clickItem("xpath_LogInButton");
		waitForPageToLoad();
		waitForElement("xpath_NavBar_Mail_Button");
		clickItem("xpath_NavBar_Mail_Button");
		clickItem("xpath_Navbar_Panel_Menu_BlankMail_Item");
		waitForPageToLoad();
		managingFrames("xpath_Select_Correspondence_TypeID");
		selectDropDown("xpath_Select_Correspondence_TypeID", "value_Correspondence_TypeID");
		typeInto("xpath_Correspondence_Subject", "value_Correspondence_Subject");
		clickItem("xpath_Edit_Attribute_1");
		selectDropDown("xpath_Attribute_1", "value_Attribute_1");
		clickItem("xpath_Attribute_1_Add_Item_Button");
		selectDropDown("xpath_Attribute_2", "value_Attribute_2");
		clickItem("xpath_Attribute_2_Add_Item_Button");
		clickItem("xpath_Attribute_OK_Button");
		// waitForElement("xpath_To_Directory_Button");
		clickItem("xpath_To_Directory_Button");
		waitForElement("xpath_Search_Directory_Global_Tab");
		clickItem("xpath_Search_Directory_Global_Tab");
		typeInto("xpath_Search_Directory_Global_Tab_Group_Name", "value_Group_Name");
		typeInto("xpath_Search_Directory_Global_Tab_Family_Name", "value_Family_Name");

		clickItem("xpath_Search_Directory_Global_Tab_Search_Button");
		waitForElement("xpath_Search_Directory_CheckBox");
		clickItem("xpath_Search_Directory_CheckBox");
		clickItem("xpath_Search_Directory_To_Button");
		clickItem("xpath_Search_Directory_Global_Tab_OK_Button");
		clickItem("xpath_Send_Button");

		waitForElement("xpath_Mail_Number_Header");
		boolean result = veriftText("xpath_Mail_Number");
		if (result == true)
			Reporter.log("Pass: " + "Mail Sent Successfully" + "<br>", true);
		else
			Reporter.log("Pass: " + "Mail Sent Fail" + "<br>", true);
	}

	@AfterMethod public void tearDown() throws Exception { 
		driver.quit(); 
		}

}
