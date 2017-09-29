package studentCoursesBackup.binarySearchTree;

import studentCoursesBackup.myTree.Node;

public interface TreeInterface
{
    Node find(int index);
    // public BSTNodeInterface getRootNode();
    void insertNode(Node root,int index);
    String printNodes(Node root);
}
