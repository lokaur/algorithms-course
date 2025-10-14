package me.lokaur.algorithms;

public class Main {
    public static void main(String[] args) {
        var array = new int[]{1, 2, 100, 1000, -90, -104124, 2, 1, 5, 5235, 2352, 12, -125, 12};
        findMinMax(array);
    }

    public static void findMinMax(final int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int stepsCount = 0;

        for (int i = 0; i < arr.length - 1; i += 2) {
            stepsCount++;
            int value = arr[i];
            int nextValue = arr[i + 1];
            if (value < nextValue) {
                if (value < min) {
                    min = value;
                }
                if (nextValue > max) {
                    max = nextValue;
                }
            } else {
                if (nextValue < min) {
                    min = nextValue;
                }
                if (value > max) {
                    max = value;
                }
            }
        }

        System.out.printf("\nMin value: %d; Max value: %d", min, max);
        System.out.printf("\nTarget complexity: 3(%d/2); Calculated complexity: 3(%d)\n", arr.length, stepsCount);
    }
}