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

WebUI.openBrowser('https://demoqa.com/', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('Object Repository/menu_book_store_application'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/btn_login'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/input_form',['input' : 'userName']), GlobalVariable.username, FailureHandling.STOP_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('Object Repository/input_form',['input' : 'password']),GlobalVariable.password, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/btn_login'), FailureHandling.STOP_ON_FAILURE)


if(WebUI.verifyElementVisible(findTestObject('Object Repository/text_wording_error')) == true) {
	
	WebUI.verifyElementText(findTestObject('Object Repository/text_wording_error'), 'Invalid username or password!', FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.closeBrowser()
