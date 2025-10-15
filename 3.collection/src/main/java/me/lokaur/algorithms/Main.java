package me.lokaur.algorithms;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var sortedList = new SortedList<Integer>(Comparator.reverseOrder());
        sortedList.add(100);
        sortedList.add(0);
        sortedList.add(-1);
        sortedList.add(124124);
        sortedList.add(2);
        sortedList.add(100);
        sortedList.add(4);

        sortedList.print();
        System.out.printf("\n%b\n", sortedList.contains(-1));
        System.out.printf("\n%b\n", sortedList.contains(-3));
        System.out.printf("\n%d\n", sortedList.indexOf(-3));
        System.out.printf("\n%d\n", sortedList.indexOf(100));
    }
}