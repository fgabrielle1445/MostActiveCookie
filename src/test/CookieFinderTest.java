package test;

import org.junit.jupiter.api.*;
import main.CookieFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class CookieFinderTest {

    List<String> file1Data;
    List<String> file2Data;
    List<String> file3Data;

    {
        try {
            file1Data = readCSVFile("src/test/sampleCSVFiles/sampleCookieFile1.csv");
            file2Data = readCSVFile("src/test/sampleCSVFiles/sampleCookieFile2.csv");
            file3Data = readCSVFile("src/test/sampleCSVFiles/sampleCookieFile3.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CookieFinder cf1 = new CookieFinder(file1Data);
    CookieFinder cf2 = new CookieFinder(file2Data);
    CookieFinder cf3 = new CookieFinder(file3Data);

    // Single most active cookie for a given day
    @Test
    public void singleMostActiveCookie() throws Exception {
        List<String> result = cf1.findMostActiveCookie("2018-12-09");
        assertArrayEquals(new String[]{"AtY0laUfhglK3lC7"}, listToArray(result));
    }

    // More than one most active cookies for a given day
    @Test
    public void multipleMostActiveCookies() throws Exception {
        List<String> result = cf2.findMostActiveCookie("2018-12-09");
        assertArrayEquals(new String[]{"AtY0laUfhglK3lC7", "SAZuXPGUrfbcn5UA"}, listToArray(result));

    }

    // No active cookies on that day
    @Test
    public void noActiveCookies() throws Exception {
        List<String> result  = cf1.findMostActiveCookie("2021-12-21");
        assertArrayEquals(new String[]{}, listToArray(result));
    }

    // Invalid CSV format
    @Test
    public void invalidCSV() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> cf3.findMostActiveCookie("2018-12-09"));

        String expectedMessage = "Improper CSV file format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Helper function to read CSV files for the testing suite
     * @param filePath String representing the location of the CSV file
     * @return A list of strings representing each line of data in the CSV file
     * @throws Exception
     */
    private List<String> readCSVFile(String filePath) throws Exception {

        // Parse a CSV file using the Scanner constructor

        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        List<String> data = new ArrayList<>();

        // Set the delimiter pattern (where the file splits)
        sc.useDelimiter("\n");
        while (sc.hasNext())
        {
            // Add each data line
            data.add(sc.next().trim());
        }
        // Closes the scanner
        sc.close();

        return data;
    }

    public String[] listToArray(List<String> list) {
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }

}


