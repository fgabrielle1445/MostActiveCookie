package test;

import org.junit.jupiter.api.*;
import main.CookieFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CookieFinderTest {

    CookieFinder cf1 = null;

    private List<String> readCSVFile(String filePath) throws Exception {

        //parsing a CSV file into Scanner class constructor

        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        List<String> data = new ArrayList<>();

        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            data.add(sc.next().trim()); //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner

        return data;
    }

}


