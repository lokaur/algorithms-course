package ru.t1.education;

import java.util.Stack;

public final class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, arr.length - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int left = range[0];
            int right = range[1];
            if (left >= right) {
                continue;
            }

            int pivot = partition(arr, left, right);
            if (pivot - left - 1 > right - (pivot + 1)) {
                stack.push(new int[]{left, pivot - 1});
                stack.push(new int[]{pivot + 1, right});
            } else {
                stack.push(new int[]{pivot + 1, right});
                stack.push(new int[]{left, pivot - 1});
            }
        }
    }

    /**
     * Разбиение Ломуто.
     * Все элементы меньше pivot перемещает в начало диапазона разбиения.
     *
     * @param arr   массив
     * @param left  левая граница
     * @param right правая граница
     * @return индекс точки разбиения
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
