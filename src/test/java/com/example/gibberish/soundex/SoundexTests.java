package com.example.gibberish.soundex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoundexTests {

    private Soundex soundex = new Soundex();

    @Test
    @DisplayName("Returning F20 B109 for foo bar")
    public void testSoundexReturning_F000_B600_For_foo_bar() {
        String code = soundex.encode("foo bar");
        assertThat(code).isEqualTo("F20 B109");
    }

    @Test
    @DisplayName("Returning R163 I C400 for Robert is cool")
    public void testSoundexReturning_R163_I200_C400_For_Robert_is_cool() {
        String code = soundex.encode("Robert is cool");
        assertThat(code).isEqualTo("R901096 I05 C307");
    }
}
