// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        tree t=new tree();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(70);
        t.insert(5);
        t.insert(75);
       // System.out.println(t.containValue(15));
        //t.preOrder(t.root);
        //t.inOrder(t.root);
        //t.postOrder(t.root);
        //System.out.println(t.min(t.root));
        //System.out.println(t.max(t.root));
        System.out.println(t.height(t.root));
    }
}
class tree
{
    private class Node
    {
        int data;
        Node right;
        Node left;
        Node(int value)
        {
            data=value;
        }
        public String toString()
        {
            return data+"";
        }
    }
    Node root;
    public void insert(int data)
    {
        if(root==null)
        {
            root=new Node(data);
            return;
        }
        var current=root;
        while(true)
        {
            if(current.data>data)
            {
                if(current.left==null)
                {
                    current.left=new Node(data);
                    break;
                }
                current=current.left;
            }
            else if(current.data<data)
            {
                if(current.right==null)
                {
                    current.right=new Node(data);
                    break;
                }
                current=current.right;
            }
        }
    }
    public boolean containValue(int value)
    {
        var current=root;
        while(current!=null) {
            if (current.data > value)
                current = current.left;
            else if (current.data < value)
                current = current.right;
            else
                return true;
        }
        return  false;
    }
    public void preOrder(Node root)
    {
        if(root==null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public void postOrder(Node root)
    {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public int min(Node root)
    {
        if(root.left==null)
            return root.data;
        return min(root.left);
    }
    public int max(Node root)
    {
        if(root.right==null)
            return root.data;
        return max(root.right);
    }
    public int height(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
