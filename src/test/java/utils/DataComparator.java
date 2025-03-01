package utils;

import model.VehicleDetails;
import org.testng.Assert;

public class DataComparator {

    /**
     * Compares the actual vehicle details retrieved from the website with the expected details from the output file.
     * This method asserts each attribute (make, model, year, value) individually.
     * If any attribute does not match, an AssertionError will be thrown with a descriptive message.
     *
     * @param expected The expected vehicle details loaded from the file.
     * @param actual The actual vehicle details retrieved from the web page.
     * @throws AssertionError if any of the details do not match.
     */
    public static void compareCarDetails(VehicleDetails expected, VehicleDetails actual) {
        Assert.assertEquals(actual.getMake(), expected.getMake(), "Make mismatch!");
        Assert.assertEquals(actual.getModel(), expected.getModel(), "Model mismatch!");
        Assert.assertEquals(actual.getYear(), expected.getYear(), "Year mismatch!");
        Assert.assertEquals(actual.getValue(), expected.getValue(), "Value mismatch!");
    }

}
