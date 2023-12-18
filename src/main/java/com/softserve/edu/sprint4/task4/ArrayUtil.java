package com.softserve.edu.sprint4.task4;
public class ArrayUtil {
    @SuppressWarnings("unchecked")
    public static <T> T setAndReturn(T[] array, T value, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        array[index] = value;
        return (T) array[index];
    }
}