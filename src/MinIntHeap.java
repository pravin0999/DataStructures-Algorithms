
public class MinIntHeap {
	private int capacity = 20;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex + 1; }
	private int getRightChildIndex(int parentIndex){ return 2 * parentIndex + 2; }
	private int getParentIndex(int childIndex){ return (childIndex-1) / 2; }
	
	private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size; }
	private boolean hasRightChild(int index){ return getLeftChildIndex(index) < size; }
	private boolean hasParent(int index){ return getParentIndex(index) >= 0; }
	
	private int leftChild(int index){ return items[getLeftChildIndex(index)]; }
	private int rightChild(int index){ return items[getRightChildIndex(index)]; }
	private int parent(int index){ return items[getParentIndex(index)]; }
	
	private void swap(int indexOne, int indexTwo){
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	private void ensureExtraCapacity(){
		if(size == capacity){
			//items = Array.copyOf(items, capacity * 2);
			capacity *= 2; 
		}
	}
	
	public int peek(){
		if(size == 0){ throw new IllegalStateException(); }
		return items[0];
	}
	public int poll(){
		if(size == 0){ throw new IllegalStateException(); }
		int item = items[0];
		items[0] = items[size-1];	
		size--;
		heapifyDown();
		return item;
	}
	public void add(int item){
		//ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	public void heapifyUp(){
		int index  = size - 1;
		while(hasParent(index) && parent(index) > items[index]){
			swap(parent(index), items[index]);
			index = getParentIndex(index);
		}
	}
	public void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < smallerChildIndex){
				smallerChildIndex = getRightChildIndex(index);
			}
			if(items[index] < items[smallerChildIndex]){
				break;
			}else{
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
		
	}
	public static void main(String[] args){
		MinIntHeap h = new MinIntHeap();
		h.add(8);
		h.add(10);
		h.add(5);
		h.add(7);
		h.add(2);
		h.add(9);
		//System.out.println(h.peek());
		for(int i = 0; i < h.items.length; i++){System.out.println(h.items[i]);}
		
		
	}
}
