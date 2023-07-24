package com.utility;

class Node {
	Node next;
	int data;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MiddleLinkedListEx {
	
	public static Node buildLinkedList(int num) {
		Node head = null;
		for(int i = num;i > 0; i--) {
			Node node = new Node(i);
			node.next = head;
			head = node;
		}
		return head;
	}
	
	public static void printLinkedList(Node head) {
		String nodeStr = "";
		Node temp = head;
		while(temp != null) {
			//System.out.println("Node value = " + temp.data);
			nodeStr += " -> " + temp.data;
			temp = temp.next;
		}
		
		if(head != null)
			System.out.println("LinkedList :"+ nodeStr);
		else
			System.out.println("LinkedList is empty");
	}
	
	public static void findMiddleNode(Node head) {
		Node slowNode = head;
		Node fastNode = head;
		while(fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		
		if(slowNode != null)
			System.out.println("Middle Node : " + slowNode.data);
	}
	
	public static void main(String[] args) {

		Node head = buildLinkedList(15);		
		printLinkedList(head);
		findMiddleNode(head);
	}	

}
