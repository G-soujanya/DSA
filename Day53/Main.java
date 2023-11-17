import java.util.Currency;
import java.util.NoSuchElementException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        tree t=new tree();
        t.insert(18);
        t.insert(15);
        t.insert(30);
        //t.insert(40);
        t.insert(29);
        t.insert(16);
        t.insert(14);
        //System.out.println(t.isFullTree());
        //System.out.println(t.isPerfectTree());
        //System.out.println(t.isCompleteBST());
        t.children(28);
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
    public int noOfLeaf(Node root)
    {
        if(root==null)
            return 0;
        else if(root.left==null && root.right==null)
            return 1;
        return noOfLeaf(root.left)+noOfLeaf(root.right);
    }
    public int size(Node root)
    {
        if(root==null)
            return 0;
        return 1+size(root.left)+size(root.right);
    }
    public void displayLevelWise(Node root)
    {
        if(root==null)
            return;
        if(root==this.root) {
            System.out.print(root.data + " ");
            if(root.left!=null)
                System.out.print(root.left.data + " ");
            else if(root.right!=null)
                System.out.print(root.right.data + " ");
        }
        else
        {
            if(root.left!=null)
                System.out.print(root.left.data+" ");
            if(root.right!=null)
                System.out.print(root.right.data+" ");
        }
        displayLevelWise(root.left);
        displayLevelWise(root.right);
    }
    public void displayLevel(int level,Node root)
    {
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.data+" ");
        else if(level>1)
        {
            displayLevel(level-1,root.left);
            displayLevel(level-1,root.right);
        }
    }
    public void displayBelow(int value)
    {
        if(containValue(value))
        {
            Node n=find(value);
            inOrder(n);
        }
    }
    public boolean isSimilar(Node root1,Node root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1!=null && root2!=null)
            return root1.data==root2.data && isSimilar(root1.left,root2.left) && isSimilar(root1.right,root2.right);
        return false;
    }
    private boolean isBST(Node root,int min,int max)
    {
        if(root==null)
            return true;
        if((root.left!=null && root.left.data<min)|| (root.right!=null && root.right.data>max))
            return false;
        return isBST(root.left,min,root.data-1) && isBST(root.right,root.data+1,max);
    }
    public boolean isBST()
    {
        //this.root.data=100;
        return isBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean containsr(Node root,int value)
    {
        if(root.data==value)
            return true;
        return (root.left!=null && containsr(root.left,value)) || (root.right!=null && containsr(root.right,value));
    }
    public boolean containsr(int value)
    {
        return containsr(this.root,value);
    }
    private boolean isSiblings(Node current,int value1,int value2)
    {
            if(current==null)
                return false;
            if(current.left!=null && current.right!=null) {
                if ((current.left.data == value1 && current.right.data == value2) || (current.left.data == value2 && current.right.data == value1))
                    return true;
            }
            if(current.left!=null)
                if(isSiblings(current.left,value1,value2))
                    return true;
        if(current.right!=null)
            if(isSiblings(current.right,value1,value2))
                return true;
        return false;
    }
    public boolean isSiblings(int min,int max)
    {
        return isSiblings(this.root,min,max);
    }
    private void noSiblingsNodes(Node root)
    {
        if(root==null)
            return;
        if(root.left==null && root.right!=null)
            System.out.println(root.right.data);
        if(root.right==null && root.left!=null)
            System.out.println(root.left.data);
        if(root.left!=null)
            noSiblingsNodes(root.left);
        if(root.right!=null)
            noSiblingsNodes(root.right);
    }
    public void noSiblingsNodes()
    {
        noSiblingsNodes(this.root);
    }
    private boolean isFullTree(Node root)
    {
        if(root==null)
            return true;
        if((root.left==null && root.right==null))
            return true;
        if((root.left==null && root.right!=null) || (root.left!=null && root.right==null))
            return false;
        return isFullTree(root.left) && isFullTree(root.right);
    }
    public boolean isFullTree()
    {
        return isFullTree(this.root);
    }
    private boolean isPerfectTree(Node root)
    {
        int height=height(root);
        double size=noOfLeaf(root);
        double res=Math.pow(2,height);
        return res==size;
    }
    public boolean isPerfectTree()
    {
        return isPerfectTree(this.root);
    }
    private boolean isCompleteBST(Node root,Node parent)
    {
        if(root==null)
            return true;
        if((root.left==null && root.right!=null) || (parent!=null && parent.left!=null && parent.left.left==null && parent.left.right==null && parent.right!=null && (parent.right.left!=null || parent.right.right!=null)))
            return false;
        return isCompleteBST(root.left,root) && isCompleteBST(root.right,root);
    }
    public boolean isCompleteBST()
    {
        return isCompleteBST(this.root,null);
    }
    public void children(int value)
    {
        if(!containValue(value))
        {
            throw new IllegalStateException("Node with given value not present");
        }
        Node node=find(value);
        if(node.left!=null && node.right!=null)
                System.out.println("children are"+node.left.data+" "+node.right.data);
        else if(node.right!=null)
            System.out.println("GIven node has only right child"+node.right.data);
        else if(node.left!=null)
            System.out.println("GIven node has only left child"+node.left.data);
        else
            System.out.println("Given node has no children");
    }
}