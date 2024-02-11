//levelwise traversal
 public static List<Integer> levelOrder(TreeNode<Integer> root){
        // Write your code here.
        Queue<TreeNode<Integer>> queue=new ArrayDeque<>();
        ArrayList<Integer> list=new ArrayList<>();
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode<Integer> node=queue.poll();
            list.add(node.data);
            if(node.left!=null)
            queue.add(node.left);
            if(node.right!=null)
            queue.add(node.right);
        }
        return list;
    }
public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        if(root==null)
            return list;
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
            list.add(node.val);
        }
        return list;
    }
public static List< Integer > getInOrderTraversal(TreeNode node) {
        // Write your code here.
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(node==null)
            return list;
        while(true)
        {
            if(node!=null)
            {
                stack.push(node);
                node=node.left;
            }
            else 
            {
                if(stack.isEmpty())
                    break;
                node=stack.pop();
                list.add(node.data);
                node=node.right;
            }
        }
        return list;
    }
//using two stacks
public List<Integer> postorderTraversal(TreeNode node) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        if(node==null)
            return list;
        stack1.push(node);
        while(!stack1.isEmpty())
        {
            node=stack1.pop();
            stack2.push(node);
            if(node.left!=null)
                stack1.push(node.left);
            if(node.right!=null)
                stack1.push(node.right);
        }
        while(!stack2.isEmpty())
            list.add(stack2.pop().val);
        return list;
    }
//using one stack
public List<Integer> postorderTraversal(TreeNode node) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        if(node==null)
            return list;
        stack1.push(node);
        while(!stack1.isEmpty())
        {
            node=stack1.pop();
            list.add(node.val);
            if(node.left!=null)
                stack1.push(node.left);
            if(node.right!=null)
                stack1.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }
//height
if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return 1+Math.max(heightOfBinaryTree(root.left),heightOfBinaryTree(root.right));


//balanced or not
   public boolean isBalanced(TreeNode root) {
        if(bal(root)==-1)
            return false;
        return true;
        
    }
    public int bal(TreeNode node)
    {
        if(node==null)
            return 0;
        int rh=bal(node.right);
        int lh=bal(node.left);
        if(lh==-1 || rh==-1)
            return -1;
        if(Math.abs(lh-rh)>1)
            return -1;
        return Math.max(lh,rh)+1;

    }
public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }
    int max=Integer.MIN_VALUE;
    public int height(TreeNode node)
    {
        if(node==null)
            return 0;
        int lh=height(node.left);
        int rh=height(node.right);
        return 1+Math.max(lh,rh);
    }
    public void diameter(TreeNode node)
    {
        if(node==null)
            return;
        int lh=height(node.left);
        int rh=height(node.right);
        max=Math.max(lh+rh,max);
        diameter(node.left);
        diameter(node.right);
    }

public int diameterOfBinaryTree(TreeNode root) {
        int[] dia=new int[1];
        findMax(root,dia);
        return dia[0];
    }
    public int findMax(TreeNode node,int[] dia)
    {
        if(node==null)
            return 0;
        int lh=findMax(node.left,dia);
        int rh=findMax(node.right,dia);
        dia[0]=Math.max(dia[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
