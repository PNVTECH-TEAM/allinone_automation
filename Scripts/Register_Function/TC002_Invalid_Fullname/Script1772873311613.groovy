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

String baseUrl = GlobalVariable.baseUrlRegister

WebUI.openBrowser('')

WebUI.navigateToUrl(baseUrl)

WebUI.setText(findTestObject('Object Repository/Register_Function/txt_FullName'), 'Trần Thanh Nguyệt1234')

WebUI.setText(findTestObject('Object Repository/Register_Function/txt_Email'), 'changcoor7@gmail.com')

WebUI.setText(findTestObject('Object Repository/Register_Function/txt_Password'), 'Password123@')

WebUI.click(findTestObject('Object Repository/Register_Function/btn_Register'))

// Verify Error FullName
WebUI.verifyElementText(
	findTestObject('Object Repository/Register_Function/err_FullName'),
	'Full name cannot contain numbers or special characters. Please enter letters only'
)

WebUI.closeBrowser()