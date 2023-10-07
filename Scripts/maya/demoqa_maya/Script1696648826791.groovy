import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.remote.server.handler.MaximizeWindow as MaximizeWindow
import org.openqa.selenium.remote.server.handler.MaximizeWindow as Keys

WebUI.openBrowser(GlobalVariable.baseUrl)

WebUI.maximizeWindow()

WebUI.waitForElementClickable(findTestObject('bookstoreapp_btn'), 2)

WebUI.click(findTestObject('bookstoreapp_btn'))

WebUI.scrollToElement(findTestObject('Object Repository/login_btn_sidebar'), 2)

WebUI.delay(2)

WebUI.click(findTestObject('login_btn_sidebar'))

String username = GlobalVariable.userName

String password = GlobalVariable.password

WebUI.setText(findTestObject('Object Repository/input_username'), username)

WebUI.setEncryptedText(findTestObject('Object Repository/input_password'), password)

WebUI.click(findTestObject('login_page_btn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/verify_page_login'),5) //verify telah berhasil untuk login

WebUI.click(findTestObject('logout_btn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/verify_login'), 10) // Verify kembali ke halaman login

WebUI.closeBrowser()

