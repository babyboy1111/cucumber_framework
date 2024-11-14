package Steps;

import Base.Page;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.testng.asserts.SoftAssert;
import utils.FileName;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.testng.Assert.assertTrue;
import static utils.FileNameConstants.*;

public class Stepdefs {
    Page page = new Page();
    SoftAssert softAssert = new SoftAssert();
    @Given("The web land on Test Automation Practice page")
    public void theWebLandOnTestAutomationPracticePage() {
        page.setUp();
        page.driver.manage().window().maximize();

    }


    @And("I am enter my full name {string}")
    public void iAmEnterMyFullNameGhuyn(String string) {
        String id = "userName";
        page.ElementClick(TEXT_BOX,"id");
        page.Click_SendKey(id,string);
    }


    @Then("I should see {string} is displayed")
    public void iShouldSeeGhuynIsDisplayed(String string) {
        String firstElementText = page.GetText(UserName,"xpath");
        assertTrue(firstElementText.contains(string));
        page.driver.close();
    }


    @Then("I should see the {string} text is displayed")
    public void iShoulSeeTheYouHaveSelectedDesktopNotesCommandsTextIsDisplayed(String response) {
        String str = new String();
        for( String i : res) {
            str = str + page.GetText(i,"xpath");
        }
        System.out.println(str);
        assertTrue((str.replaceAll("\\s", "")).contains(response.replaceAll("\\s", "")));
        page.driver.close();
    }


    @And("I click twices on Double Click Me button")
    public void iClickTwicesOnDoubleClickMeButton() {
        page.doubleClick(DOUBLE_BUTTON);
    }

    @Then("I should see The {string} text will be displayed")
    public void iShouldSeeTheYouHaveDoneADoubleClickTextWillBeDisplayed(String response) {
        String message = page.GetText(DOUBLE_CLICK_MESSAGE,"xpath");
        assertTrue(message.replaceAll("\\s", "").equals(response.replaceAll("\\s", "")));
        page.tearDown();
    }


    @Then("I should see the home page is displayed")
    public void iShouldSeeTheHomePageIsDisplayed() {
        assertTrue(page.driver.getCurrentUrl().contains("https://demoqa.com"));
        page.driver.close();
    }

    @And("I click on Click Me button to open confirm box")
    public void iClickOnClickMeButtonToOpenConfirmBox() {
        page.ElementClick(ALERT_BOX,"xpath");
        page.ElementClick(CLICK_ME,"id");
    }

    @And("I click on OK button")
    public void iClickOnCancelButton() {
        Alert alert1 = page.driver.switchTo().alert();
        alert1.accept();
        // page.driver.switchTo().alert().accept();

    }

    @Then("I should see {string} message")
    public void iShouldSeeYouSelectedOkMessage(String response) {
        String message = page.GetText(CONFIRM_MESS,"id");
        assertTrue(message.replaceAll("\\s", "").equals(response.replaceAll("\\s", "")));
    }

    @When("I click on {string}")
    public void iClickOnElements(String string) {

        Gson gson = new Gson();

        FileName[] fileNames = null;
        try {
            FileReader reader = new FileReader("src/test/resources/testdata/fileName.json");
            fileNames = gson.fromJson(reader, FileName[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (FileName f : fileNames) {
            if(f.getName().equals(string)){
                System.out.println(f.getName());
                page.ElementClick(f.getLocator(), f.getType());
            }

        }
    }
}
