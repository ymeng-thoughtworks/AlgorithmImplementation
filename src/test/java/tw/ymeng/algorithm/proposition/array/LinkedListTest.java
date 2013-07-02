package tw.ymeng.algorithm.proposition.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tw.ymeng.algorithm.proposition.array.LinkedListBuilder.build;

public class LinkedListTest {

    @Test
    public void should_return_true_if_circle_exists() {
        LinkedList linkedList = build(new int[]{1, 2, 3, 1});

        assertTrue(linkedList.hasCircle());
    }

    @Test
    public void should_return_false_if_circle_exists() {
        LinkedList linkedList = build(new int[]{1, 2, 3});

        assertFalse(linkedList.hasCircle());
    }
}
