package tw.ymeng.algorithm.proposition.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListBuilder {

    private Map<Integer, LinkedList> pool = new HashMap<Integer, LinkedList>();

    public static LinkedList build(int... array) {
        return new LinkedListBuilder().convertFrom(array);
    }

    private LinkedList convertFrom(int[] array) {
        LinkedList first = newLinkedList(array[0]);
        LinkedList last = first;

        for (int i = 1; i < array.length; i++) {
            LinkedList node = null;
            int data = array[i];
            if (hasAdded(data)) {
                node = retrieve(data);
            } else {
                node = newLinkedList(data);
            }

            last.next(node);
            last = node;
        }

        return first;
    }

    private LinkedList retrieve(int data) {
        return pool.get(data);
    }

    private boolean hasAdded(int data) {
        return pool.containsKey(data);
    }

    private LinkedList newLinkedList(int data) {
        LinkedList list = new LinkedList(data);
        pool.put(data, list);
        return list;
    }
}
