import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementAttributeValueKeyword as WaitForElementAttributeValueKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.WaitForElementVisibleKeyword as WaitForElementVisibleKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://demoqa.com/')
WebUI.maximizeWindow()
WebUI.waitForPageLoad(2)

WebUI.scrollToElement(findTestObject('Object Repository/webtables_delete/menus', ['menu' : 'Elements']), 1)
WebUI.click(findTestObject('Object Repository/webtables_delete/menus', ['menu' : 'Elements']))

WebUI.scrollToElement(findTestObject('Object Repository/webtables_delete/sub_menus', ['sub_menu' : 'Web Tables']), 1)
WebUI.click(findTestObject('Object Repository/webtables_delete/sub_menus', ['sub_menu' : 'Web Tables']))

WebUI.scrollToElement(findTestObject('Object Repository/webtables_delete/delete_record_button', ['index' : index]), 1) 
String deletedName =  WebUI.getText(findTestObject('Object Repository/webtables_delete/firstname_locator', ['locator' : index]))

WebUI.delay(2)//to show data before deleted
WebUI.click(findTestObject('Object Repository/webtables_delete/delete_record_button', ['index' : index]))

boolean exist = WebUI.waitForElementVisible(findTestObject('Object Repository/webtables_delete/firstname_column', ['firstname' : deletedName]), 2, FailureHandling.OPTIONAL)
if (exist == false) {
        KeywordUtil.markPassed('PASSED, User ' + deletedName + ' successfully deleted')
} else {
        KeywordUtil.markErrorAndStop('FAILED, User ' + deletedName + ' not successfully deleted')
}

WebUI.closeBrowser()