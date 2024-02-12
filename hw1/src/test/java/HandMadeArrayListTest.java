

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;Aston-practice
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



}
