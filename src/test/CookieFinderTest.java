package test;

import org.junit.jupiter.api.*;
import main.CookieFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CookieFinderTest {

    List<String> file1Data;

    {
        try {
            file1Data = readCSVFile("src/test/sampleCSVFiles/sampleCookieFile1.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CookieFinder cf1 = new CookieFinder(file1Data);

    @Test
    public void findFile() throws Exception {
        System.out.println(readCSVFile("src/test/sampleCSVFiles/sampleCookieFile1.csv"));
        System.out.println(cf1.findMostActiveCookie("2018-12-09"));
    }

    private List<String> readCSVFile(String filePath) throws Exception {

        //parsing a CSV file into Scanner class constructor

        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        List<String> data = new ArrayList<>();

        sc.useDelimiter("\n");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            data.add(sc.next().trim()); //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner

        return data;
    }

}


