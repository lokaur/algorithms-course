package me.lokaur.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortedList<T> implements SortedCollection<T>, Iterable<T> {

    private final List<T> list;
    private final Comparator<? super T> comparator;

    /** @noinspection unchecked*/
    public SortedList() {
        this((v1, v2) -> ((Comparable<? super T>)v1).compareTo(v2));
    }

    public SortedList(Comparator<? super T> comparator) {
        this.comparator = comparator;
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        int index = indexToInsert(value);
        list.add(index, value);
    }

    public T get(int index) {
        return list.get(index);
    }

    public boolean contains(T value) {
        return binarySearch(value) != -1;
    }

    public int indexOf(T value) {
        return binarySearch(value);
    }

    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i != list.size() - 1 ? ", " : "\n"));
        }
    }

    private int binarySearch(T value) {
        int first = 0;
        int last = list.size() - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            T midValue = list.get(mid);
            var res = comparator.compare(midValue, value);

            if (res < 0) {
                first = mid + 1;
            } else if (res > 0) {
                last = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int indexToInsert(T value) {
        int first = 0;
        int last = list.size() - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            T midValue = list.get(mid);
            var res = comparator.compare(midValue, value);

            if (res < 0) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return first;
    }
}
