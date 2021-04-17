import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private class Node{

        public Item item;
        public Node next;
        public Node(Item item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    private Node first;

    public void add(Item item){
        Node oldfirst = first;
        first = new Node(item, oldfirst);
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
