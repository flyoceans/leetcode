public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int[] arr) {
        this.heap = arr;
        this.size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);

        return min;
    }
}
