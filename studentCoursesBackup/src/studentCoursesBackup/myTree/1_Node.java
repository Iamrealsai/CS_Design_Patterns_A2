package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.BST.BSTNodeInterface;
import studentCoursesBackup.myTree.SubjectInterface;
import studentCoursesBackup.myTree.ObserverInterface;

class Node implements BSTNodeInterface, SubjectInterface, ObserverInterface
{
    private int bNumber; //unique ID
    private ArrayList<String> subjects;//subject list
    private ArrayList<BSTNodeInterface> observers;//for observers
    private BSTNodeInterface leftChild; // left child
    private BSTNodeInterface rightChild;//right child

    /**
     *Constructor
     *@param bNumberin, the BNumber of student
     **/
    public Node(int bNumberIn){
	bNumber = bNumberIn;
	subjects = new ArrayList<String>();
	observers = new ArrayList<BSTNodeInterface>();
	leftChild = null;
	rightChild = null;
    }

    
    
}
