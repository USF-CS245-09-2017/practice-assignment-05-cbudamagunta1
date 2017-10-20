
public class BSTree {

////////////////////////////////////////////////////////////////////	
	
	class BSTNode {

		public String data;
		public BSTNode right;
		public BSTNode left;
		
		
		public BSTNode(String newData, BSTNode newRight, BSTNode newLeft) {
			data = newData;
			right = newRight;
			left = newLeft;
		}
		
		public BSTNode(String newData) {
			data = newData;
			right = null;
			left = null;
		}
		
	}

////////////////////////////////////////////////////////////////////	
	
	private BSTNode root;
	
	void BSTNode(){
		root = null;
	}
	
////////////////////////////////////////////////////////////////////	
	
	public void insert(String value) {
		
			root = insert(value, root);
	}
	
	
	private BSTNode insert(String value, BSTNode node) {
		
		if(node == null) {
			return new BSTNode(value);
		}
		
		if(value.compareTo(node.data) < 0) {
			node.left = (insert(value, node.left)); 
			return node;
		}else {
			node.right = (insert(value, node.right));
			return node;
		}
	}
	
////////////////////////////////////////////////////////////////////	
	
	public boolean find(String value) {
		return find(value, root);
	}
		
	
	private boolean find(String value, BSTNode node) {
		
		if(node==null) {
			return false;
		}
		
		if(value.compareTo(node.data) == 0) {
			return true;
		}else if(value.compareTo(node.data) < 0) {
			return find(value, node.left);
		}else {
			return find(value, node.right);
		}
	}
	
////////////////////////////////////////////////////////////////////
	
	public void delete(String data) {
		
			root = delete(data, root);
	}
	
	private BSTNode delete(String value, BSTNode node) {
		
		if(node == null) {
			return null;
		}
		
		if(node.data.compareTo(value) == 0) {
			
			if(node.left==null) {
				return node.right;
			}else if(node.right==null){
				return node.left;
			}
			
			if(node.right.left == null) {
				node.data = (node.right.data);
				node.right = (node.right.right);
				return node;
			}else {
				node.data = (removeSmallest(node.right));
				return node;
			}
		}
		
		return null;
	}
	
	
	private String removeSmallest(BSTNode node) {
		if(node.left.left == null) {
			String smallest = node.left.data;
			node.left = (node.left.right);
			return smallest;
		}
		
		return removeSmallest(node.left);
	}
	
////////////////////////////////////////////////////////////////////
	
	public String toStringInOrder() {
		
		String finalString = "";
		return toStringInOrder(root, finalString).trim();
		
	}
	
	private String toStringInOrder(BSTNode node, String finalString) {
		
		if(node!=null) {
			
			finalString = toStringInOrder(node.left, finalString);
			finalString += (node.data + " ");
			finalString = toStringInOrder(node.right, finalString);
			
			return finalString;
	
		}
		return finalString;
	}
	
////////////////////////////////////////////////////////////////////
	
	public String toStringPreOrder() {
		
		String finalString = "";
		return toStringPreOrder(root, finalString).trim();
		
	}
	
	private String toStringPreOrder(BSTNode node, String finalString) {
		
		if(node!=null) {
			
			finalString += (node.data + " ");
			finalString = toStringPreOrder(node.left, finalString);
			finalString = toStringPreOrder(node.right, finalString);
			
			return finalString;
		}
		return finalString;
	}
	
////////////////////////////////////////////////////////////////////	
	
}
