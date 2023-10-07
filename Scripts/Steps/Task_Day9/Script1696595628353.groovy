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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://demoqa.com/buttons')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(5)

WebUI.doubleClick(findTestObject('Object Repository/task_demoqa_button/button_demoqa',['click':'doubleClickBtn']), FailureHandling.STOP_ON_FAILURE)

WebUI.rightClick(findTestObject('Object Repository/task_demoqa_button/button_demoqa',['click':'rightClickBtn']), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/task_demoqa_button/dynamic_button'), FailureHandling.STOP_ON_FAILURE)

Boolean doubleclick = WebUI.waitForElementVisible(findTestObject('Object Repository/task_demoqa_button/verify_doubleclick'), 2, FailureHandling.OPTIONAL)

Boolean rightclick = WebUI.waitForElementVisible(findTestObject('Object Repository/task_demoqa_button/verify_rightclick'), 2, FailureHandling.OPTIONAL)

Boolean dynamic = WebUI.waitForElementVisible(findTestObject('Object Repository/task_demoqa_button/verify_click'), 2, FailureHandling.OPTIONAL)
 
if (doubleclick == true) {
	String click1 = WebUI.getText(findTestObject('Object Repository/task_demoqa_button/verify_doubleclick'))
	WebUI.verifyMatch(click1, message, false)
}
 if (rightclick == true){
	String click2 = WebUI.getText(findTestObject('Object Repository/task_demoqa_button/verify_rightclick'))
	WebUI.verifyMatch(click2, message2, false)
}
if (dynamic == true){
	String click3 = WebUI.getText(findTestObject('Object Repository/task_demoqa_button/verify_click'))
	WebUI.verifyMatch(click3, message3, false)
}
else {
	KeywordUtil.markError('message not match')
}


WebUI.delay(5)

WebUI.closeBrowser()