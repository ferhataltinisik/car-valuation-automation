package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.VehicleDetails;
import pages.CarDetailsReportPage;
import pages.HomePage;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsSteps extends BaseTest {
    private List<String> regNumbers;
    CarDetailsReportPage carDetailsReportPage;
    HomePage homePage;
    private final List<String> mismatches = new ArrayList<>();

    @After
    public void tearDown() {
        BaseTest.teardownDriver();
    }


    @Given("I have a file named {string} with vehicle registration numbers")
    public void i_have_a_file_named_with_vehicle_registration_numbers(String fileName) {
        regNumbers = FileReaderUtil.extractRegNumbers(fileName);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // Setup WebDriver and open the URL from config.properties
        setupDriver();
        String baseUrl = ConfigManager.getProperty("base.url");
        driver.get(baseUrl);

        // Initialize Page Objects
        homePage = new HomePage(driver);
    }

    @When("I search each vehicle registration on car valuation website")
    public void searchEachVehicle() {
        for (String regNumber : regNumbers) {
            driver.get(ConfigManager.getProperty("base.url"));  // Go to homepage for each car

            homePage = new HomePage(driver);
            homePage.searchCarByRegNumber(regNumber);

            carDetailsReportPage = new CarDetailsReportPage(driver);  // Load report page for this car
            VehicleDetails actualDetails = carDetailsReportPage.getCarDetails();

            VehicleDetails expectedDetails = FileReaderUtil.getExpectedDetails("car_output.txt", regNumber);

            try {
                DataComparator.compareCarDetails(expectedDetails, actualDetails);
            } catch (AssertionError e) {
                mismatches.add("Mismatch for " + regNumber + ": " + e.getMessage());
            }
        }
    }


    @Then("I should see all vehicle details matched correctly")
    public void verifyAllDetailsMatched() {
        if (mismatches.isEmpty()) {
            Log.pass("All vehicle details matched correctly.");
        } else {
            mismatches.forEach(System.err::println);
            throw new AssertionError("Test failed due to mismatched vehicle details.");
        }
    }

}
