package problem1.mybst;

import problem1.node.TreeNode;

// to implement BinarySearchTree
public class MyBinarySearchTree
{
    private TreeNode root;

    public MyBinarySearchTree()
    {
        root = null;
    }

    public TreeNode getRoot()
    {
        return root;
    }


    public void insert(int data)
    {
        root = insertRecursive(root, data);
    }

    TreeNode insertRecursive(TreeNode root, int data)
    {
        if (root == null)
        {
            root = new TreeNode(data);
            return root;
        }
        else
            {
            if (root.getData() > data)
            {
                root.setLeft(insertRecursive(root.getLeft(), data));
            }
            else if (root.getData() < data)
            {
                root.setRight(insertRecursive(root.getRight(), data));
            }
            return root;
        }
    }


    public void traverseInOrder()
    {
        traverseInOrderRec(root);
        System.out.println();
    }

    void traverseInOrderRec(TreeNode root)
    {
        if (root != null)
        {
            traverseInOrderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            traverseInOrderRec(root.getRight());
        }
    }

    public int traverseLeft()
    {
        int noOfNodesNotHavingLeftChild = traverseLeftNodesRec(root, false);
        System.out.println();
        return noOfNodesNotHavingLeftChild;
    }

    int traverseLeftNodesRec(TreeNode root, boolean fromLeft)
    {
        int count = 0;
        if (root != null)
        {
            if (fromLeft == true)
                System.out.print(root.getData() + " ");
            if (root.getLeft() == null)
                count++;
            return count = count + traverseLeftNodesRec(root.getLeft(), true) + traverseLeftNodesRec(root.getRight(), false);
        }
        return count;
    }

    public void traversePreOrder()
    {
        traversePreOrderRec(root);
        System.out.println();
    }

    void traversePreOrderRec(TreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.getData() + " ");
            traversePreOrderRec(root.getLeft());
            traversePreOrderRec(root.getRight());
        }
    }

    public void traversePostOrder()
    {
        traversePostOrderRec(root);
        System.out.println();
    }


    void traversePostOrderRec(TreeNode root)
    {
        if (root != null)
        {
            traversePostOrderRec(root.getLeft());
            traversePostOrderRec(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public boolean search(int data)
    {
        TreeNode node = searchRec(root, data);
        if (node == null)
        {
            return false;
        }
        else if (node.getData() == data)
        {
            return true;
        }
        else
            {
            return false;
        }
    }

    public TreeNode searchRec(TreeNode root, int data)
    {
        if (root == null || root.getData() == data)
            return root;

        if (root.getData() > data)
            return searchRec(root.getLeft(), data);

        return searchRec(root.getRight(), data);
    }

    public int count()
    {
        return countRec(root);
    }

    public int countRec(TreeNode root)
    {
        if (root == null)
            return 0;
        int count = 0;
        count++;
        count += (countRec(root.getLeft()) + countRec(root.getRight()));
        return count;
}
}
