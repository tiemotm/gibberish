package com.example.gibberish.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ProverbRepository {
    List<String> proverbs = new ArrayList<>(List.of(
            "An apple a day keeps the doctor away",
            "Dont judge a book by its cover",
            "A cat has nine lives",
            "Actions speak louder than words",
            "Break a leg",
            "Better late than never"
    ));

    private Random random;

    public ProverbRepository() {
        this.random = new Random();
    }

    public ProverbRepository(List<String> proverbs, Random random) {
        this.proverbs = proverbs;
        this.random = random;
    }

    public String get(int i) {
        return proverbs.get(i);
    }

    public String getRandom() {
        return proverbs.get(random.nextInt(proverbs.size()));
    }
}
