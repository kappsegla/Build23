package org.example.regression;

import org.jetbrains.annotations.NotNull;

public class StringUtils {
    /**
     * Truncates a string to be maxLength or less
     * @param input Must not be null
     * @param maxLength
     * @return The truncated string
     */
    public static String truncate(@NotNull String input, int maxLength) {
        if( maxLength < 3)
            maxLength = 3;

        return input.length() <= maxLength ? input : input.substring(0, maxLength);
    }
}
