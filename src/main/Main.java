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
            System.out.println(sc.next());
            data.add(sc.next().trim()); //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner

        return data;
    }

}
