package sorting;
/**
 * Counting sort, an efficient sorting algorithm for
 * an array contains all positive keys
 *
 * Worst-case performance O(n + k)
 * Best-case performance O(n + k)
 * k is the number of distinct keys inside the array.
 * When k is O(n), the algorithm takes O(n) time to finish
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] array = {5, 13, 2, 25, 7, 17, 20, 8, 4, 4, 2, 13, 20, 12, 14, 16, 0};
        CountingSort sort = new CountingSort();
        array = sort.sort(array);

        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    public int[] sort(int[] array) {
        int[] result = new int[array.length];
        int maxValue = array[0];
        for(int i = 1; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        int[] temp = new int[maxValue + 1];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = 0;
        }

        for (int e : array) {
            temp[e]++;
        }

        for(int i = 1; i < temp.length; i++) {
            temp[i] += temp[i-1];
        }

        for(int i = array.length - 1; i >= 0; i--) {
            result[temp[array[i]]-1] = array[i];
            temp[array[i]]--;
        }
        return result;
    }
}
