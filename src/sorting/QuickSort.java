package sorting;
/**
 * Quick sort, a sorting algorithm which recursively put
 * keys to their correct positions by using partition
 *
 * Worst-case performance O(n^2)
 * Best-case performance O(n lg n)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 13, 2, 25, 7, 17, 20, 8, 4, 19};
        QuickSort sort = new QuickSort();
        sort.sort(array);

        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int begin, int end) {
        if (begin >= end)
            return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        if (begin >= array.length || begin < 0)
            throw new IndexOutOfBoundsException(begin > 0
                    ? "The last index of the array is " + (array.length - 1)
                    : "`begin` must not be negative");
        if (end >= array.length || end < 0)
            throw new IndexOutOfBoundsException(end > 0
                    ? "The last index of the array is " + (array.length - 1)
                    : "`end` must not be negative");
        if (begin >= end) {
            throw new RuntimeException("`begin` must be smaller than `end`");
        }
        int key = array[end];
        int pivot = begin - 1;
        int temp;
        for(int j = begin; j < end; j++) {
            if(array[j] < key) {
                pivot++;
                temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
            }
        }
        pivot++;
        array[end] = array[pivot];
        array[pivot] = key;
        return pivot;
    }
}
