import java.util.NoSuchElementException;

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
        t.insert(18);
        t.insert(29);
        t.insert(4);
        t.insert(19);
       // System.out.println(t.containValue(15));
        //t.preOrder(t.root);
        //t.inOrder(t.root);
        //t.postOrder(t.root);
        //System.out.println(t.min(t.root));
        //System.out.println(t.max(t.root));
        //System.out.println(t.height(t.root));
        //System.out.println(t.leftChild(17));
        //System.out.println(t.grandRightChild(70));
        //System.out.println(t.parent(75));
        System.out.println(t.grandParent(75));
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
    private Node find(int value)
    {
        if(!containValue(value))
            throw new NoSuchElementException();
        var current=root;
        while(true)
        {
            if(current.data==value)
                break;
            if(value>current.data)
                current=current.right;
            else
                current=current.left;
        }
        return current;
    }

    public int leftChild(int value)
    {
        if(find(value).left==null)
            throw new IllegalStateException("no left child");
        return find(value).left.data;
    }
    public int rightChild(int value)
    {
        if(find(value).right==null)
            throw new IllegalStateException("no right child");
        return find(value).right.data;
    }
    public int grandRightChild(int value)
    {
        if(find(value).right==null || find(value).right.right==null)
            throw new IllegalStateException("no grand right child");
        return find(value).right.right.data;
    }
    public int grandLeftChild(int value)
    {
        if(find(value).left==null || find(value).left.left==null)
            throw new IllegalStateException("no grand left child");
        return find(value).left.left.data;
    }
    public int parent(int value)
    {
        if(!containValue(value))
            throw new NoSuchElementException();
        var current=root;
        while(true)
        {
            if((current.left!=null && current.left.data==value) || (current.right!=null && current.right.data==value))
                return current.data;
            if(value>current.data)
                current=current.right;
            else
                current=current.left;
        }
    }
    public int grandParent(int value)
    {
        if(!containValue(value))
            throw new NoSuchElementException();
        var current=root;
        while(true)
        {
            if((current.left.left!=null && current.left.left.data==value) || (current.left.right!=null && current.left.right.data==value) || (current.right.left!=null &&current.right.left.data==value) || (current.right.right!=null &&current.right.right.data==value))
                return current.data;
            if(value>current.data)
                current=current.right;
            else
                current=current.left;
        }
    }
}
