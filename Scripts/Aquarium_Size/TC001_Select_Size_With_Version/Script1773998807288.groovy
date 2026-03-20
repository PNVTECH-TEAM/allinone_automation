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

// 1. LOGIN
WebUI.callTestCase(findTestCase('Test Cases/Login_Function/TC001_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. NAVIGATE TO 3D AQUARIUM
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_Create3D'))

// Set viewport mobile
WebUI.setViewPortSize(844, 390)
// Verify correct URL
WebUI.verifyMatch(
	WebUI.getUrl(),
	'http://localhost:5001/aquarium3d',
	false
)


// 3. OPEN SETTINGS PANEL
WebUI.waitForPageLoad(500)
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_Setting'))

// Wait + verify UI loaded
WebUI.waitForElementVisible(findTestObject('Object Repository/Aquarium_Size/hd_Aquarium3D'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Aquarium_Size/hd_Aquarium3D'), 'AQUARIUM 3D')

// 4. SELECT AQUARIUM SIZE
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_LargeSize'))

// Scroll to Apply button and apply size
WebUI.scrollToElement(findTestObject('Object Repository/Aquarium_Size/btn_ApplySize'), 10)
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_ApplySize'))

// 5. SELECT DESIGN VERSION
WebUI.verifyElementText(findTestObject('Object Repository/Aquarium_Size/hd_DesignVersion'), 'Select Your Design Version')
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_VersionTank'))

// 6. CLOSE SETTINGS PANEL
WebUI.waitForElementVisible(findTestObject('Object Repository/Aquarium_Size/btn_ApplySize'),10)
WebUI.scrollToElement(findTestObject('Object Repository/Aquarium_Size/btn_CloseAquarium3D'), 10)
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_CloseAquarium3D'))

// 7. SHOW HUD
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_ShowHUD'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Aquarium_Size/txt_FishNumber'), 10)

// 8. VERIFY HUD DATA
WebUI.verifyElementText(findTestObject('Object Repository/Aquarium_Size/txt_FishNumber'), 1)
WebUI.verifyElementText(findTestObject('Object Repository/Aquarium_Size/txt_PlantsNumber'), 2)
WebUI.verifyElementText(findTestObject('Object Repository/Aquarium_Size/txt_RocksNumber'), 0)
WebUI.verifyElementText(findTestObject('Object Repository/Aquarium_Size/txt_TotalItems'), 3)

// 9. HIDE HUD
WebUI.click(findTestObject('Object Repository/Aquarium_Size/btn_HideHUD'))
