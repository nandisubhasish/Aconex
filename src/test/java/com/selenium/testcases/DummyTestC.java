package com.selenium.testcases;

import org.sikuli.script.SikuliException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.selenium.base.BaseTest;

public class DummyTestC extends BaseTest{
 		
		@Test
		public void testC() {
			
			openBrowser("browser");
			navigate("appurl");
			typeInto("xpath_LoginName", "value_LoginName2");
			typeInto("xpath_Password", "value_Password2");
			clickItem("xpath_LogInButton");
			waitForPageToLoad();
			waitForElement("xpath_NavBar_Documents_Button");
			clickItem("xpath_NavBar_Documents_Button");
			clickItem("xpath_Navbar_Panel_Menu_UploadNewDocument_Item");
			waitForPageToLoad();
			managingFrames("xpath_Upload_Document_DocumentNumber");
			clickItem("xpath_Upload_Document_DocumentNumber");
			typeInto("xpath_Upload_Document_Revision", "value_Upload_Document_Revision");
			typeInto("xpath_Upload_Document_Title", "value_Upload_Document_Title");
			selectDropDown("xpath_Upload_Document_Type", "value_Upload_Document_Type");
			selectDropDown("xpath_Upload_Document_Status", "value_Upload_Document_Status");
			selectDropDown("xpath_Upload_Document_Discipline", "value_Upload_Document_Discipline");
			typeInto("xpath_Upload_Document_RevisionDate","value_Upload_Document_RevisionDate");
			clickItem("path_Upload_Document_Choose_Source_Button");
			clickItem("xpath_Upload_Document_Upload_File_From_PC_Option");
			
		   try {
			uploadWindowsDialog("fileAddressToUpload");
		} catch (SikuliException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   waitForPageToLoad();
		   clickItem("xpath_Upload_Document_Upload_Upload_Button");
		   waitForElement("xpath_Upload_Document_Success_Panel_Button");
		   clickItem("xpath_Upload_Document_Success_Panel_Button");
		   
 
		   switchFrameToDefault();
		   waitForPageToLoad();
		   waitForElement("xpath_NavBar_Documents_Button");
		   clickItem("xpath_NavBar_Documents_Button");
		   clickItem("xpath_Documents_Document_Register");
		   waitForPageToLoad();
		   
		   
		   managingFrames("xpath_Document_Register_Search_Button");
		   typeInto("xpath_Document_Register_Search_InputBox", "value_Upload_Document_Title");
		   clickItem("xpath_Document_Register_Search_Button");
		   clickItem("xpath_Document_Register_Save_Search_As");
		   typeInto("xpath_Document_Register_Save_Search_Name", "Search_Name_"+GetDate(),"Heelo");
		   clickItem("xpath_Document_Register_Save_Search_Save_Button");
		   findElement("xpath_Document_Register_Search_Result");
		   
			
		}
		
		@AfterMethod public void tearDown() throws Exception { 
			driver.quit(); 
			}


}
