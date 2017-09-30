package studentCoursesBackup.binarySearchTree;

import studentCoursesBackup.binarySearchTree.TreeInterface;
import studentCoursesBackup.myTree.Node;
import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree implements TreeInterface
{
    private Node root; //root node of tree

    /**
     *constructor
     **/
    public BinarySearchTree(){
	root = null;
    }

    /**
     *set method for root
     *@param the new root node
     **/
    public void setRootNode(Node newRoot){
	root = newRoot;
    }

    /**
     *get mehtod for root
     *@return the current root node
     **/
    public Node getRootNode(){
	return root;
    }

    //------------TreeInterface methods----------------

    /**
     *gets the Node for a specific BNumber in a specific tree
     *@param index, the unique index(BNumber) to search for
     *@return the Node that complies with the index in a specific tree
     **/
    public Node find(int index){
	Node current = root;
	if(root==null){
		return null;
	}
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
     *inserts a created node with a specific index into a given tree
     *@param newNode, the root node for the required tree
     **/
    public void insertNode(Node newNode){
	int index = newNode.getNodeIndex();
	if(find(index)==null){
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
     *@return the string output of traversal
     **/
    public String printNodes(){
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
		    current = tempNode.getRightChild();
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
