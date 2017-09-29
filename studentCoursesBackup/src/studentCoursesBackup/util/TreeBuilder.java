package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.binarySearchTree.BinarySearchTree;
import studentCoursesBackup.binarySearchTree.TreeInterface;
import java.util.ArrayList;
import java.util.Stack;

public class TreeBuilder
{
   
    private TreeInterface masterTree;// main tree
    private TreeInterface backupTree1;// backup tree 1
    private TreeInterface backupTree2;// backup tree 2
    private FileProcessor inputFile;//input file
    private FileProcessor deleteFile;//file with deleted courses
    private String line; //line read at each iteration from file

    /**
     *Constructor
     **/
    public TreeBuilder(String inputFileName, String deleteFileName){
	//---------initialization of trees----------
	masterTree = new BinarySearchTree();
	backupTree1 = new BinarySearchTree();
	backupTree2 = new BinarySearchTree();
	//------------------------------------------
	inputFile = new FileProcessor(inputFileName);
	deleteFile = new FileProcessor(deleteFileName);
	//----------insert operation----------------
	line = inputFile.readLine();
	while(line!=null){
	    int tempIndex = getBNumber(line);
	    populateTrees(tempIndex);
	    line = inputFile.readLine();
	}
	line ="";
	//----------delete operation----------------


	//-----------------------------------------
	inputFile.closeAll();
	//----------------------------------------
    }

    //--------------helper functions------------------

    /**
     *returns the BNumber from the read text file
     *@param the string input line
     *@return the BNumber in int format
     **/
    private int getBNumber(String sIn){
	//assuming the format would be 1234:A(course name) always
	return convertToInt(sIn.substring(0,4));
    }

    /**
     *Converts the string input to an Int
     *@param sIn the String input which is a number
     *@return the number in Int format
     **/
    private int convertToInt(String sIn){
	int number=0;
	for(int i=0;i<sIn.length();i++){
	    number = number*10+sIn.charAt(i)-'0';
	}
	return number;
    }

    /**
     *finds the course to be registered for student
     *@param sIn the course module to be entered
     *@return the String name of course if valid, or "" if not
     **/
    private String findCourse(String sIn){
	//assuming there are no formatting issues with input text file
	return String.valueOf(sIn.charAt(sIn.length()-1));
    }

    /**
     *function to populate the three trees, clones nodes if necessary
     *@param the unique BNumber for the required node
     **/
    private void populateTrees(int nodeIndex){
	Node nodeFromMaster = masterTree.find(nodeIndex);
	if(nodeFromMaster==null){
	    //--------------------------------
	    Node masterNode = new Node(nodeIndex);
	    masterNode.insertCourse(findCourse(line));
	    //--------------------------------
	    Node backupNode1=null;
	    Node backupNode2=null;
	    if(masterNode instanceof Cloneable){
		backupNode1 = masterNode.clone();
		backupNode2 = masterNode.clone();
	    }
	    masterTree.insertNode(masterNode);
	    backupTree1.insertNode(backupNode1);
	    backupTree2.insertNode(backupNode2);
	}else{
	    String tempCourse = findCourse(line);
	    nodeFromMaster.insertCourse(tempCourse);
	    //-------------------------------
	    Node backupNodes = backupTree1.find(nodeIndex);
	    backupNodes.insertCourse(tempCourse);
	    //-------------------------------
	    backupNodes = backupTree2.find(nodeIndex);
	    backupNodes.insertCourse(tempCourse);
	}	    
    } 

}
