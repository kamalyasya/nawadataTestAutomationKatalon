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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

// Load test data
def testData = TestDataFactory.findTestData('Data Files/daaTest_Emp')

// Loop through rows
for (def row : (1..testData.getRowNumbers())) {
    // Set data for each iteration
    EMPLOYEE_ID = testData.getValue('EMPLOYEE_ID', row)
    EMPLOYEE_NAME = testData.getValue('EMPLOYEE NAME', row)
	DATE_BIRTH = testData.getValue('DATE BIRTH', row)
	IS_MERRIED = testData.getValue('IS MERRIED', row)
	DISTRICT = testData.getValue('DISTRICT', row)
	MULTI_DISTRICT  = testData.getValue('MULTI DISTRICT ', row)
	
	Thread.sleep(1000)
	WebUI.click(findTestObject('Object Repository/Page_AddNewRecord/ObjctAddNewRecords'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/Page_AddNewRecord/ObjctEmpID'), EMPLOYEE_ID, FailureHandling.STOP_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_AddNewRecord/ObjctEmpName'), EMPLOYEE_NAME, FailureHandling.STOP_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_AddNewRecord/ObjctDateBirth'), DATE_BIRTH, FailureHandling.STOP_ON_FAILURE)
	if (IS_MERRIED == 'YES') {
    WebUI.click(findTestObject('Object Repository/Page_YourPage/YesButton'))
	} else (IS_MERRIED == 'NO'){
    WebUI.click(findTestObject('Object Repository/Page_YourPage/NoButton'))
	}
	WebUI.setText(findTestObject('Object Repository/Page_AddNewRecord/ObjctInputDistrict'), DISTRICT, FailureHandling.STOP_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_AddNewRecord/ObjctMultiDistrict'), MULTI_DISTRICT, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_AddNewRecord/ObjctSave'), FailureHandling.STOP_ON_FAILURE)
}

