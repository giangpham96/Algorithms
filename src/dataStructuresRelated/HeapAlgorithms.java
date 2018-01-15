package dataStructuresRelated;

/**
 * This class contains algorithms related to heap data structure.
 * In addition, it provides helper algorithms to heap sort algorithm,
 * which is shown in the following class {@link sorting.HeapSort}
 */
public class HeapAlgorithms {
    public static void main(String[] args) {
        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap heap = new Heap(array);
        HeapAlgorithms heapAlgorithms = new HeapAlgorithms();
        heapAlgorithms.buildMaxHeap(heap);

        heap.print();
    }

    /**
     * This method transform any heap into a max heap
     *
     * @param heap the heap to be transformed
     */
    public void buildMaxHeap(Heap heap) {
        for (int i = heap.length() / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i);
        }
    }

    /**
     * This method is used to maintain the property of a max heap
     *
     * @param heap  the heap whose a subtree that needs to obey the max heap property
     * @param index the position of the node in the [heap] which may be "floated down",
     *              so that the subtree at position [index] obeys the max heap property
     */
    public void maxHeapify(Heap heap, int index) {
        int left = leftIndex(index);
        int right = rightIndex(index);
        int largest = index;
        if (left < heap.heapSize && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.heapSize && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            int temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, temp);
            maxHeapify(heap, largest);
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

    public static class Heap {
        private int[] array;
        public int heapSize;

        public Heap(int[] array) {
            if (array == null)
                throw new NullPointerException("This constructor does not take `null` as a parameter");
            this.array = array;
            heapSize = array.length;
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
}
