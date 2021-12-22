package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class CookieFinder {

    /**
     * Field representing each line of data in the given CSV file
     */
    private List<String> data;


    /**
     * Constructor for the CookieFinder class
     * @param data information from the CSV file representing as a list of Strings
     */
    public CookieFinder(List<String> data){
        this.data = data;

    }

    /**
     * Returns the list of Strings stored in the data field
     * @return the list of Strings where each line represents a data entry from the source CSV file
     */
    public List<String> getData() {
        return this.data;
    }

    /**
     * Finds the most active cookies given a data set
     * @param date A string representing the desired date that the most active cookies should be from
     * @return A list of the most active cookies represented as a list of Strings
     * @throws Exception
     */
    public List<String> findMostActiveCookie(String date) throws Exception {
        Map<String, Integer> cookieCounts = new HashMap<>();
        int maxCount = 0;

        for(String line: data) {

            String[] lineData = line.split(",");

            if(lineData.length == 2) {
                if(lineData[1].substring(0, lineData[1].indexOf("T")).equals(date)) {
                    if(cookieCounts.containsKey(lineData[0])) {
                        cookieCounts.put(lineData[0], cookieCounts.get(lineData[0]) + 1);
                    }
                    else {
                        cookieCounts.put(lineData[0], 1);
                    }

                    if(cookieCounts.get(lineData[0]) > maxCount) {
                        maxCount = cookieCounts.get(lineData[0]);
                    }
                }

            }
            else {
                throw new Exception("Improper CSV file format");
            }

        }

        List<String> mostActiveCookies = new ArrayList<>();
        for(String cookie: cookieCounts.keySet()) {
            if(cookieCounts.get(cookie) == maxCount) {
                mostActiveCookies.add(cookie);
            }
        }
        return mostActiveCookies;
    }
}
