package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import java.util.ArrayList;
import java.util.Stack;

public class TreeBuilder
{
    //private Node masterRoot;//root node for main tree
    //private Node backupRoot1;//root node for backup tree 1
    // private Node backupRoot2;//root node for backup tree 2
    private FileProcessor inputFile;//input file
    private FileProcessor deleteFile;//file with deleted courses
    private String line; //line read at each iteration from file

    /**
     *Constructor
     **/
    public TreeBuilder(String inputFileName, String deleteFileName){
	//---------initialization of nodes----------
	//	masterRoot = null;
	//	backupRoot1 = masterRoot.clone();
	//	backupRoot2 = masterRoot.clone();
	//------------------------------------------
	inputFile = new FileProcessor(inputFileName);
	deleteFile = new FileProcessor(deleteFileName);
	//-----------------------------------------
	line = inputFile.readLine();
	while(line!=null){
	    temp nodeIndex = getBNumber(line);
	    // add afunction from tree interface to see-> checkNodeExistence(root,index)
	    //aftethat populate make nodes and populate
	    //else just populate subjects only
	    
	    //change so that there are three seperate trees
	    //for insert node, insert the node after clone 
	    //-> insertNode(NewNode){}-> insert cant create a new node
	    //that part should be done by clone
	    
	}
	
	
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
    private String registerForCourse(String sIn){
	//assuming there are no formatting issues with input text file
	Char temp = sIn.charAt(sIn.length()-1);
	String compareStr = "ABCDEFGHIJK";
	for(int i=0;i<compareStr.length();i++){
	    if(temp==compareStr.charAt(i)){
		return (String) temp;
	    }
	}
	return "";
    }

   }
