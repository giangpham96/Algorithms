package com.company.sorting;

/**
 * Insertion sort, an efficient algorithm for sorting a small number of elements
 */

public class InsertionSort {

    public static void main(String[] args) {

        InsertionSort insertionSort = new InsertionSort();

        int[] nonincreasing = insertionSort.sortNonincreasing(new int[]{31, 41, 59, 26, 41, 58});

        System.out.print("non-increasing sequence: ");
        for (int i : nonincreasing) {
            System.out.print(i);
            System.out.print("\t");
        }

        System.out.print("\n");

        int[] nondecreasing = insertionSort.sortNondecreasing(new int[]{31, 41, 59, 26, 41, 58});

        System.out.print("non-decreasing sequence: ");
        for (int i : nondecreasing) {
            System.out.print(i);
            System.out.print("\t");
        }

    }

    public int[] sortNondecreasing(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int key = unsorted[i];

            int j = i - 1; // counter which counts from i - 1 down to 0
            while (j >= 0 && unsorted[j] > key) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }

            unsorted[j + 1] = key;
        }

        return unsorted;
    }

    public int[] sortNonincreasing(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int key = unsorted[i];

            int j = i - 1; // counter which counts from i - 1 down to 0
            while (j >= 0 && unsorted[j] < key) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }

            unsorted[j + 1] = key;
        }

        return unsorted;
    }
}
