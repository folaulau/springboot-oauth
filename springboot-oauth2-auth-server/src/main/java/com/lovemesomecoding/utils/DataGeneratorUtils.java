//package com.lovemesomecoding.utils;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//public class DataGeneratorUtils {
//
//    private static final List<String> firstnames = Arrays.asList("Taylor", "Bailey", "Josiah", "Clay", "Archie", "Nicolas", "Lucero", "Davin", "Odell", "Princeton", "Garcia", "Amando", "Ernesto",
//            "Lorena", "Maya", "Osborn", "Sancho", "Ruben", "Nick", "Jorge", "Dominique", "Elvis", "Kendra", "Cristian", "Jayden", "Lisa", "Regan", "Jabari", "Emma", "Ryann", "Luna", "Janelle",
//            "Kelsey", "Briana", "Richard", "Gracelyn", "Willie", "Sidney", "Sean", "Skyler", "Rolando", "Stephanie", "Terrell", "Karla", "Javier", "Kimberly", "Macy", "Irene");
//
//    private static final List<String> lastnames  = Arrays.asList("Edwards", "Campbell", "Young", "Morgan", "Evans", "Murray", "Jenkins", "Ross", "Mccarthy", "Brown", "Robinson", "Johnson", "Smith",
//            "Thomas", "Wilson", "Jones", "Lee", "Thompson", "Walker", "Jackson", "James", "Turner");
//
//    public static final String getRandomFirstName() {
//        return firstnames.get(RandomGeneratorUtils.getIntegerWithin(0, firstnames.size()));
//    }
//
//    public static final String getRandomLastName() {
//        return lastnames.get(RandomGeneratorUtils.getIntegerWithin(0, lastnames.size()));
//    }
//
//    public static final String getRandomEmail() {
//        return "folaukaveinga+monomono" + RandomGeneratorUtils.getIntegerWithin(1, Integer.MAX_VALUE) + "@gmail.com";
//    }
//}
