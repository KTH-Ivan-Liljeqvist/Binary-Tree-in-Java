/**
 * This class is a representation of a binary tree.
 * The tree consists of nodes.
 * The root node is on the top.
 * Nodes that are smaller than their parents are placed on the left.
 * Nodes that are bigger than parents are placed on the right.
 * 
 * @author Ivan Liljeqvist
 * @version 16-02-2015
 */
public class Tree<T extends Comparable <T>> { 
    private int size; // Number of elements in list.
    public Node<T> root;
    
    /**
     * Class representing a tree node.
     */
    
    private static class Node<T extends Comparable<T>> {
        public T data;
        public Node<T> left;
        public Node<T> right;
        
        /**
         * Creates an empty tree.
         */
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right=null;
        }
        
        /**
         * Returns the data of this node as a string.
         */
        public String toString(){
        	return this.data.toString();
        }
    }
    
    /**
     * A method used to insert data into the tree.
     * You pass in the data you want to be inserted.
     * @return true if added successfully, false if failed. ex: duplicates found and therefore not added
     * 
     * Tidskomplexiteten för denna metod är O(n). I värsta fall ligger alla element på rad efter varandra utan att grena sig och då måste man gå igenom alla element för att lägga till nya elementet sist.
     */
    
    public boolean add(T data){
    	
    	if(data==null){
    		return false;
    	}
    	
		Node<T> toAdd=new Node<T>(data);
    	
    	if(root==null){
    		root=toAdd;
    		size++;
    		return true;
    	}
    	
    	else{
    		Node<T> current=root;
    		Node<T> parent;
    		
    		while(true){
    			parent=current;
    			
    			//avoid duplicates
    			if(current.data.compareTo(data)==0){
    				return false;
    			}
    			
    			//go left or right
    			if(toAdd.data.compareTo(current.data)<1){
    				current=current.left;
    				if(current==null){
    					parent.left=toAdd;
    					size++;
    					return true;
    				}
    			}
    			
    			else{
    				current=current.right;
    				if(current==null){    
    					parent.right=toAdd;
    					size++;
    					return true;
    				}
    			}
    		}
    	}
    }
    
    /**
     * Searches the tree after specific data.
     * @return true if tree contains the data, returns false if the tree doesn't
     * 
     * Tidskomplexiteten för denna metod är O(n) eftersom i värsta fall ligger alla element efter varandra utan att grena sig och då kan det sökta elementet ligga sist så att man måste gå igenom alla element för att hitta det.
     */
    public boolean contains(T data){
    	
    	if(data==null){
    		return false;
    	}
    	
    	Node<T> current=root;
    	
    	while(current!=null){
    		
    		//if match, return true
    		if(current.data.compareTo(data)==0)
    			return true;
    		
    		//if less take the left path
    		if(data.compareTo(current.data)<0){
    			current=current.left;
    		}
    		//if more take the right path
    		else{
    			current=current.right;
    		}
    		
    	}
    	
    	//if not found until now, return false
    	return false;
    }
    

    /**
     * Calculates the depth of the tree.
     * The depth of the tree is the longest branch from the root.
     * 
     * @return the depth of the tree, the number of nodes in the longest branch
     * 
     * Tidskomplexiteten för denna metod är O(n). För att räkna ut djupet måste man i värsta fall gå igenom alla element om dem ligger på rad utan att grena sig.
     */
    
    public int depth(){
    	return depthOfNode(root);
    }
    
    /**
     * Calculates the depth of a given node.
     * @param n - node you want to know the depth of.
     * @return the depth of the node.
     */
    private int depthOfNode(Node<T> n) {
    	 //if root is null, return 0
    	  if (n==null){
    		  return 0;
    	  }
    	  else{
    		  //Calculate the depth of the left and right path
    		  int leftDepth=depthOfNode(n.left)+1;
    		  int rightDepth=depthOfNode(n.right)+1;
    		  
    		  //Return the longest path
    		  if(leftDepth > rightDepth){
    			  return leftDepth;
    		  }
    		  else{
    			  return rightDepth;
    		  }
    	  }
    }
    
    /**
     * Calculates the number of leafs in the tree.
     * A leaf is a node without any children.
     * @returns the amount of leafs
     * 
     * Tidskomplexiteten för denna metod är O(n) eftersom man i värsta fall måste gå igenom alla element om dem är dåligt spridda och inte grenar sig.
     */
    
    public int numberOfLeafs(){
    	return leafsInNode(root);
    }
    
    /**
     * Calculates the number of leafs in a node.
     * Leafs are nodes without any children.
     * @param node - node you want to calculate the number of leafs in.
     * @return the number of leafs under the node.
     */
    private int leafsInNode(Node<T> node)
    {
        if(node==null) {
            return 0;
        }
        
        if(node.left==null && node.right==null) {
            return 1;
        }
        
        else{
        	return leafsInNode(node.left) + leafsInNode(node.right);
        }
        
    }
    
   
    
    /**
     * Creates an empty tree.
     */
    public Tree() {
    	size=0;
    	root=null;
    }


    /**
     * Returns the number of elements in this tree.
     * 
     * Tidskomplexiteten för denna metod är O(1). Man bara returnerar ett värde.
     */
    public int size() {

        return size;
    }

    /**
     * Returns a string representation of this tree. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     * 
     * Tidskomplexiteten för denna metod är O(n). Man måste gå igenom alla element för att bygga strängen.
     */
    
    //private variables used for building the string.
    private String stringToBuild;
    private int nodesCollected;
    
    public String toString() {
    	
    	if(size<=0){
    		return "[]";
    	}
    	
    	stringToBuild="[";
    	nodesCollected=0;
    	
    	buildString(root);
    	return stringToBuild;
    }
    
    /**
     * A helper method for building the string.
     */
    private void buildString(Node<T> current){
    	if(current!=null){
    		buildString(current.left);
    		
    		stringToBuild+=current.toString();
    		nodesCollected++;
    		
    		if(nodesCollected<size){
    			stringToBuild+=", ";
    		}
    		else{
    			stringToBuild+="]";
    		}
    		
    		buildString(current.right);
    	}
    }
}