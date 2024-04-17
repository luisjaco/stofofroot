public class FruitBT
{
    private BTNode root;
    /* Constructor */
    public FruitBT()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(Fruit fruit)
    {
        root = insert(root, fruit);
    }
    /* Function to insert data recursively */
    private BTNode insert(BTNode node, Fruit data)
    {
        if (node == null)
            node = new BTNode(data);
        else
        {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }
    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    /* Function to search for an element */
    public boolean search(Fruit fruit)
    {
        return search(root, fruit);
    }
    /* Function to search for an element recursively */
    private boolean search(BTNode r, Fruit fruit)
    {
        if (r.getData().equals(fruit))
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), fruit))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), fruit))
                return true;
        return false;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BTNode r)
    {
        if (r != null)
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }
}

class BTNode
{
    BTNode left, right;
    Fruit data;
    /* Constructor */
    public BTNode(Fruit fruit)
    {
        left = null;
        right = null;
        data = fruit;
    }
    /* Function to set left node */
    public void setLeft(BTNode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BTNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(Fruit fruit)
    {
        data = fruit;
    }
    /* Function to get data from node */
    public Fruit getData()
    {
        return data;
    }
}