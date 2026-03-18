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

WebUI.callTestCase(findTestCase('Test Cases/Login_Function/TC001_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

String baseUrl = GlobalVariable.baseUrlUpload

// Upload file
String filePath = 'C:\\Users\\admin\\Downloads\\redcoral.glb'


WebUI.setViewPortSize(844, 390)

WebUI.navigateToUrl(baseUrl)

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_ExplorerToggle'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Upload_GLB_File/hd_AquaticExplorer'))

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_OpenUpload'))

WebUI.click(findTestObject('Object Repository/Upload_GLB_File/btn_ExplorerToggleActive'))

//Verify
WebUI.verifyElementVisible(findTestObject('Object Repository/Upload_GLB_File/hd_TitleUploadFile'))

//Upload
TestObject inputGLB = findTestObject('Object Repository/Upload_GLB_File/btn_UploadGLB')
def element = WebUI.findWebElement(inputGLB)

// B3: remove hidden
WebUI.executeJavaScript("arguments[0].style.display='block';", Arrays.asList(element))

// B4: upload file
WebUI.uploadFile(inputGLB, filePath)

// ===== VERIFY =====
WebUI.verifyMatch(
    WebUI.getAttribute(findTestObject('Object Repository/Upload_GLB_File/txt_AssetName'), 'value'),
    'redcoral',
    false
)