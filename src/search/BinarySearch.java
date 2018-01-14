package search;

/**
 * Binary search, also known as half-interval search, logarithmic search, or binary chop,
 * is a search algorithm that finds the position of a target value within a sorted array
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int position = binarySearch.search(new int[] {0,1,2,4,5,6,9,10, 14, 15, 22, 26, 47}, 47);
        System.out.print(position);
    }

    public int search(int[] sorted, int value) {
        return binarySearch(sorted, value, 0, sorted.length-1);
    }

    private int binarySearch(int[] sorted, int value, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end)/2;
        if (value == sorted[mid]) {
            return mid;
        } else if (value < sorted[mid]) {
            return binarySearch(sorted, value, begin, mid - 1);
        } else {
            return binarySearch(sorted, value, mid + 1, end);
        }
    }
}
