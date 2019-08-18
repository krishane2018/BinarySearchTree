
public class BSTDictionary<E, K extends Sortable> implements Dictionary<E, K> {

	private BSTNode<E, K> root;
	private int maxDepth;

	public BSTDictionary() {
		root = null;
		maxDepth = 0;
	}

	@Override
	public E search(K key) { // Searches for an element using specified key
		return searchItem(root, key);

	}

	private E searchItem(BSTNode<E, K> tNode, K key) { 	// Helper method used to traverse tree to
														// find element.
		E treeItem;

		if (tNode == null) {
			treeItem = null;
		} else {
			if (key.compareTo(tNode.getKey()) == 0) {
				treeItem = tNode.getElement();
			} else if (key.compareTo(tNode.getKey()) < 0) {
				treeItem = searchItem(tNode.getLeft(), key);
			} else {
				treeItem = searchItem(tNode.getRight(), key);
			}
		}
		return treeItem;
	}

	@Override
	public void insert(K key, E element) {	// Inserts node into tree
		BSTNode<E, K> newItem = new BSTNode<E, K>(key, element, null, null);
		root = insertItem(root, newItem);
	}

	private BSTNode<E, K> insertItem(BSTNode<E, K> tNode, BSTNode<E, K> newItem) {
		BSTNode<E, K> newSubtree;				// Helper method which is used to determine the  
		if (tNode == null) {					// correct place to insert node and the inserts the  
			tNode = newItem;					// node.
			return tNode;
		}
		if (newItem.getKey().compareTo(tNode.getKey()) < 0) {
			newSubtree = insertItem(tNode.getLeft(), newItem);
			tNode.setLeft(newSubtree);
			return tNode;
		} else {
			newSubtree = insertItem(tNode.getRight(), newItem);
			tNode.setRight(newSubtree);
			return tNode;
		}
	}

	@Override
	public void delete(K key) {				// Deletes node from tree.
		root = deleteItem(root, key);

	}

	private BSTNode<E, K> deleteItem(BSTNode<E, K> tNode, K key) {	//Helper method used to traverse
		BSTNode<E, K> newSubtree;				 					//tree and find node to delete	
		if (tNode == null) {
		} else {
			if (key.compareTo(tNode.getKey()) == 0) {
				tNode = deleteNode(tNode);
			} else if (key.compareTo(tNode.getKey()) < 0) {
				newSubtree = deleteItem(tNode.getLeft(), key);
				tNode.setLeft(newSubtree);
			} else {
				newSubtree = deleteItem(tNode.getRight(), key);
				tNode.setRight(newSubtree);
			}
		}
		return tNode;
	}

	private BSTNode<E, K> deleteNode(BSTNode<E, K> tNode) { // Helper method used to delete node
		BSTNode<E, K> replacementItem;						// correctly from tree
		if (tNode.getLeft() == null && tNode.getRight() == null) {
			return null;
		}

		else if (tNode.getLeft() == null) {
			return tNode.getRight();
		}

		else if (tNode.getRight() == null) {
			return tNode.getLeft();
		} else {
			BSTNode<E, K> tempTNode = tNode;
			replacementItem = findLeftmost(tempTNode.getRight());
			tNode = replacementItem;
			tNode.setRight(deleteLeftmost(tempTNode.getRight()));
			tNode.setLeft(tempTNode.getLeft());
			return tNode;
		}
	}

	private BSTNode<E, K> findLeftmost(BSTNode<E, K> tNode) {	// Helper method used to find the 
		if (tNode.getLeft() == null) {							// left most node in the specified 
			return tNode;										// node.
		} else {
			return findLeftmost(tNode.getLeft());
		}
	}

	private BSTNode<E, K> deleteLeftmost(BSTNode<E, K> tNode) {	// Helper method used to delete the
		if (tNode.getLeft() == null) {							// left most node in the specified
			return tNode.getRight();							// tree.
		}

		else {
			tNode.setLeft(deleteLeftmost(tNode.getLeft()));
			return tNode;
		}
	}

	@Override
	public void printTree() {						// Prints tree in order based on keys of nodes.
		System.out.println(printHelper(root));

	}

	private String printHelper(BSTNode<E, K> node) {// Helper method that returns string 
		if (node == null) {							// representation of nodes in tree ordered by 
			return "";								// their keys.
		} else {
			String nodeString = "key: "+node.getKey()+", element: "+node.getElement()+"\n";
			return (printHelper(node.getLeft()) + nodeString + printHelper(node.getRight()));
		}
	}

	@Override
	public int depth() {		//Returns the depth of the tree.
		maxDepth = 0;
		depthHelper(root, 1);
		return maxDepth;
	}

	private void depthHelper(BSTNode<E, K> node, int depth) {// Helper method to determine the depth
		if (node == null) {									// of the tree.
			return;
		} else {
			if (depth > maxDepth) {
				maxDepth = depth;
			}
			depthHelper(node.getLeft(), depth + 1);
			depthHelper(node.getRight(), depth + 1);
		}
	}

}
