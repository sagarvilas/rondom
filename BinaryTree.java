package org.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {

	class NodeItem implements Comparable<NodeItem> {
		TreeNode node;
		int distance;

		NodeItem(TreeNode n, int d) {
			node = n;
			distance = d;
		}

		@Override
		public int compareTo(NodeItem o) {
			if (this.distance < o.distance)
				return -1;
			if (this.distance > o.distance)
				return 1;
			return 0;
		}
		

		@Override
		public String toString() {
			return String.format("NodeItem [node=%s, distance=%s]", node, distance);
		}
	}

	TreeNode root;
	Map<TreeNode, Integer> map = new LinkedHashMap();

	List<NodeItem> distanc = new ArrayList<NodeItem>();

	public void addNode(int key, String value) {
		TreeNode newNode = new TreeNode(key, value);

		if (root == null) {
			root = newNode;
		} else {
			TreeNode currentNode = root;
			TreeNode parent;
			while (true) {
				parent = currentNode;
				if (key < currentNode.key) {
					currentNode = currentNode.left;
					if (currentNode == null) {
						parent.left = newNode;
						return;
					}
				} else {
					currentNode = currentNode.right;
					if (currentNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public List<Integer> inOrderTraaversal(TreeNode root, List<Integer> l) {
		if (root != null) {
			inOrderTraaversal(root.left, l);
			l.add(root.key);
			inOrderTraaversal(root.right, l);
		}
		return l;
	}

	public void preOrderTraaversal(TreeNode root) {
		if (root != null) {
			System.out.println(root);
			preOrderTraaversal(root.left);
			preOrderTraaversal(root.right);
		}
	}

	public void postOrderTraaversal(TreeNode root) {
		if (root != null) {
			preOrderTraaversal(root.left);
			preOrderTraaversal(root.right);
			System.out.println(root);
		}
	}

	public void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.println(temp.key);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	public void topView(TreeNode root) {
		if (root == null)
			return;

		HashSet<Integer> set = new HashSet();
		for (int i = 0; i < distanc.size(); i++) {
			NodeItem temp = distanc.get(i);
			if (!set.contains(temp.distance)) {
				set.add(temp.distance);
				System.out.println(temp.node.key);
			}
		}

	}

	public TreeNode findLCA(TreeNode root, int n1, int n2) {

		if (root == null || root.key == n1 || root.key == n2) {
			return root;
		}

		TreeNode leftLCA = findLCA(root.left, n1, n2);
		TreeNode rightLCA = findLCA(root.right, n1, n2);
		if (leftLCA != null && rightLCA != null)
			return root;

		return leftLCA != null ? leftLCA : rightLCA;
	}

	public List getDistances() {
		horizontalDistance(root, 0);
		return distanc;
	}

	public void horizontalDistance(TreeNode node, Integer hd) {
		if (node == null)
			return;
		if (node.left != null) {
			horizontalDistance(node.left, hd - 1);
		}
		distanc.add(new NodeItem(node, hd));
		if (node.right != null) {
			horizontalDistance(node.right, hd + 1);
		}
	}

	public int height(TreeNode node) {
		if (node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		if (lheight > rheight)
			return lheight + 1;
		else
			return rheight + 1;
	}

	public int diameter(TreeNode node) {
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		
		int ldiameter = diameter(node.left);
		int rdiameter = diameter(node.right);
		
		return Math.max(1+lheight+rheight, Math.max(ldiameter,rdiameter) );
	}

	public TreeNode find(int key) {
		TreeNode currNode = root;
		while (key != currNode.key) {
			if (key < currNode.key)
				currNode = currNode.left;
			else
				currNode = currNode.right;
			if (currNode == null)
				return null;
		}
		return currNode;
	}

	public void rightView(TreeNode root) {
		if (root != null)
			System.out.println(root);
		if (root.right != null)
			rightView(root.right);
		else if (root.left != null)
			rightView(root.left);
	}

	public void nodeWithSum(int s) {
		TreeNode temp = root;
		List<TreeNode> l = new LinkedList();
		while (temp.key <= s) {

		}
	}

	int index = 0;

	public TreeNode makeBTree(int inorder[], int preorder[], int start, int end) {
		if (start > end)
			return null;

		TreeNode root = new TreeNode(preorder[index], "");
		index++;

		if (start == end)
			return root;

		int i = getInorderIndex(inorder, start, end, root.key);
		root.left = makeBTree(inorder, preorder, start, i - 1);
		root.right = makeBTree(inorder, preorder, i + 1, end);
		return root;
	}

	public int getInorderIndex(int inorder[], int start, int end, int val) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == val)
				return i;
		}

		return -1;
	}

	public ArrayList<List<TreeNode>> levelOrderList(TreeNode root) {
		ArrayList<List<TreeNode>> lists = new ArrayList();
		List<TreeNode> current = new LinkedList();
		if (root != null)
			current.add(root);

		while (current.size() > 0) {
			lists.add(current);
			List<TreeNode> parents = current;
			for (TreeNode n : parents) {
				if (n.right != null)
					current.add(n);
				if (n.left != null)
					current.add(n);
			}
		}
		return lists;
	}
	
    public TreeNode deleteNode(TreeNode root, int key) {
        delete(root, key);
        return root;
    }
    
    public TreeNode delete(TreeNode node, int key){
        if(node == null)
            return node;
       if(node.key < key) {
    	   node.right = delete(node.right, key);
       } else if(node.key > key) {
    	   node.left = delete(node.left, key);
       } else {
    	   if(node.left == null)
    		   return node.right;
    	   else if(node.right == null)
    		   return node.left;
    	   
    	   node.key = minVal(node.right);
    	   node.right = delete(node.right, node.key);
       }
       return node;
    }
    
    public int minVal(TreeNode n) {
    	int min = n.key;
    	while(n.left != null)
    	{
    		min = n.left.key;
    		n = n.left;
    	}
    	return min;
    }
}
