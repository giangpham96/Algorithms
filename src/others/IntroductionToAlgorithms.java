package others;

import sorting.MergeSort;
import search.BinarySearch;

/**
 * answers to some problems from 'Introduction to algorithms' third edition
 */

public class IntroductionToAlgorithms {
    public static void main(String[] args) {

    }

    /* 2.3-7
    Describe a O(n lg n)-time algorithm that, given a set S of n integers and another
    integer x, determines whether or not there exist two elements in S whose sum is
    exactly x.

    Answer: sort the set S into increasing order using merge sort (which takes O(n log n)-time),
    then iterate through the set, with each element e from the set, use binary search to search
    for y such that e + y = x. Since binary search is a O(log n) time algorithm, the iterate step
    consumes O(n log n) time. In total, this algorithm finishes after O(n log n) time.
    */

    private static boolean e2_3__7(int[] S, int x) {

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(S);

        BinarySearch binarySearch = new BinarySearch();

        int y;
        for (int element : S) {
            y = x - element;
            if (binarySearch.search(S, y) >= 0) {
                return true;
            }
        }

        return false;
    }

}
