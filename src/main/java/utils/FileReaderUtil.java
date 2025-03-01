package utils;

import model.VehicleDetails;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderUtil {

    private static final Map<String, VehicleDetails> expectedDetailsMap = new HashMap<>();


    /**
     * Reads vehicle registration numbers from a file.
     * Assumes the first line is a header (like VARIANT_REG), so it skips it.
     *
     * @param fileName The name of the file under /resources/testdata
     * @return List of vehicle registration numbers
     */
    public static List<String> extractRegNumbers(String fileName) {
        List<String> regNumbers = new ArrayList<>();
        Path filePath = Path.of("src/test/resources/testdata/" + fileName);

        try {
            List<String> lines = Files.readAllLines(filePath);

            // Skip the first line if it's a header
            for (int i = 1; i < lines.size(); i++) {
                String regNumber = lines.get(i).trim();
                if (!regNumber.isEmpty()) {
                    regNumbers.add(regNumber);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
        return regNumbers;
    }


    /**
     * Reads vehicle details from car_output.txt and stores in a map for quick lookup.
     * @param fileName The output file name.
     */
    public static void loadExpectedDetails(String fileName) {
        Path filePath = Path.of("src/test/resources/testdata/" + fileName);

        try {
            List<String> lines = Files.readAllLines(filePath);

            // Skip header line (first line)
            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",", -1);
                if (parts.length < 4) {
                    throw new IllegalArgumentException("Invalid data format in file: " + fileName);
                }

                String regNumber = parts[0].trim();
                String make = parts[1].trim();
                String model = parts[2].trim();
                String year = parts[3].trim();

                VehicleDetails details = new VehicleDetails(make, model, year, "");
                expectedDetailsMap.put(regNumber, details);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }

    /**
     * Retrieves expected vehicle details for a given registration number.
     * @param fileName Name of the output file (only needed for first-time load).
     * @param regNumber Registration number to fetch details for.
     * @return VehicleDetails object with expected make, model, and year.
     */
    public static VehicleDetails getExpectedDetails(String fileName, String regNumber) {
        if (expectedDetailsMap.isEmpty()) {
            loadExpectedDetails(fileName);
        }

        VehicleDetails details = expectedDetailsMap.get(regNumber);
        if (details == null) {
            throw new IllegalArgumentException("No expected details found for reg number: " + regNumber);
        }
        return details;
    }
}
