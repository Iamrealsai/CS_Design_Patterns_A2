package studentCoursesBackup.util;

import studentCoursesBackup.binarySearchTree.TreeInterface;
import studentCoursesBackup.myTree.Node;
import java.util.ArrayList;
import java.util.Stack;

public class TreeBuilder implements TreeInterface
{
    private Node masterRoot;//root node for main tree
    private Node backupRoot1;//root node for backup tree 1
    private Node backupRoot2;//root node for backup tree 2

    /**
     *Constructor
     **/
    public TreeBuilder(){
	masterRoot = null;
	backupRoot1 = null;
	backupRoot2 = null;
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
