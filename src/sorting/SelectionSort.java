package sorting;

/**
 * Selection sort, an efficient algorithm for sorting a small number of elements
 * Worst-case performance O(n^2)
 * Best-case performance O(n^2) (distinct keys)
 */

public class SelectionSort {

    public static void main(String[] args) {

        SelectionSort selectionSort = new SelectionSort();

        int[] nonincreasing = selectionSort.sortNonincreasing(new int[]{31, 41, 59, 26, 41, 56});

        System.out.print("non-increasing sequence: ");
        for (int i : nonincreasing) {
            System.out.print(i);
            System.out.print("\t");
        }

        System.out.print("\n");

        int[] nondecreasing = selectionSort.sortNondecreasing(new int[]{31, 41, 59, 26, 41, 56});

        System.out.print("non-decreasing sequence: ");
        for (int i : nondecreasing) {
            System.out.print(i);
            System.out.print("\t");
        }
    }

    public int[] sortNondecreasing(int[] unsorted) {
        int temp;
        for(int i = 0; i < unsorted.length; i++) {
            int index = i;

            for(int j = i; j < unsorted.length; j++) {
                if (unsorted[j] < unsorted[index]) {
                    index = j;
                }
            }

            temp = unsorted[index];
            unsorted[index] = unsorted[i];
            unsorted[i] = temp;
        }

        return unsorted;
    }

    public int[] sortNonincreasing(int[] unsorted) {
        int temp;
        for(int i = 0; i < unsorted.length; i++) {
            int index = i;

            for(int j = i; j < unsorted.length; j++) {
                if (unsorted[j] > unsorted[index]) {
                    index = j;
                }
            }

            temp = unsorted[index];
            unsorted[index] = unsorted[i];
            unsorted[i] = temp;
        }
        return unsorted;
    }
}
