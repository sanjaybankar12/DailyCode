package com.utility;


public class RemoveDuplicateLinkedListEx {

	public static Node insertNode(Node head, int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
		} else if(head.next == null) {
			head.next = node;
		} else {
			Node start = head;
			while(start.next != null) {
				start = start.next;
			}
			start.next = node;
		}
		return head;
	}
	
	public static void displayNode(Node head) {
		Node start = head;
		while(start != null) {
			System.out.print(" -> " + start.data);
			start = start.next;
		}
		System.out.println();
	}
	
	/**
	 * This method will remove adjacent node only
	 * @param head
	 * @return
	 */
	public static Node removeAdjacentDuplicates(Node head) {

		if(head == null || head.next == null) {
			return head;
		}
		
		if(head.data == head.next.data) {
			head.next = head.next.next;
			removeAdjacentDuplicates(head);
		} else {
			removeAdjacentDuplicates(head.next);
		}		
		return head;
	}
	
	public static Node removeDuplicates(Node head) {
		Node start = head;
		
		Node firstNode = head;
		while(firstNode != null) {
			int data = firstNode.data;					
			boolean val = isNodeRemovable(start, data, firstNode.next);
			if(val) {
				firstNode = firstNode.next;
				System.out.println("remove : " + data);
			} else {
			
				firstNode = firstNode.next;
			}
		}		
		return firstNode;
	}
	
	public static boolean isNodeRemovable(Node head, int data, Node refNode) {
		Node start = head;
		while (start != null) {
			if (start.data == data) {
				if (start.next != null && refNode != null && start.next.hashCode() != refNode.hashCode()) {
					start = start.next.next;
					return true;
				} else if (start.next == null && refNode != null) {
					return true;
				} else
					start = start.next;
			} else {
				start = start.next;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,5,6,2,5,8,9,1};
		
		Node head = null;
		for(int n : arr) {
			head = insertNode(head, n);
		}
		System.out.println("Original List : ");
		displayNode(head);
		System.out.println("After removing duplicates : ");
		head = removeDuplicates(head);
		displayNode(head);

		
	}
}
