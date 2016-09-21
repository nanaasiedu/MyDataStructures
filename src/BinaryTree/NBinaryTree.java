package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NBinaryTree<V> {
	private Node<V> root;
	
	public NBinaryTree() {
		this.root = null;
	}
	
	public void insert(V value) {
		Node<V> newNode = new Node<V>(value);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Queue<Node<V>> queue = new LinkedList<Node<V>>();
		queue.add(root);
		
		while (true) {
			Node<V> curr = queue.remove();
			
			if (curr.left == null) {
				curr.setLeft(newNode);
				break;
			} else {
				queue.add(curr.getLeft());
			}
			
			if (curr.right == null) {
				curr.setRight(newNode);
				break;
			} else {
				queue.add(curr.getRight());
			}
			
		}
		
	}
	
	public Node<V> find(V value) {
		Queue<Node<V>> queue = new LinkedList<Node<V>>();
		queue.add(root);
		
		while(true) {
			if (queue.isEmpty()) {
				return null;
			}
		}
		
	}
	
	private class Node<V> {
		private V value;
		private Node<V> left;
		private Node<V> right;

		Node(V value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		Node(V value, Node<V> left, Node<V> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
		
		public V getValue() {
			return value;
		}
		
		public Node<V> getLeft() {
			return left;
		}
		
		public void setLeft(Node<V> left) {
			this.left = left;
		}
		
		public Node<V> getRight() {
			return right;
		}
		
		public void setRight(Node<V> right) {
			this.right = right;
		}
	}
}
