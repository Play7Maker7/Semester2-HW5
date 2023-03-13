import java.util.HashSet;
import java.util.Set;

public class CircularSinglyLinkedList<E> {
    Node<E> tail;
    private int size=0;

    public boolean isEmpty()
    {
        return size==0;
    }
    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }





    //First Question:
    public void addFirst(E e)
    {
        if (isEmpty())
        {
            tail = new Node<>(e,null);
            tail.next = tail;
        }
        else tail.next = new Node<>(e,tail.next);
    }

    //Second Question:
    public int size()
    {
        if (isEmpty()) return 0;
        int counter = 1;
        Node<E> x = tail.next;
        while (x != tail)
        {
            x = x.next;
            counter++;
        }
        return counter;
    }

    //Third Question:
    public boolean equals(Object o)
    {
        if (o == null) return false;

        CircularSinglyLinkedList<E> o2 = (CircularSinglyLinkedList<E>) o;
        if (size != o2.size) return false;

        if (size == 0 && o2.size == 0) return true;

        Node<E> x = tail.next;
        Node<E> y = o2.tail.next;

        while (x != tail){
            if (!x.element.equals(o2.tail.element)) return false;
        }

        x = x.next;
        y = y.next;

        return tail.element.equals(o2.tail.element);
    }

    //Fourth Question:
    public static <E> boolean same(CircularSinglyLinkedList<E> x , CircularSinglyLinkedList<E> y)
    {
        if (x.size != y.size) return false;

        Node<E> tail1 = x.tail;
        Node<E> tail2 = y.tail;
        Set<Node<E>> visitor = new HashSet<>();

        Node<E> e1 = tail1.next;
        Node<E> e2 = tail2.next;

        while (e1 != tail1)
        {
            visitor.add(e1);
            e1 = e1.next;
        }
        visitor.add(tail1);

        while (e2 != tail1)
        {
            visitor.add(e2);
            e2 = e2.next;
        }
        return visitor.contains(tail2);
    }

    //Fifth Question:
    public static <E> void split(CircularSinglyLinkedList<E> x, CircularSinglyLinkedList<E> y , CircularSinglyLinkedList<E> z)
    {
        Node<E> tail1 = x.tail;
        Node<E> tail2 = x.tail.next;
        for (int i = 0; i < x.size; i++) {
            tail2 = tail2.next;
        }
        Node<E> next = tail2.next;
        tail2.next = tail1.next;
        tail1.next = next;
    }
}
