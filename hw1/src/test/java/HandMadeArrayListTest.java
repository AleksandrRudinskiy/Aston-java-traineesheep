

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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



}
