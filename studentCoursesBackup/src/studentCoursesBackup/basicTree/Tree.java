package studentCoursesBackup.basicTree;

import studentCoursesBackup.myTree;

class Tree
{
    private Node root; // the only data field in the tree

    /**
     *Constructor
     **/
    public Tree(){
	root = null;
    }

    /**
     *finds the node with the respective BNumber
     *@param key the BNumber of the node to be found
     *@return the node 
     **/
     public Node find(int key){
	Node current = root;
	while(current.getBNumber()!=key){
	    if(key<current.getBNumber()){
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
}
