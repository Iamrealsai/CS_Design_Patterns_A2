package studentCoursesBackup.myTree;

import studentCoursesBackup.binarySearchTree.BSTNodeInterface;

public interface ObserverInterface
{
    public void update(BSTNodeInterface node,int operationIndex,String sIn);//operationIndex-1 for insert,2 for delete, sIn for the subjectstring;
}
