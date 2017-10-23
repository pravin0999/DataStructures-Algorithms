
public class Queue {
	private static class Node{
		private int data;
		private Node next;
		private Node(int data){
			this.data = data;
		}
	}
	private Node head; // remove elements here
	private Node tail; // add the elements here
	public boolean isEmpty(){
		return head == null;
	}
	public int peek(){
		if(head != null){return head.data;}
		return -1;
	}
	public void add(int data){
		Node node = new Node(data);
		if(tail != null){
			tail.next = node;
		}
		tail = node;
		if(head == null){
			head = node;
		}
	}
	public int remove(){
		int data = head.data;
		head = head.next;
		if(head == null){
			tail = null;
		}
		return data;
	}
	
}

