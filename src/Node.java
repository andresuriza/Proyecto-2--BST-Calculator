public class Node {
    public String data;
    public Node left;
    public Node right;

    public Node(String data) {  // init?
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public Object getRight() {
        return this.right.data;
    }

    public Object getLeft() {
        return this.left.data;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setLeft(Node node) {
        this.left = node;
    }
}

