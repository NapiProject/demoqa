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
import org.apache.commons.lang3.StringUtils

WebUI.openBrowser('https://demoqa.com/')

WebUI.waitForPageLoad(2)

WebUI.scrollToElement(findTestObject('Element_Text_Box/Elements'), 0)

WebUI.click(findTestObject('Element_Text_Box/Elements'))

WebUI.click(findTestObject('Element_Text_Box/Text_Box'))

WebUI.setText(findTestObject('Element_Text_Box/Full_Name'), name)

WebUI.setText(findTestObject('Element_Text_Box/Email'), email)

WebUI.setText(findTestObject('Element_Text_Box/Current_Address'), current)

WebUI.setText(findTestObject('Element_Text_Box/Permanent_Address'), permanent)

WebUI.scrollToElement(findTestObject('Element_Text_Box/Button_Submit'), 2)

WebUI.click(findTestObject('Element_Text_Box/Button_Submit'))

String hasilname = WebUI.getText(findTestObject("Object Repository/Element_Text_Box/result",[("result"):"name"]))
String hasilemail = WebUI.getText(findTestObject("Object Repository/Element_Text_Box/result",[("result"):"email"]))
String hasilcurrent = WebUI.getText(findTestObject("Object Repository/Element_Text_Box/result",[("result"):"currentAddress"]))
String hasilpermanent = WebUI.getText(findTestObject("Object Repository/Element_Text_Box/result",[("result"):"permanentAddress"]))

String hasilnames = StringUtils.substringAfter(hasilname,"Name:" )
String hasilemails = StringUtils.substringAfter(hasilemail,"Email:" )
String hasilcurrents = StringUtils.substringAfter(hasilcurrent,"Current Address :" )
String hasilpermanents = StringUtils.substringAfter(hasilpermanent,"Permananet Address :" )

WebUI.verifyMatch(name, hasilnames, false)
WebUI.verifyMatch(email, hasilemails, false)
WebUI.verifyMatch(current, hasilcurrents, false)
WebUI.verifyMatch(permanent, hasilpermanents, false)
