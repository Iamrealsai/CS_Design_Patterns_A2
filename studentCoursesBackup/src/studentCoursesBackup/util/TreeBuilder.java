package studentCoursesBackup.util;

import studentCoursesBackup.binarySearchTree.TreeInterface;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import java.util.ArrayList;
import java.util.Stack;

public class TreeBuilder implements TreeInterface
{
    private Node masterRoot;//root node for main tree
    private Node backupRoot1;//root node for backup tree 1
    private Node backupRoot2;//root node for backup tree 2
    private FileProcessor inputFile;//input file
    private FileProcessor deleteFile;//file with deleted courses
    private String line; //line read at each iteration from file

    /**
     *Constructor
     **/
    public TreeBuilder(String inputFileName, String deleteFileName){
	//---------initialization of nodes----------
	masterRoot = null;
	backupRoot1 = masterRoot.clone();
	backupRoot2 = masterRoot.clone();
	//------------------------------------------
	inputFile = new FileProcessor(inputFileName);
	deleteFile = new FileProcessor(deleteFile);
	//-----------------------------------------
	line = inputFile.readLine();
	while(line!=null){
	    temp nodeIndex = getBNumber(line);
	    
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
    
    //----------------TreeInterface--------------------

    /**
     *gets the Node for a specific BNumber in a specific tree
     *@param root, the root node for a specific tree
     *@param index, the unique index(BNumber) to search for
     *@return the Node that complies with the index in a specific tree
     **/
    public Node find(Node root,int index){
	Node current = root;
	while(current.getNodeIndex()!=index){
	    if(index<current.getNodeIndex()){
		current = current.getLeftChild();
	    }else{
		current = current.getRightChild();
	    }
	    if(current==null){
		return null;
	    }
	}
	return current;
    }

    /**
     *inserts a new node with a specific into a given tree
     *@param root, the root node for the required tree
     *@param index, the unique BNumber of student
     **/
    public void insertNode(Node root,int index){
	if(find(root,index)==null){
	    Node newNode = new Node(index);
	    if(root == null){
		root = newNode;
	    }else{
		Node current = root;
		Node parent;
		while(true){
		    parent = current;
		    if(index<current.getNodeIndex()){
			current = current.getLeftChild();
			if(current == null){
			    parent.setLeftChild(newNode);
			    break;
			}
		    }else{
			current = current.getRightChild();
			if(current == null){
			    parent.setRightChild(newNode);
			    break;
			}
		    }
		}
	    }
	}
    }

    /**
     *returns a string of all nodes in acsending order
     *@param root, the root of the tree to be traversed
     *@return the string output of traversal
     **/
    public String printNodes(Node root){
	String output="";
	try{
	    if(root == null){
		throw new RuntimeException("tree is empty");
	    }
	    Stack<Node> temp = new Stack<Node>();
	    Node current = root;
	    while(!temp.isEmpty() || current !=null){
		if(current !=null){
		    temp.push((Node) current);
		    current = current.getLeftChild();
		}else{
		    Node tempNode = temp.pop();
		    ArrayList<String> courseList = tempNode.getAllCourses();
		    output += tempNode.getNodeIndex()+": ";
		    if(!courseList.isEmpty()){
			for(int i=0;i<courseList.size()-1;i++){
			    output += courseList.get(i)+", ";
			}
			output += courseList.get(courseList.size()-1);
		    }
		    output += "\n";    
		}
	    }
	}catch(RuntimeException e){
	    e.printStackTrace();
	    System.exit(1);
	}
	return output;
    }
    
    //-------------------------------------------------
}
