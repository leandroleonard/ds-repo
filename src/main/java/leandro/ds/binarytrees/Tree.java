package leandro.ds.binarytrees;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(int value) {
        if (root == null)
            root = new Node(value);
        else {
            if (isPresent(value))
                return;
            insertNode(root, value);
        }
    }

    public void insertNode(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                node.left.level = node.level + 1;
                node.left.column = node.column - 1;
            } else
                insertNode(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                node.right.level = node.level + 1;
                node.right.column = node.column + 1;
            } else
                insertNode(node.right, value);
        }
    }

    public boolean isPresent(int value) {
        for (Node node : getAllNode())
            if (node.value == value)
                return true;

        return false;
    }

    public List<Node> getAllNode() {
        if (isEmpty())
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Node> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return list;
    }

    public List<Model> getValues() {
        List<Model> list = new ArrayList<>();
        for (Node model : getAllNode())
            list.add(new Model(model.value, model.level, model.column));

        return list;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node Node) {
        if (Node != null) {
            System.out.println("value: " + Node.value + ", Nível: " + Node.level + ", column: " + Node.column);
            preOrder(Node.left);
            preOrder(Node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node Node) {
        if (Node != null) {
            postOrder(Node.left);
            postOrder(Node.right);
            System.out.println("value: " + Node.value + ", Nível: " + Node.level + ", column: " + Node.column);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public String getInOrder() {
        return getInOrder(root);
    }

    private void inOrder(Node Node) {
        if (Node != null) {
            inOrder(Node.left);
            System.out.println("value: " + Node.value + ", Nível: " + Node.level + ", column: " + Node.column);
            inOrder(Node.right);
        }
    }

    private String getInOrder(Node Node) {
        String list = "";
        if (Node != null) {
            getInOrder(Node.left);
            System.out.println("value: " + Node.value + ", Nível: " + Node.level + ", column: " + Node.column);
            list += Node.value;
            getInOrder(Node.right);
            list += Node.value;
        }
        return list;
    }

    public void largeSearch() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("value: " + node.value + ", Nível: " + node.level + ", Coluna: " + node.column);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public List<Integer> preOrderToList() {
        List<Integer> list = new ArrayList<>();
        preOrderToList(root, list);
        return list;
    }

    private void preOrderToList(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.getValue());
            preOrderToList(node.left, list);
            preOrderToList(node.right, list);
        }
    }

    public List<Integer> inOrderToList() {
        List<Integer> list = new ArrayList<>();
        inOrderToList(root, list);
        return list;
    }

    private void inOrderToList(Node node, List<Integer> list) {
        if (node != null) {
            inOrderToList(node.left, list);
            list.add(node.value);
            inOrderToList(node.right, list);
        }
    }

    public List<Integer> posOrderToList() {
        List<Integer> list = new ArrayList<>();
        posOrderToList(root, list);
        return list;
    }

    private void posOrderToList(Node node, List<Integer> list) {
        if (node != null) {
            posOrderToList(node.left, list);
            posOrderToList(node.right, list);
            list.add(node.value);
        }
    }

    public void destroy() {
        destroyNode(root);
        root = null;
    }

    private void destroyNode(Node node) {
        if (node != null) {
            destroyNode(node.left);
            destroyNode(node.right);
            node.left = null;
            node.right = null;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
}
