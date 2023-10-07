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

WebUI.waitForPageLoad(2)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/repository_mella/card_element'))

WebUI.click(findTestObject('Object Repository/repository_mella/tombol_web_tables_mel'))

WebUI.click(findTestObject('Object Repository/repository_mella/tombol_add'))

WebUI.setText(findTestObject('Object Repository/repository_mella/input_data_mel', ['isi':'firstName']), 'mel')

WebUI.setText(findTestObject('Object Repository/repository_mella/input_data_mel', ['isi':'lastName']), 'mel')

WebUI.setText(findTestObject('Object Repository/repository_mella/input_data_mel', ['isi':'userEmail']), 'mel@givmail.com')

WebUI.setText(findTestObject('Object Repository/repository_mella/input_data_mel', ['isi':'age']), '23')

WebUI.setText(findTestObject('Object Repository/repository_mella/input_data_mel', ['isi':'salary']), '100000000')

WebUI.setText(findTestObject('Object Repository/repository_mella/input_data_mel', ['isi':'department']), 'IT')

WebUI.click(findTestObject('Object Repository/repository_mella/tombol_submit_mel'))

if (WebUI.waitForElementPresent(findTestObject('Object Repository/repository_mella/verify_data'), 0)) {
	println('Success Insert Data')
}else {
	
	println('Failed Insert Data')
}

WebUI.closeBrowser()



