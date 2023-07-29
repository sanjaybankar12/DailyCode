package com.utility;

 public class Node {
	Node next;
	int data;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [next=" + next + ", data=" + data + "]";
	}
	
	
}
