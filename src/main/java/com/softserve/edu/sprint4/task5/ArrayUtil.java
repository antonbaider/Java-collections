package com.softserve.edu.sprint4.task5;

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

public class ArrayUtil {
    // Write static method averageValue(...) here
    //

}