package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.myTree.SubjectInterface;
import studentCoursesBackup.myTree.ObserverInterface;

public class Node implements SubjectInterface, ObserverInterface
{
    private int bNumber; //unique ID
    private ArrayList<String> courses;//course list
    private ArrayList<ObserverInterface> observers;//for observers
    private Node leftChild; // left child
    private Node rightChild;//right child
    private int operationIndex; // 1 if insert, 2 if delete

    /**
     *Empty Constructor for initial root nodes
     **/
    public Node(){
	subjects = new ArrayList<String>();
	observers = new ArrayList<Node>();
	leftChild = null;
	rightChild = null;
	operationIndex = 0;	
    }
    
    /**
     *Constructor for specific node
     *@param bNumberin, the BNumber of student
     **/
    public Node(int bNumberIn){
	bNumber = bNumberIn;
	subjects = new ArrayList<String>();
	observers = new ArrayList<Node>();
	leftChild = null;
	rightChild = null;
	operationIndex = 0;
    }

    /**
     *gets index for last operation, 1 for insertion & 2 for deletion
     *@return the int value corresponding to operation
     **/
    private int getLastOperation(){
	return operationIndex;
    }

    /**
     *sets the int flag for last operation, 1 for insertion & 2 for deletion
     *@param the int index to be updated
     **/
    private void setLastOperation(int iIn){
	operationIndex = iIn;
    }

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
    public Node getRightChild(){
	return this.rightChild;
    }

    /**
     *setter for right child
     *@param nodeIn, the node to be added
     **/
    public void setRightChild(Node nodeIn){
	rightChild = nodeIn;
    }

    /**
     *get method for left child
     *@return the left child
     **/
    public Node getLeftChild(){
	return this.leftChild;
    }

    /**
     *sets left child
     *@param nodeIn, the left child node
     **/
    public void setLeftChild(Node nodeIn){
	leftChild = nodeIn;
    }

    /**
     *inserts Course for a specific node
     *@param the course to be inserted
     **/
    public void insertCourse(String sIn){
	if(!subjects.contains(sIn)){
	    subjects.add(sIn);
	    // this.setLastOperation(1);// 1 for insertion
	}
	this.setLastOperation(1);//1 for insertion
	//ignores existing values
    }

    /**
     *deletes a course from a specific node
     *@param the course to be deleted
     **/
    public void deleteCourse(String sIn){
	if(subjects.contains(sIn)){
	    subjects.remove(subjects.indexOf(sIn));
	    // this.setLastOperation(2);//2 for deletion
	}
	this.setLastOperation(2);//2 for deletion
	//ignores non-existant deletions
    }

    /**
     *gets all subject list for a node
     *@return the arraylist containing all subjects
     **/
    public ArrayList<String> getAllSubjects(){
	return subjects;
    }
    
    //-------------------Observer Interface--------------------------

    /**
     *updates observer as to delete or insert a subject
     *@param o the ObserverInterface
     *@param operationindex the int flag to decide to delete(2) or insert(1)
     *@param sIn, the subject name to be inserted or deleted
     **/
    public void update(BSTNodeInterface node, int operationIndex, String sIn){
	/*if(!observers.isEmpty()){
	  if(operationIndex==1){
	  for(ObserverInterface temp : observers){
	  temp.insertSubject(sIn);
	  }
	  }else if(operationIndex==2){
	  for(ObserverInterface temp : observers){
	  temp.deleteSubject(sIn);
	  }
	  }
	  }*/
	//this.setLastOperation(0);//resets index flag after operation
	if(operationIndex==1){
	    node.insertSubject(sIn);
	}else if(operationIndex==2){
	    node.deleteSubject(sIn);
	}
    }

    //-------------------Subject Interface---------------------------

    /**
     *adds observers to ArrayList
     *@param the ObserverInterface to be added
     **/
    public void registerObserver(BSTNodeInterface o){
	observers.add(o);
    }

    /**
     *removes observer from ArrayList
     *@param the Observerinterface to be removed
     **/
    public void removeObserver(BSTNodeInterface o){
	if(observers.contains(o)){
	    observers.remove(o);
	}
    }

    /**
     *updates state of all Observers
     *@param operationIndex - 1 for insertion, 2 for deletion
     *@param sIn, the subject name to be inserted or deleted
     **/
    public void notifyAll(int operationIndex,String sIn){
	if(!observers.isEmpty()){
	    for(BSTNodeInterface temp : observers){
		update(temp,operationIndex,sIn);
	    }
	}
	this.setLastOperation(0);//resets index flag
    }
    


    
}
