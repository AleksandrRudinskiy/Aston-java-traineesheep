
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    void shouldSortInt() {
        Integer []array = new Integer[]{1, 10, 3, 4,66,-5,13,789,23,234,90002};
        Comparator comparator = (o1, o2) -> (int)o1 - (int) o2;
        QuickSort<Integer> quickSort = new QuickSort<>(comparator,array);
        quickSort.quickSort();
        System.out.println(Arrays.toString(array));
        assertArrayEquals(new Integer[]{-5, 1, 3, 4, 10, 13, 23, 66, 234, 789, 90002}, array);
    }
}
