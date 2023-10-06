import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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

private TestObject getXpathOnColumn(String column) {
	String row = "//div[@role='rowgroup'][1]/div[@role='row']"
	String cell
	switch(column){
		case "First Name":
			cell = "${row}/div[@role='gridcell'][1]"
		break;
		case "Last Name":
			cell = "${row}/div[@role='gridcell'][2]"
		break;
		case "Age":
			cell = "${row}/div[@role='gridcell'][3]"
		break;
		case "Email":
			cell = "${row}/div[@role='gridcell'][4]"
		break;
		case "Salary":
			cell = "${row}/div[@role='gridcell'][5]"
		break;
		case "Department":
			cell = "${row}/div[@role='gridcell'][6]"
		break;
		default:
			cell = "//div[@class='action-buttons']/span/*[local-name()='svg']"
		break;
	}
	TestObject to = convertTestObjectfromXpath(cell)
	return to
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

WebUI.setText(convertTestObjectfromXpath("//input[@id='searchBox']"), search)

WebUI.click(convertTestObjectfromXpath("//div[@class='action-buttons']/span/*[local-name()='svg']"))

WebUI.verifyElementPresent(convertTestObjectfromXpath("//div[@id='registration-form-modal' and text()='Registration Form']"), 0)

TestData data = findTestData('Data Files/web tables')

def columns = data.getColumnNames()

for (column in columns) {
	String input = "1" + GlobalVariable[column]
	WebUI.setText(findTestObject('Object Repository/Robby/input text (id)',['label':column]),input)
	GlobalVariable[column] = input
}

WebUI.click(convertTestObjectfromXpath("//button[@id='submit']"))

WebUI.setText(convertTestObjectfromXpath("//input[@id='searchBox']"),GlobalVariable['firstName'])

for (column in columns) {
	String newData = WebUI.getText(getXpathOnColumn(data.getValue(column, 2)))
	WebUI.verifyMatch(GlobalVariable[column], newData, false)
}

WebUI.closeBrowser()






