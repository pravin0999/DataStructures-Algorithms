class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
		public void printInOrder(){
			if(left != null){
				left.printInOrder();
			}
			System.out.println(data);
			if(right != null){
				right.printInOrder();
			}
		}
	}

public class Tree {
	
	//Node root;
	public void insert(Node root, int value){
		//Node head = root;
		if(root == null){
			root = new Node(value);
			return;
		}else if(root.data > value){
			if(root.left == null){
				root.left = new Node(value);
			}else{
				insert(root.left, value);
			}
		}else if(root.data < value){
			if(root.right == null){
				root.right = new Node(value);
			}else{
				insert(root.right, value);
			}
		}
		
	}
	public boolean contain(Node root, int value){
		if(root == null){return false;}
		if(value == root.data){
			return true;
		}else if(value < root.data){
			if(root.left == null){
				return false;
			}else{
				return contain(root.left, value);
			}
		}else{
			if(root.right == null){
				return false;
			}else{
				return contain(root.right, value);
			}
		}
	}
	
	public Node deleteData(Node root, int value){
		if(root == null){return null;}
		else if(value < root.data){
			root.left = deleteData(root.left, value);
		}else if(value > root.data){
			root.right = deleteData(root.right, value);
		}else{
			//case 1: No child
			if(root.left == null && root.right == null){
				root = null;
			}//case 2: Only one child
			else if(root.left == null){
				root = root.right;
			}else if(root.right == null){
				root = root.left;
			}//case 3: 2 children
			else{
				Node temp = findMin(root.right);
				root.data = temp.data;
				root.right = deleteData(root.right, temp.data);
			}
		}
		return root;
	}
	
	public Node findMin(Node root){
		if(root == null){return null;}
		while(root.left != null){
			root = root.left;
		}
		return root ;
	}
	
	public static void main(String[] args){
		Tree t = new Tree();
		Node n = new Node(1);
		t.insert(n, 2);
		t.insert(n, 3);
		t.insert(n, 10);
		t.insert(n, 13);
		t.insert(n, 4);
		t.insert(n, 12);
		t.insert(n, 8);
		System.out.println("is n contains 8:" + t.contain(n, 8));
		n.printInOrder();	
		t.deleteData(n, 13);
		t.deleteData(n, 2);
		n.printInOrder();
	}
}
