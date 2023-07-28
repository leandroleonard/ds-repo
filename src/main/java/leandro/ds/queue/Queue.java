package leandro.ds.queue;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Queue {
    Node head;
    Node tail;

    public Queue()
    {
        head = null;
        tail = null;
    }

    public void insert(Person person)
    {
        Node tempNode = new Node(person);
        if(head == null){
            head = tempNode;
            tail = tempNode;
        }else{
            tail.next = tempNode;
            tail = tempNode;
        }
    }

    public void insertAtPosition(int position, Person person)
    {
        if(position < 0 || position > size())
            throw new IllegalArgumentException("Invalid Position");

        if(position == 0){
            Node newNode = new Node(person);
            newNode.next = head;
            head = newNode;
            if(tail == null)
                tail = newNode;
        }else{
            Node currentNode = head;
            for(int i = 0; i < position; i++)
                currentNode = currentNode.next;
            
            Node newNode = new Node(person);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            if(currentNode == tail)
                tail = newNode;
        }
    }

    public Person remove()
    {
        if(isEmpty())
            throw new IllegalStateException("The queue is empty");
        
        Person removedPerson = head.person;
        
        head = head.next;
        
        if(head == null)
            tail = null;
        
        return removedPerson;
    }

    public List<Person> getAll()
    {
        if(isEmpty())
            return null;
        
        List<Person> list = new ArrayList<>();
        Node currentNode = head;

        while(currentNode.next != null)
        {
            list.add(currentNode.person);
            currentNode = currentNode.next;
        }

        return list;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int size()
    {
        int count = 0;
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            count++;
        }
        return count;
    }
}
