package org.example.regression;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void truncate_shortString_returnsOriginal() {
        assertEquals("hi", StringUtils.truncate("hi", 5));
    }

    @Test
    void truncate_longString_atLeast_3() {
        assertEquals("hel", StringUtils.truncate("hello", 2));
    }

    @Test
    void truncate_emptyString_truncate() {
        assertEquals("", StringUtils.truncate("", 3));
    }
}
