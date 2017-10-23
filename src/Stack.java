
public class Stack {
	private class Node{
		private int data;
		private Node next;
		private Node(int data){
			this.data = data;
		}
	}
	private Node top;
	
	public boolean isEmpty(){
		return top == null;
	}
	public int peek(){
		if(top != null){return top.data;}
		return -1;
	}
	public void push(int data){
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	public int pop(){
		if(top == null){return -1;}
		int data = top.data;
		if(top.next != null){
			top = top.next;
		}else{
			top = null;
		}
		return data;
	}
	
	public static void main(String[] args){
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
	}
}
