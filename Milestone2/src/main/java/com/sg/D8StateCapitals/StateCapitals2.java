package com.sg.D8StateCapitals;

import com.sg.D8UserIO.ImplementsUserIO;
import java.util.HashMap;

public class StateCapitals2 {
    public static void main(String[] args) {
        HashMap<String,Capital> capitals = new HashMap();
        assignCapitals(capitals);
        
        /* Print all capitals
        for (String state : capitals.keySet()){
            int lenState = Math.min(state.length(),15);
            int lenCapital = Math.min(capitals.get(state).getName().length(),15);
            System.out.println(
                      state + printXSpaces(15-lenState)+"| "
                    + capitals.get(state).getName() + printXSpaces(15-lenCapital)+"| "
                    + capitals.get(state).getArea() + " | "
                    + capitals.get(state).getPopulation());
        }*/
        
        ImplementsUserIO UIO = new ImplementsUserIO();
        int minPop = UIO.getInt("Please enter the minimum population desired.");
        int numPrinted = 0;
        
        System.out.println("\n     STATE      |     CAPITAL     | SQFT  | POPULATION");
        // Print capitals above a certain population
        for (String state : capitals.keySet()){
            if (capitals.get(state).getPopulation() >= minPop){
                int lenState = Math.min(state.length(),15);
                int lenCapital = Math.min(capitals.get(state).getName().length(),15);
                System.out.println(
                          state + printXSpaces(15-lenState)+"| "
                        + capitals.get(state).getName() + printXSpaces(15-lenCapital)+"| "
                        + capitals.get(state).getArea() + " | "
                        + capitals.get(state).getPopulation());
                numPrinted++;
            }
        }
        if(numPrinted==0){
            System.out.println("\n- - - No capitals have a pop greater than "+minPop+" - - -");
        }
    }
    
    public static void assignCapitals(HashMap capitals){
        capitals.put("Alabama", new Capital("Montgomery",155.4,205764));
        capitals.put("Alaska", new Capital("Juneau",2716.7,31275));
        capitals.put("Arizona", new Capital("Phoenix",474.9,1445632));
        capitals.put("Arkansas", new Capital("Little Rock",116.2,193524));
        capitals.put("California", new Capital("Sacramento",97.2,466488));
        capitals.put("Colorado", new Capital("Denver",153.4,600158));
        capitals.put("Connecticut", new Capital("Hartford",17.3,124775));
        capitals.put("Delaware", new Capital("Dover",22.4,36047));
        capitals.put("Florida", new Capital("Tallahassee",95.7,181412));
        capitals.put("Georgia", new Capital("Atlanta",131.7,420003));
        capitals.put("Hawaii", new Capital("Honolulu",85.7,337256));
        capitals.put("Idaho", new Capital("Boise",63.8,205671));
        capitals.put("Illinois", new Capital("Springfield",54,116250));
        capitals.put("Indiana", new Capital("Indianapolis",361.5,829718));
        capitals.put("Iowa", new Capital("Des Moines",75.8,203433));
        capitals.put("Kansas", new Capital("Topeka",56,127473));
        capitals.put("Kentucky", new Capital("Frankfort",14.7,25527));
        capitals.put("Louisiana", new Capital("Baton Rouge",76.8,229553));
        capitals.put("Maine", new Capital("Augusta",55.4,19136));
        capitals.put("Maryland", new Capital("Annapolis",6.73,38394));
        capitals.put("Massachusetts", new Capital("Boston",48.4,617594));
        capitals.put("Michigan", new Capital("Lansing",35,114297));
        capitals.put("Minnesota", new Capital("Saint Paul",52.8,300851));
        capitals.put("Mississippi", new Capital("Jackson",104.9,173514));
        capitals.put("Missouri", new Capital("Jefferson City",27.3,43079));
        capitals.put("Montana", new Capital("Helena",14,28190));
        capitals.put("Nebraska", new Capital("Lincoln",74.6,258379));
        capitals.put("Nevada", new Capital("Carson City",143.4,55274));
        capitals.put("New Hampshire", new Capital("Concord",64.3,42695));
        capitals.put("New Jersey", new Capital("Trenton",7.66,84913));
        capitals.put("New Mexico", new Capital("Santa Fe",37.3,75764));
        capitals.put("New York", new Capital("Albany",21.4,97856));
        capitals.put("North Carolina", new Capital("Raleigh",114.6,403892));
        capitals.put("North Dakota", new Capital("Bismarck",26.9,61272));
        capitals.put("Ohio", new Capital("Columbus",210.3,822553));
        capitals.put("Oklahoma", new Capital("Oklahoma City",607,580000));
        capitals.put("Oregon", new Capital("Salem",45.7,154637));
        capitals.put("Pennsylvania", new Capital("Harrisburg",8.11,49528));
        capitals.put("Rhode Island", new Capital("Providence",18.5,178042));
        capitals.put("South Carolina", new Capital("Columbia",125.2,131686));
        capitals.put("South Dakota", new Capital("Pierre",13,13646));
        capitals.put("Tennessee", new Capital("Nashville",473.3,635710));
        capitals.put("Texas", new Capital("Austin",251.5,790390));
        capitals.put("Utah", new Capital("Salt Lake City",109.1,186440));
        capitals.put("Vermont", new Capital("Montpelier",10.2,7855));
        capitals.put("Virginia", new Capital("Richmond",60.1,204214));
        capitals.put("Washington", new Capital("Olympia",16.7,46478));
        capitals.put("West Virginia", new Capital("Charleston",31.6,51400));
        capitals.put("Wisconsin", new Capital("Madison",68.7,233209));
        capitals.put("Wyoming", new Capital("Cheyenne",21.1,59466));
    }
    
    public static String printXSpaces(int x){
        if (x==0) {return " ";}
        return " "+printXSpaces(x-1);
    }
}