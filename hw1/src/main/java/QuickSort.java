import java.util.Comparator;
import java.util.Stack;

public class QuickSort<T> implements Comparable {
    private final Comparator<T> comparator;
    private T[] arr;
    int l;
    int h;

    public QuickSort(Comparator comparator, T[] arr) {
        this.comparator = comparator;
        this.arr = arr;
        l = 0;
        h = arr.length - 1;
    }

    public void quickSort() {
        if (arr == null || arr.length == 0)
            return;

        if (comparator.compare(arr[l], arr[h]) >= 0)
            return;

        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(h);

        while (!stack.isEmpty()) {
            h = stack.pop();
            l = stack.pop();

            int pivotIndex = partition(arr, l, h);
            if (pivotIndex - 1 > l) {
                stack.push(l);
                stack.push(pivotIndex - 1);
            }
            
            if (pivotIndex + 1 < h) {
                stack.push(pivotIndex + 1);
                stack.push(h);
            }
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        T temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}