package com.example.gibberish;

public class Gibberish {
    private final String gibberish;
    private final String solution;

    public Gibberish(String gibberish, String solution) {
        this.gibberish = gibberish;
        this.solution = solution;
    }

    public String getGibberish() {
        return gibberish;
    }

    public String getSolution() {
        return solution;
    }

    public static String generateGibberish(String str) {
        return str;
    }
}
