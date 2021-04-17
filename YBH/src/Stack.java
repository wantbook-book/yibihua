import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private class Node{
        public Item item;
        public Node next;
        public Node(Item item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    private Node first;

    public void push(Item item){
        Node oldfirst =first;
        first = new Node(item, oldfirst);
    }

    public Item pop(){
        if(first == null) return null;//注意空指针异常
        Item item = first.item;
        first = first.next;
        return item;
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

    public static void main(String[] args) {
        Stack<Edge> edgeList = new Stack<>();
        edgeList.push(new Edge(1, 2));
        edgeList.push(new Edge(3, 4));
        edgeList.push(new Edge(5, 6));
        for(Edge e: edgeList){
            System.out.println(e);
        }
        edgeList.pop();
        for(Edge e: edgeList){
            System.out.println(e);
        }
    }
}
