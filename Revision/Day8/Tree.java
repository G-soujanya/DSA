public class Tree {
    private class Node
    {
        int data;
        Node left;
        Node right;
        Node(int value)
        {
            data=value;
        }
        public String toString()
        {
            return data+" ";
        }
    }
    Node root;
    public void insert(int value)
    {
        Node node=new Node(value);
        if(root==null)
        {
            root=node;
            return;
        }
        var current=root;
        while (true)
        {
            if(current.data>value)
            {
                if(current.right==null)
                {
                    current.right = node;
                    break;
                }
                current=current.right;
            }
            else
            {
                if(current.left==null)
                {
                    current.left=node;
                    break;
                }
                current=current.left;
            }
        }
    }
    public boolean containsValue(int value)
    {
        var current=root;
        while (current!=null)
        {
            if(current.data==value)
            {
                return true;
            }
            if(current.data>value)
                current=current.left;
            else
                current=current.right;
        }
        return false;
    }
}
