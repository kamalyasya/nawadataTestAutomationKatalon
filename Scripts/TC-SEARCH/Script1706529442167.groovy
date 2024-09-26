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
def testData = TestDataFactory.findTestData('Data Files/dataTest_Search')

// Loop through rows
for (def row : (1..testData.getRowNumbers())) {
    // Set data for each iteration
    employeeID = testData.getValue('EMPLOYEE_ID', row)

    Thread.sleep(1000)
	WebUI.delay(3)
	WebUI.mouseOver(findTestObject('Object Repository/Page_ObjctSearch/ObjctAdvancedSearch'), FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctAdvancedSearch'), 1)
	
	Thread.sleep(1000)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctFilterSearch'), FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctFilterEmployeID'), 1)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctSearchContain'), FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctSelectContain'), 1)
	
	WebUI.setText(findTestObject('Object Repository/Page_ObjctSearch/ObjctInput'), employeeID, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctBtnAdd'), 1)
	WebUI.click(findTestObject('Object Repository/Page_ObjctSearch/ObjctButtonFilter'), 1)
		
	// Verification Step
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ObjctSearch/ObjctAssertionVerif'), 
        2, FailureHandling.OPTIONAL)) {
		WebUI.click(('Object Repository/Page_ObjctSearch/ObjctClearFilterAdvance'), FailureHandling.STOP_ON_FAILURE)
    } else {
        WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ObjctSearch/ObjctReacordEmpety'), 2, FailureHandling.OPTIONAL)
		WebUI.click(('Object Repository/Page_ObjctSearch/ObjctClearFilterAdvance'), FailureHandling.STOP_ON_FAILURE)
    }
	
}

