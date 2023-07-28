package leandro.ds.stack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public void push(Product product) {
        Node newNode = new Node(product);
        newNode.setNext(top);
        top = newNode;
    }

    public Product pop() {
        if (isEmpty())
            return null;
        Product product = top.getProduct();
        top = top.getNext();

        return product;
    }

    public List<Product> get() {
        List<Product> list = new ArrayList<>();
        

        Node currentNode = top;

        while (currentNode != null) {
            list.add(0, currentNode.getProduct());
            currentNode = currentNode.getNext();
        }

        return list;
    }
    
    public int total() {
        int total = 0;
        Node currentNode = top;
        while (currentNode != null) {
            total += currentNode.getProduct().getWeight();
            currentNode = currentNode.getNext();
        }
        return total;
    }

    public void popAll() {
        while (!isEmpty())
            pop();
    }

    public boolean isEmpty() {
        return top == null;
    }
}
