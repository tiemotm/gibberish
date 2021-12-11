package com.example.gibberish.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProverbRepositoryTests {

    class FakeRandom extends Random {
        @Override
        public int nextInt(int i) {
            return super.nextInt(i);
        }
    }

    List<String> proverbs = new ArrayList<>(List.of(
            "foo",
            "bar",
            "foobar",
            "barfoo",
            "fo",
            "ba"
    ));

    Random random = mock(FakeRandom.class);

    private ProverbRepository repository = new ProverbRepository(proverbs, random);

    @Test
    @DisplayName("")
    void testGetAt0() {
        String proverb = repository.get(0);
        assertThat(proverb).isEqualTo("foo");
    }

    @Test
    @DisplayName("")
    void testGetAt3() {
        String proverb = repository.get(3);
        assertThat(proverb).isEqualTo("barfoo");
    }

    @Test
    @DisplayName("")
    void testGetRandom() {
        when(random.nextInt(anyInt())).thenReturn(5).thenReturn(2).thenReturn(4);
        String proverb1 = repository.getRandom();
        String proverb2 = repository.getRandom();
        String proverb3 = repository.getRandom();
        assertThat(proverb1).isEqualTo("ba");
        assertThat(proverb2).isEqualTo("foobar");
        assertThat(proverb3).isEqualTo("fo");
    }
}
