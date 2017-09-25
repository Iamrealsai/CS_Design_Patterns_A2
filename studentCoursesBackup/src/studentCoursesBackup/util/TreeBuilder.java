package studentCoursesBackup.util;

import studentCoursesBackup.binarySearchTree.BSTNodeInterface;
import studentCoursesBackup.binarySearchTree.TreeInterface;
import studentCoursesBackup.myTree.Node;

public class TreeBuilder implements TreeInterface
{
    private BSTNodeInterface masterRoot;//root node for main tree
    private BSTNodeInterface backupRoot1;//root node for backup 1 tree
    private BSTNodeInterface backupRoot2;//root node for backup 2 tree

    //----------------TreeInterface--------------------

    /**
     *gets the BSTNodeinterface for a specific BNumber in a specific tree
     *@param root, the root node for a specific tree
     *@param index, the unique index(BNumber) to search for
     *@return the BSTnodeinterface that complies with the index in a specific tree
     **/
    public BSTNodeInterface find(BSTNodeInterface root,int index){
	BSTNodeInterface current = root;
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

    public void insertNode(BSTNodeInterface root,int index){
	BSTNodeInterface node = new Node(index);
	if(find)
    }
    
    //-------------------------------------------------
}
