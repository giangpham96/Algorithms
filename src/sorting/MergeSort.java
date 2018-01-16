package sorting;

import java.util.Random;

/**
 * Merge sort, a sorting algorithm which outperforms insertion sort and selection sort
 * if the array size is large enough
 * Worst-case performance O(n lg n)
 * Best-case performance O(n lg n)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[31];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }

        System.out.print("unsorted sequence: " + "\t");
        for (int i : arr) {
            System.out.print(i);
            System.out.print("\t");
        }

        System.out.print("\n");
        (new MergeSort()).sort(arr);

        System.out.print("non-increasing sequence: " + "\t");
        for (int i : arr) {
            System.out.print(i);
            System.out.print("\t");
        }
    }

    public void sort(int[] unsorted) {
        mergeSort(unsorted, 0, unsorted.length - 1);
    }

    private void mergeSort(int[] unsorted, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(unsorted, begin, mid);
            mergeSort(unsorted, mid + 1, end);
            merge(unsorted, begin, mid, end);
        }
    }

    private void merge(int[] unsorted, int begin, int mid, int end) {
        int length1 = mid - begin + 1;
        int length2 = end - mid;
        int i, j; //counters
        int[] left = new int[length1], right = new int[length2];

        for (i = 0; i < length1; i++) {
            left[i] = unsorted[i + begin];
        }

        for (j = 0; j < length2; j++) {
            right[j] = unsorted[j + mid + 1];
        }

        i = j = 0;

        for (int k = begin; k <= end; k++) {
            if (i >= length1) {
                unsorted[k] = right[j];
                j++;
                continue;
            }
            if (j >= length2) {
                unsorted[k] = left[i];
                i++;
                continue;
            }
            if (left[i] <= right[j]) {
                unsorted[k] = left[i];
                i++;
            } else {
                unsorted[k] = right[j];
                j++;
            }
        }
    }
}
