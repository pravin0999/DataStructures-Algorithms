
public class LinkedList {
 public class Node{
	 private Node next;
	 private int data;
	 public Node(int data){
		 this.data = data;
	 }
 }
 
 Node head;
 public void append(int data){
	 if(head == null){
		 head = new Node(data);
		 return;
	 }
	 Node current = head;
	 while(current.next != null){
		 current = current.next;
	 }
	 current.next = new Node(data);
 }
 public void prepend(int data){
	 Node newHead = new Node(data);
	 newHead.next = head;
	 head = newHead;
 }
 public void deleteWithValue(int data){
	 if(head == null){
		 return;
	 }
	 if(head.data == data){
		 head = head.next;
		 return;
	 }
	 Node current = head;
	 while(current.next != null){
		 if(current.next.data == data){
			 current.next = current.next.next;
			 return;
		 }
		 current = current.next;
	 }
 }
 public void printList(){
	 Node current = head;
	 while(current != null){
		 System.out.println(current.data);
		 current = current.next;
	 }
 }
 
 public static void main(String[] args){
	 LinkedList l = new LinkedList();
	 l.append(1);
	 l.append(2);
	 l.append(3);
	 l.append(4);
	 l.printList();
	 l.deleteWithValue(2);
	 l.printList();
 }
}
