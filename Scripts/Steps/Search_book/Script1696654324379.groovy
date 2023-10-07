import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementPresentKeyword
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.waitForElementPresent(findTestObject('Object Repository/demo_qa/book_store_application/ipt_field_id-var',
	[('field'):'searchBox']), 5)

WebUI.setText(findTestObject('Object Repository/demo_qa/book_store_application/ipt_field_id-var',
	[('field'):'searchBox']), searchbox)

WebUI.scrollToElement(findTestObject('Object Repository/demo_qa/book_store_application/ipt_field_id-var',
	[('field'):'searchBox']), 2, FailureHandling.OPTIONAL)

boolean result = WebUI.waitForElementPresent(findTestObject('Object Repository/demo_qa/txt_var',[('text'):expected]), 5, 
	FailureHandling.STOP_ON_FAILURE)

if (result) {
	
	KeywordUtil.markPassed('Searching Success')
	
}else {
	
	WebUI.scrollToElement(findTestObject
		('Object Repository/demo_qa/book_store_application/error_search'),2)
	
	String error = WebUI.getText(findTestObject
		('Object Repository/demo_qa/book_store_application/error_search'))
	
	WebUI.verifyMatch(error, expected_error, false)
	
	//KeywordUtil.markFailedAndStop(expected_error)	
	KeywordUtil.markPassed(expected_error)
}



	
	
	
	
	
	
	
	
	
