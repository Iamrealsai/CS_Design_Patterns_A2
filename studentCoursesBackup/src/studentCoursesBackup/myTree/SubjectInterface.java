package studentCoursesBackup.myTree;

public interface SubjectInterface
{
    public void registerObserver(ObserverInterface o);
    public void removeObserver(ObserverInterface o);
    public void notifyObserver();
}

