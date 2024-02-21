
import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    void shouldSortInt() {
        Integer[] array = new Integer[]{1, 10, 3, 4, 66, -5, 13, 789, 23, 234, 90002};
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        QuickSort<Integer> quickSort = new QuickSort<>(comparator, array);
        assertArrayEquals(new Integer[]{-5, 1, 3, 4, 10, 13, 23, 66, 234, 789, 90002}, quickSort.quickSort());
    }

    @Test
    void shouldSortLong() {
        Long[] array = new Long[]{1L, 10L, 3L, -4L, 0L, 5L};
        Comparator<Long> comparator = Comparator.comparingLong(o -> o);
        QuickSort<Long> quickSort = new QuickSort<>(comparator, array);
        assertArrayEquals(new Long[]{-4L, 0L, 1L, 3L, 5L, 10L}, quickSort.quickSort());
    }

    @Test
    void shouldSortString() {
        String[] array = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a"};
        Comparator<String> comparator = String::compareTo;
        QuickSort<String> quickSort = new QuickSort<>(comparator, array);
        assertArrayEquals(new String[]{"a", "e", "i", "o", "p", "q", "r", "t", "u", "w", "y"}, quickSort.quickSort());
    }

}
