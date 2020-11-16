package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private int index = 0;
    private int row = 0;
    private int col = 0;
    private final int size;
    private final T[][] array;

    public ArrayIterator(T[][] array) {
        this.array = array;
        this.size = count(array);
    }

    private int count(T[][] matrix) {
        int c = 0;
        for (T[] row : matrix)
            c += row.length;
        return c;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public T next() {
        if (index >= size)
            throw new NoSuchElementException("No such element in array!");
        T element = array[row][col];
        index++;
        col++;
        while (row < array.length && col >= array[row].length) {
            col = 0;
            row++;
        }
        return element;
    }
}
