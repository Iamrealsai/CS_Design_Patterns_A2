package studentCoursesBackup.myTree;

import studentCoursesBackup.binarySearchTree.BSTNodeInterface;

public interface SubjectInterface
{
    public void registerObserver(BSTNodeInterface o);
    public void removeObserver(BSTNodeInterface o);
    public void notifyAll(int operationIndex, String sIn);
}

