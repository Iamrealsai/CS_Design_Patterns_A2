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

    /**
     *inserts subject into an existing node or creates a new node if needed
     *@param id the BNumber of the node
     *@param subjectName the String value of the subject
     **/
    public void insert(int id, String subjectName){
	Node newNode;
	if(this.find(id)==null){
	    Node newNode = new Node(id);
	    newNode.insertSubject(subjectName);
	    if(root==null){
		root = newNode;
	    }else{
		Node current = root;
		Node parent;
		while(true){
		    parent = current;
		    if(id<current.getBNumber()){
			current = current.getLeftChild();
			if(current==null){
			    parent.setLeftChild(newNode);
			    return;
			}
		    }else{
			current = current.getRightChild();
			if(current==null){
			    parent.setRightChild(newNode);
			    return;
			}
		    }
		}
	    }
	}else{
	    newNode = find(id);
	    newNode.insertSubject(subjectName);
	}
    }
    
}
