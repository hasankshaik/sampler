import java.util.LinkedList;

public class ReverseSinglyLinkedList {
    private static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        linkedList.add("h");
        linkedList.add("a");
        linkedList.add("s");
        linkedList.add("a");
        linkedList.add("n");

        linkedList.stream().forEach(System.out::print);
        System.out.println();
        linkedList.descendingIterator().forEachRemaining(System.out::print);


    }
}

class SinglyLinkedList<E> {
    private Node<E> head;

    public void add(E e ){
        Node<E> node = new Node<>(e, null);
        Node<E> pointer=head;
        while (true){
            if(pointer == null){
                head = node;
                break;
            } else if(pointer.getNextNodeRef() == null){
                pointer.setNextNodeRef(node);
                break;
            } else {
                pointer = pointer.getNextNodeRef();
            }
        }


    }

    public void traverse(){

        Node<E> pointer = head;
        while(true){
            if(pointer == null){
                break;
            }
            System.out.print(pointer.getValue()+"\t");
            pointer = pointer.getNextNodeRef();
        }
    }

    public void reverse(){

        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;
        while(current != null){
            next = current.getNextNodeRef();
            current.setNextNodeRef(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }
}

class Node<E> implements Comparable<E> {
    private E value;
    private Node<E> nextNodeRef;

    public Node(E value, Node<E> nextNodeRef) {
        this.value = value;
        this.nextNodeRef = nextNodeRef;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNextNodeRef() {
        return nextNodeRef;
    }

    public void setNextNodeRef(Node<E> nextNodeRef) {
        this.nextNodeRef = nextNodeRef;
    }

    @Override
    public int compareTo(E o) {
        if (o == this.value) return 0;
        return 1;
    }
}

