package me.lokaur.algorithms;

public interface SortedCollection<T> {
    void add(T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    void remove(int index);
}
