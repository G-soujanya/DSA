public class Main {
    public static void main(String[] args) {
        tree t=new tree();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(70);
        t.insert(5);
        System.out.println(t.containValue(15));
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
}
