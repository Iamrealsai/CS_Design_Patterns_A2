package studentCoursesBackup.myTree;

public interface SubjectInterface
{
    public void registerObserver(ObserverI o);
    public void removeObserver(ObserverI o);
    public void notifyObserver();
}

