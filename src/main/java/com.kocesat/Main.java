package com.kocesat;

import com.kocesat.utils.DateTimeUtils;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String[] formats = new String[] {"dd.MM.yyyy", "dd-MM-yyyy", "dd/MM/yyyy"};
        LocalDate myDate = DateTimeUtils.parseDateFromMultipleFormats("2021-04-15", formats);
        System.out.println(myDate);
    }
}
