import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

WebUI.openBrowser("https://demoqa.com/")
WebUI.maximizeWindow()
WebUI.waitForPageLoad(2)
WebUI.scrollToElement(findTestObject("Object Repository/halaman_depan",[("homepage"):"Book Store Application"]), 2)
WebUI.click(findTestObject("Object Repository/halaman_depan",[("homepage"):"Book Store Application"]))
List<WebElement> titles = WebUI.findWebElements(findTestObject('Object Repository/books_page/books'), 10)
for(int i=1; i<=titles.size(); i++) {
	TestObject titleTO = findTestObject("Object Repository/books_page/title_dynamic_by_index",[("index"):i])
	WebUI.scrollToElement(titleTO, 2)
	def title = WebUI.getText(titleTO)
	WebUI.click(titleTO)
	WebUI.verifyTextPresent(title, false)
	WebUI.back()
}
WebUI.closeBrowser()

