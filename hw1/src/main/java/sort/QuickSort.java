package sort;

import java.util.Comparator;
import java.util.Stack;

public class QuickSort<T> implements Sort {
    private final Comparator<T> comparator;
    private final T[] arr;

    private final Object[] resaltArr;
    int l;
    int h;

    public QuickSort(Comparator<T> comparator, T[] arr) {
        this.comparator = comparator;
        this.arr = arr;
        l = 0;
        h = arr.length - 1;
        resaltArr = new Object[arr.length];
    }

    @Override
    public Object[] sort() {
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
        return resaltArr;
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                T temp = arr[i];
                resaltArr[i] = arr[j];
                arr[i] = arr[j];
                resaltArr[j] = temp;
                arr[j] = temp;
                i++;
            }
        }
        T temp = arr[i];
        resaltArr[i] = arr[high];
        arr[i] = arr[high];

        resaltArr[high] = temp;
        arr[high] = temp;
        return i;
    }


}