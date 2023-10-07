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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://demoqa.com/')

WebUI.maximizeWindow()

WebUI.scrollToElement(findTestObject('Object Repository/Main Page/card_elements'), 5)

WebUI.click(findTestObject('Object Repository/Main Page/card_elements'))

WebUI.scrollToElement(findTestObject('Object Repository/Elements Page/menu_radio', ['option' : opt]), 5)

WebUI.click(findTestObject('Object Repository/Elements Page/menu_radio', ['option' : 'Radio Button']))

WebUI.check(findTestObject('Object Repository/Elements Page/radio_button_elements', ['radio': opt_radio]))

String text = WebUI.getText(findTestObject('Object Repository/Elements Page/text_result'))

println(text)

WebUI.verifyMatch(text, res_text, false)
	
WebUI.closeBrowser()
