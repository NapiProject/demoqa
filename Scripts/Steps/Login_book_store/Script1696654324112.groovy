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

WebUI.waitForElementPresent(findTestObject('Object Repository/demo_qa/txt_main_header_txt-var',
	[('nama_main_header'):'Book Store']), 5)

WebUI.click(findTestObject('Object Repository/demo_qa/btn_id_var',
	[('button'):'login']))

WebUI.waitForElementPresent(findTestObject('Object Repository/demo_qa/txt_main_header_txt-var',
	[('nama_main_header'):'Login']), 5)

WebUI.scrollToElement(findTestObject('Object Repository/demo_qa/book_store_application/ipt_field_id-var',
	[('field'):'userName']),2)

WebUI.setText(findTestObject('Object Repository/demo_qa/book_store_application/ipt_field_id-var',
	[('field'):'userName']), username)

WebUI.setEncryptedText(findTestObject('Object Repository/demo_qa/book_store_application/ipt_field_id-var',
	[('field'):'password']), password)

WebUI.scrollToElement(findTestObject('Object Repository/demo_qa/btn_id_var',
	[('button'):'login']),2)

WebUI.click(findTestObject('Object Repository/demo_qa/btn_id_var',
	[('button'):'login']))

WebUI.waitForElementPresent(findTestObject('Object Repository/demo_qa/book_store_application/lbl_username_value-var',
	[('username_label'):username]), 5)










