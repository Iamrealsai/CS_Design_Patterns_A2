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

    //------------TreeInterface mthods----------------
    
}
