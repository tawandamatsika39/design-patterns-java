package za.co.udemy.iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

class Node<T>
{
    public T value;
    public Node<T> left, right, parent;

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    public Iterator<Node<T>> preOrder()
    {
        return new NodeIterator<>(this).iterator();
    }
}

class NodeIterator<T> implements Iterable<Node<T>>{

    public ArrayList<Node<T>> arrayOfNodes = new ArrayList<>();
    public Node<T> root;

    public NodeIterator(Node<T> root) {
        this.root = root;
        populateArray();
    }

    public void populateArray(){
        if(root == null){
            return;
        }

        Stack<Node<T>> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (nodeStack.empty() == false){

            Node<T> current = nodeStack.peek();
            arrayOfNodes.add(current);
            nodeStack.pop();

            if (current.right != null) {
                nodeStack.push(current.right);
            }
            if (current.left != null) {
                nodeStack.push(current.left);
            }
        }
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return arrayOfNodes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Node<T>> action) {
        for (Node<T> node : arrayOfNodes) {
            action.accept(node);
        }
    }

    @Override
    public Spliterator<Node<T>> spliterator() {
        return arrayOfNodes.spliterator();
    }
}

class Exercise {
    public static void main(String[] args) {

        Node<Character> root = new Node<>('A');

        //left child
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');

        //           A
        //          / \
        //         B   C
        //        / \   \
        //       D   E   F

        root.left = b;
        root.right = c;
        root.left.left = d;
        root.left.right = e;
        root.right.right = f;

        Iterator<Node<Character>> iterator = root.preOrder();

        while (iterator.hasNext()){
            System.out.println(iterator.next().value);
        }
    }
}
