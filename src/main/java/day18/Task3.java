package day18;


public class Task3 {
    public static void main(String[] args) {
        Node root = new Node(20);
        int[] newNodeValues = {14, 23, 11, 16, 22, 27, 5, 15, 18, 24, 150, 8};
        for (int nodeValue : newNodeValues) {
            addNode(nodeValue, root);
        }
        dfs(root);
    }

    public static void addNode(int value, Node root) {
        if (value < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(new Node(value));
            } else {
                addNode(value, root.getLeft());
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node(value));
            } else {
                addNode(value, root.getRight());
            }
        }
    }

    public static void dfs(Node root) {
        if (root.getLeft() != null) {
            dfs(root.getLeft());
            System.out.print(root.getValue() + " ");
            if (root.getRight() != null) {
                dfs(root.getRight());
            }
        } else {
            System.out.print(root.getValue() + " ");
            if (root.getRight() != null) {
                dfs(root.getRight());
            }
        }
    }
}
