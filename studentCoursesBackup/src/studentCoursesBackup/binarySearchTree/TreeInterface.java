package studentCoursesBackup.binarySearchTree;

import studentCoursesBackup.myTree.Node;

public interface TreeInterface
{
    public Node find(Node root,int index);
    // public BSTNodeInterface getRootNode();
    public void insertNode(Node root,int index);
    public String printNodes(Node root);
}
