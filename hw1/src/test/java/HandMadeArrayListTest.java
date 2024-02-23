import list.HandMadeArrayList;
import model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandMadeArrayListTest {
    @Test
    void addIntTest() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        list.add(1);
        list.add(25);
        assertEquals(2, list.size());
        assertEquals(25, list.get(1));
    }

    @Test
    void addStringTest() {
        HandMadeArrayList<String> list = new HandMadeArrayList<>();
        list.add("qdqwdqw");
        assertEquals(1, list.size());
        assertEquals("qdqwdqw", list.get(0));
    }

    @Test
    void addObjectTest() {
        Employee employee = new Employee(1, "name");
        HandMadeArrayList<Employee> list = new HandMadeArrayList<>();
        list.add(employee);
        assertEquals(employee, list.get(0));
    }

    @Test
    void removeIntTest() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        list.add(1);
        list.add(25);
        list.add(100);
        assertEquals(3, list.size());
        assertEquals(25, list.get(1));
        list.remove(25);
        assertEquals(2, list.size());
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        list.add(1);
        list.add(25);
        list.add(100);
        int index = 5;
        final ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> list.get(index));
        assertEquals("Element with index " + index + " does not exist", exception.getMessage());
    }

    @Test
    void addElementByIndex() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        list.add(1);
        list.add(25);
        list.add(100);
        list.add(1, 456);
        assertEquals(4, list.size());
        assertEquals(456, list.get(1));
    }

    @Test
    void addBigLengthList() {
        int[] array = new int[80_000_000];
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        for (int i : array) {
            array[i] = i;
            list.add(i);
        }
        assertEquals(80_000_000, list.size());
    }

    @Test
    void clearListTest() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        list.add(1);
        list.add(25);
        list.add(100);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void shouldBe20sizeWhenDelete80elements() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();
        for (int i = 1; i < 101; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        for (int i = 1; i < 81; i++) {
            list.remove(i);
        }
        assertEquals(20, list.size());
    }

    @Test
    void shouldAdd10ElementsByIndex() {
        HandMadeArrayList<Integer> list = new HandMadeArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i, i + 10);
        }
        assertEquals(10, list.size());
        assertEquals(19, list.get(9));

        for (int i = 0; i < 10; i++) {
            list.add(i, i + 1000);
        }
        assertEquals(20, list.size());
        assertEquals(19, list.get(19));
        assertEquals(1009, list.get(9));

    }


}
