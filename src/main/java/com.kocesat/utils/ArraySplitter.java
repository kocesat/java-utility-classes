package com.kocesat.utils;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
public class ArraySplitter<T> {
    private int totalLength;
    private T[] splittableArray;
    private int numOfArrays;
    private List<T[]> arrays = new ArrayList<>();
    Class<T> clazz;

    public ArraySplitter(T[] splittableArray, Class<T> clazz) {
        this.splittableArray = splittableArray;
        this.totalLength = splittableArray.length;
        this.clazz = clazz;
    }

    public List<T[]> split(int chunkSize) {
        return doSplit(clazz, chunkSize);
    }

    private List<T[]> doSplit(Class<T> clazz, int chunkSize) {
        // How many array should be created based on chunkSize
        numOfArrays = totalLength % chunkSize == 0 ? (totalLength / chunkSize) : (totalLength / chunkSize) + 1;
        // Create empty arrays to perform splitting
        for (int i = 0; i < numOfArrays; i++) {
            T[] genericArray = (T[]) Array.newInstance(clazz, chunkSize);
            arrays.add(genericArray);
        }

        // iterate over each element in splittable array and put related position in related array
        for (int i = 0; i < totalLength; i++) {
            int indexOfArray = i / chunkSize;
            int indexOfObject = i % chunkSize;
            arrays.get(indexOfArray)[indexOfObject] = splittableArray[i];
        }

        return arrays;
    }
}















