package esercizio3;

public interface Queue<T> {

	public void insert(T elem);
	public T extractMin();
	public void updatePriority(int position, T priority);
	public void updatePriorityFirstOccurrence(T data);
	public T getData(int position);
	public int getSize();

}
