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
    private int operationIndex; // 1 if insert, 2 if delete

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
	operationIndex = 0;
    }

    //-----------------------------------------------
    /**
     *gets the index of the node
     *@return the index(BNumber)
     **/
    public int getNodeIndex(){
	return this.bNumber;
    }

    /**
     *gets the right child of the node
     *@return the right child
     **/
    public BSTNodeInterface getRightChild(){
	return this.rightChild;
    }

    /**
     *setter for right child
     *@param nodeIn, the node to be added
     **/
    public void setRightChild(BSTNodeInterface nodeIn){
	rightChild = nodeIn;
    }

    /**
     *get method for left child
     *@return the left child
     **/
    public BSTNodeInterface getLeftChild(){
	return this.leftChild;
    }

    /**
     *sets left child
     *@param nodeIn, the left child node
     **/
    public void setLeftChild(BSTNodeInterface nodeIn){
	leftChild = nodeIn;
    }

    
    
    //-----------------------------------------------
}
