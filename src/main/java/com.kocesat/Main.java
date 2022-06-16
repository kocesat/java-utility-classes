package com.kocesat;

import com.kocesat.utils.ArraySplitter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] arr = {"S1", "S2", "S3", "S4", "S5", "S6", "S7"};
        ArraySplitter<String> arraySplitter = new ArraySplitter<String>(arr, String.class);
        var arrays = arraySplitter.split(3);
        arrays.forEach(a -> Arrays.stream(a).forEach(System.out::println));

//        String[] formats = new String[] {"dd.MM.yyyy", "dd-MM-yyyy", "dd/MM/yyyy"};
//        LocalDate myDate = DateTimeUtils.parseDateFromMultipleFormats("2021-04-15", formats);
//        System.out.println(myDate);
    }
}
