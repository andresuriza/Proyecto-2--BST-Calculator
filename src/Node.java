/**
 * @author Andres Uriza
 * @author Jose Pablo Esquetini
 *
 * This class creates a node for use in various data structures
 */
public class Node {
    public String data;
    public Node left;
    public Node right;

    /**
     * Constructor calss
     *
     * @param data
     */
    public Node(String data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    /**
     * Returns the data on the node
     * @return
     */
    public Object getData() {
        return this.data;
    }

    /**
     * Gets the node data from the right
     * @return
     */
    public Object getRight() {
        return this.right.data;
    }

    /**
     * Gets the node data from the left
     * @return
     */
    public Object getLeft() {
        return this.left.data;
    }

    /**
     * Sets a value for the right
     * @param node
     */
    public void setRight(Node node) {
        this.right = node;
    }

    /**
     * Sets a value for the left
     * @param node
     */
    public void setLeft(Node node) {
        this.left = node;
    }
}

