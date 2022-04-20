package com.kocesat.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public final class DateTimeUtils {

    private DateTimeUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDate parseDateFromMultipleFormats(String value, String[] formats) {
        LocalDate localDate = null;
        String[] extendedFormats = Arrays.copyOf(formats, formats.length + 1);
        extendedFormats[extendedFormats.length - 1] = "yyyy-MM-dd";

        for (String format : extendedFormats) {
            try {
                localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
                break;
            } catch (DateTimeParseException e) {
                continue;
            }
        }

        if (localDate == null) {
            throw new IllegalArgumentException("No compatible date format found!");
        }
        return localDate;
    }
}
