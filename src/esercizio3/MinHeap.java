package esercizio3;

import java.util.Comparator;
import java.util.ArrayList;

public class MinHeap<T> implements Queue<T>{

	private ArrayList<T> heap;
	private int size;
	private Comparator<T> comparator;
	/**
     * costructor
     * @param comparator
     */
	public MinHeap(Comparator<T> comparator){
		this.heap = new ArrayList<T>();
		this.size = 0;
		this.comparator = comparator;
		this.heap.add(size, null);
	}
	/**
     * get the elem at position
     * @param position
     * @return 
     */
	public T getData(int position){
		return heap.get(position);
	}
	/**
     * return the parent
     * @param position
     * @return
     */
	private int getParent(int position){
		return position/2;
	}
	/**
     * return the left child
     * @param position
     * @return
     */
	private int getLeft(int position){
		if((2 * position) <= this.size)
			return 2 * position;
		return position;
	}
	/**
     * return the right child
     * @param position
     * @return
     */
	private int getRight(int position){
		if((2 * position) + 1 <= this.size)
			return (2 * position) + 1;
		return position;
	}
	/**
     * get size
     * @return
     */
	public int getSize(){
		return size;
	}
	/**
     * swap two elements
     * @param i
     * @param j
     */
	private void swap(int i, int j){
		T tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
	}
	/**
     * return if heap is empty
     * @return
     */
	public boolean empty(){
		if(size == 0)
			return true;
		return false;
	}
	/**
     * insert an element 
     * @param elem
     */
	public void insert(T data){
		size++;
		int lastPos = size;
		heap.add(data);
		while(lastPos > 1 && (comparator.compare(heap.get(lastPos), heap.get(getParent(lastPos))) < 0)){
			swap(lastPos, getParent(lastPos));
			lastPos = getParent(lastPos);
		}
	}
	/**
     * makes a branch "heap"
     * @param position
     */
	private void heapify(int position){
		int minPos = min(position, getLeft(position), getRight(position));
		if(minPos != position){
			swap(position, minPos);
			heapify(minPos);
		}
	}
	/**
     * return the min 
     * @return
     */
	private int min(int x, int y, int z){
		int min = x;
		if(comparator.compare(heap.get(min), heap.get(y)) > 0) min = y;
		if(comparator.compare(heap.get(min), heap.get(z)) > 0) min = z;
		return min;
	}
	/**
     * remove the min element
     */
	public T extractMin(){
		if(!empty()){
			T data = heap.get(1);
			swap(1, this.size);
			heap.remove(this.size);
			this.size--;
			if(this.size > 0) heapify(1);
			return data;
		}
		return null;
	}
	/**
	 * 
	 * @param position
	 * @param newPriority
	 */
	public void updatePriority(int position, T newData){
		if(position <= size && position > 0){
			heap.set(position, newData);
			while(position > 1 && (comparator.compare(heap.get(position), heap.get(getParent(position))) < 0)){
				swap(position, getParent(position));
				position = getParent(position);
			}
			heapify(position);
		}
	}
	
	public void updatePriorityFirstOccurrence(T data){
		int i = 1;
		while(i <= this.size){
			if(data.equals(heap.get(i))){
				updatePriority(i, data);
				break;
			}
			i++;
		}
	}
		
	@Override
	public String toString(){
		String s = "{";
		for(int i = 1; i <= this.size; i++){
			s += heap.get(i);
			if(i < size) s += ", ";
		}
		return s + "}";
	}
}
