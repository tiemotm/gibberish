package com.example.gibberish.soundex;

import org.springframework.context.annotation.Bean;

public class Soundex extends org.apache.commons.codec.language.RefinedSoundex {

    //                                           ABCDEFGHIJKLMNOPQRSTUVWXYZ
    public static final String CUSTOM_MAPPING = "01360230043788013956020505";

    public Soundex() {
        super(CUSTOM_MAPPING);
    }

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
