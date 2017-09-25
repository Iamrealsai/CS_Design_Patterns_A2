package studentCoursesBackup.BST;

public interface TreeInterface
{
    public BSTNodeInterface find(BSTNodeInterface root,int index);
    // public BSTNodeInterface getRootNode();
    public void insertNode(BSTNodeInterface nodeIn);
    public String printInorder();
}
