package dataStructuresRelated;

/**
 * This class contains algorithms related to heap data structure.
 * In addition, it provides helper algorithms to heap sort algorithm,
 * which is shown in the following class {@link sorting.HeapSort}
 */
public class Heap {
    private int[] array;
    public int heapSize;

    public Heap(int[] array) {
        if (array == null)
            throw new NullPointerException("This constructor does not take `null` as a parameter");
        this.array = array;
        heapSize = array.length;
        buildMaxHeap();
    }

    /**
     * This method transforms this heap into a max heap
     */
    public void buildMaxHeap() {
        for (int i = length() / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * This method is used to maintain the property of a max heap
     * at a specific node
     *
     * @param index the position of the node in the heap which may be "floated down",
     *              so that the subtree at position [index] obeys the max heap property
     */
    public void maxHeapify(int index) {
        int left = leftIndex(index);
        int right = rightIndex(index);
        int largest = index;
        if (left < heapSize && get(left) > get(largest)) {
            largest = left;
        }
        if (right < heapSize && get(right) > get(largest)) {
            largest = right;
        }

        if (largest != index) {
            int temp = get(index);
            set(index, get(largest));
            set(largest, temp);
            maxHeapify(largest);
        }
    }

    public int get(int position) {
        if (position >= array.length || position < 0)
            throw new IndexOutOfBoundsException(position > 0
                    ? "The last index of the heap is " + (array.length - 1)
                    : "position must not be negative");
        return array[position];
    }

    public void set(int position, int value) {
        if (position >= array.length || position < 0)
            throw new IndexOutOfBoundsException(position > 0
                    ? "The last index of the heap is " + (array.length - 1)
                    : "position must not be negative");
        array[position] = value;
    }

    public int length() {
        return array.length;
    }

    public void print() {
        for (int i : array) {
            System.out.print(i + "\t");
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
