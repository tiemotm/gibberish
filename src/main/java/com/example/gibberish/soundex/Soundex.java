package com.example.gibberish.soundex;

public class Soundex extends org.apache.commons.codec.language.Soundex {
    @Override
    public String encode(String str) {
        String[] words = str.split("\\s+");
        String code = "";

        for (int i = 0; i < words.length; i++) {
            code += super.encode(words[i]);

            if(i != words.length - 1) {
                code += " ";
            }
        }

        return code;
    }
}
