package main;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String> data = Main.readCSVFile(args[0]);

        CookieFinder cf = new CookieFinder(data);

        List<String> mostActiveCookies = cf.findMostActiveCookie(args[2]);

        for(String cookie: mostActiveCookies) {
            System.out.println(cookie);
        }

    }

    public static List<String> readCSVFile(String filePath) throws Exception {

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

}
