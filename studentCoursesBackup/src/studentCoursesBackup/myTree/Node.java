package studentCoursesBackup.myTree;

import java.util.ArrayList;

class Node
{
    private int bNumber; // the Bnumber of students
    private ArrayList<Integer> refID; // list of reference Ids of observers
    private ArrayList<String> subjects; // list of subjects taken by students
    private Node leftChild;
    private Node rightChild;

    /**
     *Constructor
     *@param the BNumber of student
     **/
    public Node(int bNumberIn){
	bNumber = bNumberIn;
	subjects = new ArrayList<String>();
	refID = new ArrayList<Integer>();
	leftChild = null;
	rightChild = null;
    }

    /**
     *gets BNumber of student
     *@return the BNumber
     **/
    public int getBNumber(){
	return bNumber;
    }
    /*
      public void setBNumber(int xIn){
      bNumber = xIn;
      }*/

    /**
     *gets the left child of node
     *@return the left child node
     **/
    public Node getLeftChild(){
	return leftChild;
    }

    /**
     *sets the left child for node
     *@param the left child
     **/
    public void setLeftChild(Node nodeIn){
	leftChild = nodeIn;
    }

    /**
     *gets the right child of node
     *@return the right child
     **/
    public Node getRightChild(){
	return rightChild;
    }

    /**
     *inserts the subject for each student
     *@param s the String name of the subject
     **/
    public void insertSubject(String s){
	if(!subjects.contains(s)){
	    subjects.add(s);
	}
    }

}
