package leandro.ds.stack;

public class Node {
    private Product product;
    private Node next;

    public Node(Product product)
    {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
