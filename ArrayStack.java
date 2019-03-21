public class ArrayStack<T> implements Stack<T>{
	//Data members.
	int top;
	Object []temp = new Object[500];
	T[] arr;
	//Constructor.
	public ArrayStack(){
		arr = (T[])temp;
		top = -1;
	}
	/** Puts the argument on the top of the stack.
	 * @param item: The item to be added 
	 */
	public void push(T item){
		//System.out.println("SIZE: " + top);
		if(top == arr.length - 1){
			//System.out.println("Bbbb");
			growArray();
		}
		arr[++top] = item;
	}
	//Removes & returns the Object at the top of the stack.
	public T pop(){
		try{
			if(empty()){
				throw new Exception("Failed");
			}
		}
		catch(Exception e){
			System.out.println("empty....");
		}

		return arr[top--];
	}
	//Returns a copy of the top of the stack.
	public T peek(){
		try{
			if(empty()){
				throw new Exception();
			}
		}
		catch(Exception e){
			System.out.println("empty....");
		}
		return arr[top];
	}
	//Returns true if nothing is on the stack.
	public boolean empty(){
		if(top == -1){
			return true;
		}
		return false;
	}
	public void growArray(){
		Object []temparr1 = new Object[arr.length * 2];
		T[] tempArr = (T[]) temparr1;
		for(int i = 0; i < arr.length; i++){
			tempArr[i] = arr[i];
		} 
		arr = tempArr;
	}
}