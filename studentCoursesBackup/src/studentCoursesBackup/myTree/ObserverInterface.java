package studentCoursesBackup.myTree;

public interface ObserverInterface
{
    public void update(ObserverInterface o,int operationIndex,String sIn)//operationIndex-1 for insert,2 for delete, sIn for the subjectstring;
}
