public class Node {
    public Object element;
    public Node left;
    public Node right;

    public Node(Object data) {  // init?
        this.left = null;
        this.right = null;
        this.element = data;
    }

    public Object getData() {
        return this.element;
    }

    public void setData(Object data) {
        this.element = data;
    }

    public Object getNext() {
        return this.right.element;
    }

    public Object getPrevious() {
        return this.left.element;
    }

    public void setNext(Node node) {
        this.right = node;
    }
}