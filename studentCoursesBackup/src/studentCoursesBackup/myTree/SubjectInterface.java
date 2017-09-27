package studentCoursesBackup.myTree;

public interface SubjectInterface
{
    public void registerObserver(ObserverInterface oIn);
    public void removeObserver(ObserverInterface oIn);
    public void notifyAll(String sIn);
}

