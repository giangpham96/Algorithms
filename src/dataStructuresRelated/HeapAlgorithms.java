package dataStructuresRelated;

/**
 * This class contains algorithms related to heap data structure.
 * In addition, it provides helper algorithms to heap sort algorithm,
 * which is shown in the following class {@link sorting.HeapSort}
 */
public class HeapAlgorithms {
    public static void main(String[] args) {
        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapAlgorithms heapAlgorithms = new HeapAlgorithms();
        heapAlgorithms.buildMaxHeap(array);

        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    /**
     * This method transform any array into a max heap
     *
     * @param array the array to be transformed
     */
    public void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, array.length - 1);
        }
    }

    /**
     * This method is used to maintain the property of a max heap
     *
     * @param array the array that represents the heap
     * @param index the position of the node which may be "floated down", so that
     *              the subtree at position [index] obeys the max heap property
     * @param end the last position that is taken into account of this maintenance.
     *            If this parameter is larger than the last index of [array] or smaller
     *            than 0, an exception will be thrown
     */
    public void maxHeapify(int[] array, int index, int end) {
        if (end >= array.length || end < 0) {
            throw new IndexOutOfBoundsException();
        }
        int left = leftIndex(index);
        int right = rightIndex(index);
        int largest = index;
        if (left <= end && array[left] > array[index]) {
            largest = left;
        }
        if (right <= end && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest, end);
        }
    }

    private int leftIndex(int index) {
        return 2 * (index + 1) - 1;
    }

    private int rightIndex(int index) {
        return 2 * (index + 1);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
}
