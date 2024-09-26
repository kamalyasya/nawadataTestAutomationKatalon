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
def testData = TestDataFactory.findTestData('Data Files/dataTest_Login')

// Loop through rows
for (def row : (1..testData.getRowNumbers())) {
    // Set data for each iteration
    username = testData.getValue('USER', row)

    password = testData.getValue('PASS', row)

    WebUI.setText(findTestObject('Object Repository/Page_ObjctLogin/input_Username_txtUsername'), username)

    WebUI.setText(findTestObject('Object Repository/Page_ObjctLogin/input_Password_txtPassword'), password)

    WebUI.click(findTestObject('Object Repository/Page_ObjctLogin/span_Login'))

    // Verification Step
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ObjctLogin/div_The Username and Password fields are both required'), 
        2, FailureHandling.OPTIONAL)) {
        println("Login failed for user: $username")
    } else {
        println("Login succsess for user: $username")

        WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ObjctLogin/div_UserID  EngineerTest1'), 2, FailureHandling.OPTIONAL)
    }
}

