package sorting;

import dataStructuresRelated.HeapAlgorithms;

/**
 * Heap sort, a sorting algorithm which utilize heap data structure to sort
 * Worst-case performance O(n lg n)
 * Best-case performance O(n lg n) (distinct keys)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        HeapSort sort = new HeapSort();
        sort.sort(array);

        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    public void sort(int[] array) {
        int temp;
        HeapAlgorithms helper = new HeapAlgorithms();
        helper.buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            helper.maxHeapify(array, 0, i - 1);
        }
    }
}
