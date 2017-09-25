package studentCoursesBackup.BST;

public interface BSTNodeInterface
{
    public BSTNodeInterface getRightChild();
    public void setRightChilde(BSTNodeInterface nodeIn);
    public BSTNodeInterface getLeftChild();
    public void setLeftChild(BSTNodeInterface nodeIn);
    public int getLastOperation();//temporary method-> to see if node deleted Or inserted in last occuource
    public int setLastOperation(int iIn);//temporary method -> sets the last operation 1-for insertion, 2-for deletion
}
