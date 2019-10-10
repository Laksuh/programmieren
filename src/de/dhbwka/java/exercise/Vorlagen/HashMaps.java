package de.dhbwka.java.exercise.Vorlagen;

import java.util.HashMap;

public class HashMaps {

    public static void main(String[] args){
        new HashMaps();
    }

    public HashMaps(){
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        System.out.println(capitalCities);
        System.out.println(capitalCities.get("England"));
        capitalCities.remove("England");

        //FOR EACH - PRINT KEYS
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }

        //FOR EACH - PRINT VALUES
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }
        //FOR EACH - PRINT KEYS + VALUES
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }

        capitalCities.clear();
        System.out.println(capitalCities);
        System.out.println(capitalCities.size());

        //OTHER TYPES
        // Create a HashMap object called people
        HashMap<String, Integer> people = new HashMap<String, Integer>();


        // Add keys and values (Name, Age)
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

        for (String i : people.keySet()) {
            System.out.println("key: " + i + " value: " + people.get(i));
        }

    }


}
