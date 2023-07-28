package leandro.ds.queue;

public class Node {
    Person person;
    Node next;
    
    public Node(){}

    public Node(Person person) {
        this.person = person;
        this.next = null;
    }

}
