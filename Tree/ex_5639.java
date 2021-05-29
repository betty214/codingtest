package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_5639 {
	static class Node {
        int now;
        Node left, right;

        Node(int index) {
            this.now = index;
        }

        Node(int now, Node left, Node right) {
            this.now = now;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.now) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.now);
    }
}
