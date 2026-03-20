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

String baseUrl = GlobalVariable.baseUrlUpload

String glbPath = 'C:\\Users\\admin\\Downloads\\redcoral.glb'
String imagePath = 'C:\\Users\\admin\\Downloads\\fish.jpg'

// OPEN SCREEN
WebUI.navigateToUrl(baseUrl)

WebUI.setViewPortSize(844, 390)

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_ExplorerToggle'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Upload_GLB_File/hd_AquaticExplorer'))

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_OpenUpload'))

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_ExplorerToggleActive'))

//Verify
WebUI.verifyElementVisible(findTestObject('Object Repository/Upload_GLB_File/hd_TitleUploadFile'))

// ===== UPLOAD GLB =====
TestObject inputGLB = findTestObject('Object Repository/Upload_GLB_File/btn_UploadGLB')
def el1 = WebUI.findWebElement(inputGLB)
WebUI.executeJavaScript("arguments[0].style.display='block';", Arrays.asList(el1))

WebUI.uploadFile(inputGLB, glbPath)

// verify bằng value
WebUI.verifyMatch(
    WebUI.getAttribute(findTestObject('Object Repository/Upload_GLB_File/txt_AssetName'), 'value'),
    'redcoral',
    false
)

// ===== UPLOAD IMAGE =====
TestObject inputImg = findTestObject('Object Repository/Upload_GLB_File/btn_UploadPreviewImage')
def el2 = WebUI.findWebElement(inputImg)
WebUI.executeJavaScript("arguments[0].style.display='block';", Arrays.asList(el2))

WebUI.uploadFile(inputImg, imagePath)

// verify tên image
WebUI.verifyElementText(
    findTestObject('Object Repository/Upload_GLB_File/txt_ImageFileName'),
    'fish.jpg'
)

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_UploadAsset'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Upload_GLB_File/msg_UploadAssetSuccess'), 20)