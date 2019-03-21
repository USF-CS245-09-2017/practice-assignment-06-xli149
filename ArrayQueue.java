public class ArrayQueue<T> implements Queue<T>{
	//Data members.
	int head;
	int tail;
	Object []temp = new Object[500];
	T []arr;
	//Constructor.
	public ArrayQueue(){
		head = 0;
		tail = 0;
		arr = (T[])temp; 

	}
	//Remove item from the top.
	public T dequeue(){
		try{
			if(empty()){
				throw new Exception("Failed");
			}
		}
		catch(Exception e){
			System.out.println("empty....");
		}
		T temp = arr[head];
		head = (head + 1) % arr.length;
		return temp;
	} 
	/** Add item to the last.
	 * @param item: item to be added in the queue
	 */
	public void enqueue(T item){
		if((tail + 1) % arr.length == head){
			growArray();
		}
		arr[tail++] = item;
		tail = tail % arr.length;
	}
	//Check if the stack is empty.
	public boolean empty(){
		if(head == tail){
			return true;
		}
		return false;
	}
	//If the array is full, resize it
	public void growArray(){
		Object []temparr1 = new Object[arr.length * 2];
		T[] temparr = (T[]) temparr1;

		if(head < tail){
			int j = 0;
			for(int i = head; i < tail; i++){
				temparr[j++] = arr[i];
			}
			head = 0;
			tail = arr.length - 1;
		}
		else{
			int i = 0;
			int j = head;
			int k = 0;
			while(j < arr.length){
				temparr[i++] = arr[j++];
			}
			while(k < tail){
				temparr[i++] = arr[k++];
			}
			head = 0;
			tail = arr.length - 1;
		}
		arr = temparr;	
	}
}