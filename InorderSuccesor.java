
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class InorderSuccesor {
    public static Node inOrdersuccesor(Node root, Node x){
        if(root == null){
            return null;
        }
        if(root.data > x.data){
            Node inordersuccesor = inOrdersuccesor(root.left, x);
           

            if(inordersuccesor != null){
                return inordersuccesor;
            }
            return root;
        }

        if(root.data < x.data){
            Node inordersuccesor = inOrdersuccesor(root.right, x);
            return inordersuccesor;
        }
            return justGreater(root.right);
    }
    public static Node justGreater(Node root){
        if(root == null){
            return null;
        }
        if(root.left != null){
            return justGreater(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        // Constructing the Binary Search Tree
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
       // root.left.left = new Node(5);
        //root.left.right = new Node(15);
        //root.right.left = new Node(25);
        //root.right.right = new Node(35);

        Node x = root; // Example: Node with value 15

        Node successor = inOrdersuccesor(root, x);
        if (successor != null) {
            System.out.println("Inorder Successor of " + x.data + " is: " + successor.data);
        } else {
            System.out.println("No Inorder Successor found for " + x.data);
        }
    }
}
