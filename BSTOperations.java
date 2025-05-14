import java.util.*;

class Main{
    public static void main(String ags[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        
        Node root = null;
        for(int i=0; i < n; i++){
            int key = sc.nextInt();
            root = insert(root, key);
        }
        
        System.out.println("Enter the choice: ");
        int c = sc.nextInt();
        
        switch(c){
            case 1:
                inorder(root);
                break;
            case 2:
                System.out.println("Enter the key: ");
                int key = sc.nextInt();
                insert(root, key);
                inorder(root);
                break;
            case 3:
                System.out.println("Enter the key: ");
                key = sc.nextInt();
                Node res = search(root, key);
                if(res != null){
                    System.out.println("Element found");
                }
                else{
                    System.out.println("Element not found");
                }
                break;
            case 4:
                int h = height(root);
                System.out.println("Height of tree: "+ h);
                break;
            case 5:
                levelT(root);
                break;
            case 6:
                mirror(root);
                inorder(root);
                break;
            case 7:
                System.out.println("Enter the key: ");
                key = sc.nextInt();
                delete(root, key);
                inorder(root);
                break;
            default:
                break;
        }
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }
        if(root.data > key){
            root.left = insert(root.left, key);
        }
        else if(root.data < key){
             root.right = insert(root.right, key);
        }
        return root;
    }
    
    public static Node search(Node root, int key){
        if(root == null){
            return null;
        }
        if(root.data > key){
            root.left = search(root.left, key);
        }
        else if(root.data < key){
            root.right = search(root.right, key);
        }
        return root;
    }
    
    public static int height(Node root){
        if(root == null){
            return -1;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        return Math.max(h1, h2)+1;
    }
    
    public static Node levelT(Node root){
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            root = q.poll();
            System.out.print(root.data+" ");
            
            if(root.left != null){
                q.add(root.left);
            }
            if(root.right != null){
                q.add(root.right);
            }
        }
        return root;
    }
    
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;
    }
    
    public static Node delete(Node root, int key){
        if(root == null){
            return root;
        }
        if(root.data > key){
            root.left = delete(root.left, key);
        }
        else if(root.data < key){
            root.right = delete(root.right, key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                Node temp = succ(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }
    
    public static Node succ(Node root){
        if(root.left != null){
            root = root.left;
        }
        return root;
    }
}

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
