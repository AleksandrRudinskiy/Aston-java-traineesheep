import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Integer []array = new Integer[]{1, 10, 3, 4,66,-5,13,789,23,234,90002};
        Comparator comparator = (o1, o2) -> (int)o1 - (int) o2;
        QuickSort<Integer> quickSort = new QuickSort<>(comparator,array);
        quickSort.quickSort();
        System.out.println(Arrays.toString(array));
    }
}
