package com.example.gibberish;

import com.example.gibberish.soundex.Soundex;

public class Gibberish {
    private final String gibberish;
    private final String solution;

    private final Soundex soundex = new Soundex();

    public Gibberish(String text) {
        this.solution = text;
        this.gibberish = generateGibberish(text);
    }

    public String getGibberish() {
        return gibberish;
    }

    public String getSolution() {
        return solution;
    }

    private String generateGibberish(String str) {
        String gibberish = "";
        String codes = soundex.encode(str);

        String[] inverse = {"AEIOUYHW", "BP", "FV", "CKQG", "J", "XZS", "DT", "L", "MN", "R"};

        for (String code : codes.split(" ")) {
            for (char c : code.toCharArray()) {
                // Char is 0 - 9
                if(c >= 48 && c <= 57) {
                    gibberish += Character.toString(inverse[c - 48].charAt((int) (Math.random() * inverse[c - 48].length())));
                }
                else {
                    gibberish += c;
                }
            }

            gibberish += " ";
        }

        return gibberish;
    }
}
