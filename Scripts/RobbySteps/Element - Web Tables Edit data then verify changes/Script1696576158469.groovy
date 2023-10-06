import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.GetText

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

private String getTextOnColumn(String column) {
	String row = "//div[@role='rowgroup'][${num}]/div[@role='row']"
	String col = row
	column == "First Name" ?: col + "/div[@role='gridcell'][1]"
	column == "Last Name" ?: col + "/div[@role='gridcell'][2]"
	column == "Age" ?: col + "/div[@role='gridcell'][3]"
	column == "Email" ?: col + "/div[@role='gridcell'][4]"
	column == "Salary" ?: col + "/div[@role='gridcell'][5]"
	column == "Department" ?: col + "/div[@role='gridcell'][6]"
	
	return WebUI.getText(convertTestObjectfromXpath(col))
}

private TestObject convertTestObjectfromXpath(String xpath) {
	TestObject tObj = new TestObject()

	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj
}

WebUI.openBrowser("https://demoqa.com/")

WebUI.maximizeWindow()

WebUI.scrollToElement(findTestObject('Object Repository/Robby/menu (menu)',['menu':'Elements']), 0)

WebUI.click(findTestObject('Object Repository/Robby/menu (menu)',['menu':'Elements']))

WebUI.verifyElementPresent(findTestObject('Object Repository/Robby/main header element'), 30)

WebUI.scrollToElement(findTestObject('Object Repository/Robby/submenu (submenu)',['submenu':'Web Tables']), 0)

WebUI.click(findTestObject('Object Repository/Robby/submenu (submenu)',['submenu':'Web Tables']))

WebUI.setText(convertTestObjectfromXpath("//input[@id='searchBox']"), getTextOnColumn("Email"))


