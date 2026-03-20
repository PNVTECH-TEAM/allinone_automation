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

// LOGIN
WebUI.callTestCase(findTestCase('Test Cases/Login_Function/TC001_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// Path Image
String imagePath = 'C:\\Users\\admin\\Downloads\\fishcheck.jpg'

// Navigate
WebUI.click(findTestObject('Object Repository/AI_Fish_Doctor/btn_CheckFish'))
WebUI.verifyElementText(findTestObject('Object Repository/AI_Fish_Doctor/hd_FishTankHealth'), 'Fish Tank Health')

WebUI.click(findTestObject('Object Repository/AI_Fish_Doctor/btn_StartCheck'))
WebUI.verifyElementText(findTestObject('Object Repository/AI_Fish_Doctor/hd_AIVision'), 'AI Vision')

// Upload image
WebUI.uploadFile(findTestObject('Object Repository/AI_Fish_Doctor/btn_UploadGallery'), imagePath)

// Input symptoms
WebUI.setText(findTestObject('Object Repository/AI_Fish_Doctor/txa_DescribleAdditionalSymptoms'), 
'White cotton-like patches appear on the body, fins, or mouth')

// Verify Scan enabled
WebUI.verifyElementClickable(findTestObject('Object Repository/AI_Fish_Doctor/btn_AIVisionScanEnabled'))
