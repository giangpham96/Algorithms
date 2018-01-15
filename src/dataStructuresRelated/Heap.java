package dataStructuresRelated;

/**
 * This class contains algorithms related to heap data structure.
 * In addition, it provides helper algorithms to heap sort algorithm,
 * which is shown in the following class {@link sorting.HeapSort}
 */
public class Heap {
    private int[] array;
    public int heapSize;

    public static void main(String[] args) {
        int[] array = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        Heap heap = new Heap(array);
        heap.print();
    }

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

    /**
     * This method removes the maximum value inside the heap before returning it
     *
     * @return the maximum value inside the heap
     */
    public int extractMax() {
        if (heapSize < 1) {
            throw new RuntimeException("Heap underflow");
        }
        int max = get(0);
        set(0, get(heapSize - 1));
        heapSize--;
        maxHeapify(0);
        return max;
    }

    /**
     * This method increases the key of a specific node.
     * After that, the heap is reordered to maintain the max heap property.
     * If the position is greater than or equal to the heapsize or smaller than 0,
     * an exception will be thrown
     * If the new key is smaller than the old key, an exception will be thrown
     *
     * @param position the position of a node whose key is increased
     * @param key the new key of the node at index [position]
     */
    public void increaseKey(int position, int key) {
        if (position >= heapSize || position < 0)
            throw new IndexOutOfBoundsException(position > 0
                    ? "The size of the heap is " + (heapSize)
                    : "position must not be negative");
        if (key< get(position))
            throw new RuntimeException("New key is smaller than the current key");
        set(position, key);

        int temp;
        while (position > 0 && get(parentIndex(position)) < get(position)) {
            temp = get(position);
            set(position, get(parentIndex(position)));
            set(parentIndex(position), temp);
            position = parentIndex(position);
        }
    }

    /**
     * This method adds a new node to the heap if it is not full
     *
     * @param key the key of the new node
     */
    public void insert(int key) {
        if(heapSize == array.length)
            return;
        heapSize++;
        set(heapSize - 1, Integer.MIN_VALUE);
        increaseKey(heapSize - 1, key);
    }
    public int maximum() {
        if (array.length == 0)
            return 0;
        return get(0);
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
}
