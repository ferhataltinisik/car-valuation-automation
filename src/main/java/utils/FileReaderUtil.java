package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderUtil {

    private static final Pattern REG_PATTERN = Pattern.compile("\\b[A-Z0-9]{2,4}\\s?[A-Z0-9]{3}\\b");

    public static List<String> extractRegNumbers(String fileName) {
        List<String> regNumbers = new ArrayList<>();
        try {
            Path path = Paths.get("src/test/resources/testdata/" + fileName);
            String content = Files.readString(path);

            Matcher matcher = REG_PATTERN.matcher(content);
            while (matcher.find()) {
                regNumbers.add(matcher.group());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
        return regNumbers;
    }

//    public static VehicleDetails getExpectedDetails(String fileName, String regNumber) {
//
//    }
}
